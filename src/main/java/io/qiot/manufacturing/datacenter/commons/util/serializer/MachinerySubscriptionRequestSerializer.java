package io.qiot.manufacturing.datacenter.commons.util.serializer;

import io.qiot.manufacturing.datacenter.commons.domain.subscription.MachinerySubscriptionRequest;
import io.quarkus.kafka.client.serialization.ObjectMapperSerializer;

/**
 * @author andreabattaglia
 *
 */
public class MachinerySubscriptionRequestSerializer
        extends ObjectMapperSerializer<MachinerySubscriptionRequest> {

}
