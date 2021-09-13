package io.qiot.manufacturing.datacenter.commons.service.persistence.events;

import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.slf4j.Logger;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.exceptions.InfluxException;

import io.qiot.manufacturing.datacenter.commons.domain.telemetry.AbstractTelemetryDTO;
import io.qiot.manufacturing.datacenter.commons.exception.DataServiceException;

/**
 * @author andreabattaglia
 *
 * @param <M>
 */
public abstract class AbstractTimeseriesRepository<M extends AbstractTelemetryDTO>
        implements TimeseriesRepository<M> {

    @Inject
    Logger LOGGER;

    // public static final Long DATA_RETENTION_DAYS = -14L;
    protected InfluxDBClient influxDBClient;
    @ConfigProperty(name = "influxdb.connectionUrl")
    public String connectionUrl;
    @ConfigProperty(name = "influxdb.token")
    public String token;
    @ConfigProperty(name = "influxdb.orgId")
    public String orgId;
    @ConfigProperty(name = "influxdb.data.bucketId")
    public String bucketId;
    @ConfigProperty(name = "influxdb.data.bucketName")
    public String bucketName;

    protected void onStart() {
        LOGGER.info("Connecting to: {}, token: {}, org: {}, bucketId: {}",
                connectionUrl, token, orgId, bucketId);
        influxDBClient = InfluxDBClientFactory.create(connectionUrl,
                token.toCharArray(), orgId, bucketId);
        LOGGER.info("Connection health-check:\n{}",
                influxDBClient.health().toString());
    }

    protected void onStop() {
        influxDBClient.close();
    }

    @Override
    public void save(M data) throws DataServiceException {
        try (WriteApi writeApi = influxDBClient.makeWriteApi()) {

            LOGGER.info("Persisting telemetry {}", data);
            writeApi.writeMeasurement(WritePrecision.NS, data);
        } catch (InfluxException ie) {
            throw new DataServiceException(
                    "Error while writing data to Influx: " + ie.getMessage());
        }
    }

    @Override
    public void save(M data,WritePrecision wp) throws DataServiceException {
        try (WriteApi writeApi = influxDBClient.makeWriteApi()) {

            LOGGER.info("Persisting telemetry {}", data);
            writeApi.writeMeasurement(wp, data);
        } catch (InfluxException ie) {
            throw new DataServiceException(
                    "Error while writing data to Influx: " + ie.getMessage());
        }
    }
}