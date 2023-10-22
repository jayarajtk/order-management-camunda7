package org.jay.order.management.camel;

import org.apache.camel.Exchange;

import java.util.Map;

public class TransformationService {
    protected boolean preCondition(Exchange exchange) {
        exchange.getProperties().putAll((Map<String, ?>) exchange.getIn().getBody());
        return true;
    }

    protected Object transform(Exchange exchange) {
        String order = (String) exchange.getProperties().get("order");
        System.out.println("order: " + order);
        System.out.println("Props: " + exchange.getProperties());
        return null;
    }

    protected void processResponse(Exchange exchange) {
        System.out.println("ProcessResponse");
    }
}