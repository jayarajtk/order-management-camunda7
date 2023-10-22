package org.jay.order.management.camel;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteStarter {
    @Autowired
    private ProducerTemplate producerTemplate;
}