/**
 * 
 */
package io.qiot.manufacturing.datacenter.commons.service.telemetry;

import javax.inject.Inject;

import org.slf4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.qiot.manufacturing.datacenter.commons.domain.telemetry.AbstractTelemetryDTO;
import io.qiot.manufacturing.datacenter.commons.exception.telemetry.TelemetryTransformationException;

/**
 * @author andreabattaglia
 *
 */
public abstract class AbstractTelemetryStreamProducer<M extends AbstractTelemetryDTO> {

    @Inject
    Logger LOGGER;

    @Inject
    ObjectMapper mapper;

    public String serialize(M telemetry)
            throws TelemetryTransformationException {

        String telemetryJson=null;
        try {
            telemetryJson = mapper.writeValueAsString(telemetry);
        } catch (JsonProcessingException e) {
            LOGGER.error(
                    "An exception occurred serializing the telemetry data object: "
                            + telemetry.toString(),
                    e);

            throw new TelemetryTransformationException(e);
        }
        LOGGER.debug("Output telemetry: {}", telemetryJson);
        return telemetryJson;

    }

}
