package io.qiot.manufacturing.datacenter.commons.util.serializer;

import io.qiot.manufacturing.datacenter.commons.domain.subscription.MachinerySubscriptionRequest;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

/**
 * @author andreabattaglia
 *
 */
public class MachinerySubscriptionRequestDeserializer
        extends ObjectMapperDeserializer<MachinerySubscriptionRequest> {
    public MachinerySubscriptionRequestDeserializer() {
        super(MachinerySubscriptionRequest.class);
    }
}
