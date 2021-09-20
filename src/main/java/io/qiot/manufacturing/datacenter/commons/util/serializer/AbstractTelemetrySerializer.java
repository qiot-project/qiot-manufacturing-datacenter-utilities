package io.qiot.manufacturing.datacenter.commons.util.serializer;

import io.qiot.manufacturing.datacenter.commons.domain.telemetry.AbstractTelemetryDTO;
import io.quarkus.kafka.client.serialization.ObjectMapperSerializer;

/**
 * There is an existing ObjectMapperSerializer that can be used to serialize all
 * data objects via Jackson. You may create an empty subclass if you want to use
 * Serializer/deserializer autodetection.<br>
 * <br>
 * The corresponding deserializer class needs to be subclassed.
 * 
 * @author andreabattaglia
 *
 */
public abstract class AbstractTelemetrySerializer<T extends AbstractTelemetryDTO>
        extends ObjectMapperSerializer<T> {
}
