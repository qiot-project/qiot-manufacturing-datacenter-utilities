package io.qiot.manufacturing.datacenter.commons.service.persistence.events;

import com.influxdb.client.domain.WritePrecision;

import io.qiot.manufacturing.datacenter.commons.domain.telemetry.AbstractTelemetryDTO;
import io.qiot.manufacturing.datacenter.commons.exception.DataServiceException;

/**
 * @author andreabattaglia
 *
 * @param <M>
 */
public interface TimeseriesRepository<M extends AbstractTelemetryDTO> {

    /**
     * {@link WritePrecision} is expressed in nanoseconds.
     * 
     * @param data
     * @throws DataServiceException
     */
    void save(M data) throws DataServiceException;

    /**
     * @param data
     * @param wp
     * @throws DataServiceException
     */
    void save(M data, WritePrecision wp) throws DataServiceException;

}