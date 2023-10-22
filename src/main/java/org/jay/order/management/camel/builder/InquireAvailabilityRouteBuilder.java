package org.jay.order.management.camel.builder;

import org.apache.camel.builder.RouteBuilder;
import org.jay.order.management.camel.process.InquireAvailabilityTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InquireAvailabilityRouteBuilder extends RouteBuilder {

    @Autowired
    private InquireAvailabilityTransformation inquireAvailabilityTransformation;

    @Override
    public void configure() throws Exception {
        from("direct:inquire-availability")
                .bean(inquireAvailabilityTransformation, "preCondition")
                .choice()
                .when(body()) // simple("${body} == true")
                .bean(inquireAvailabilityTransformation, "transform")
                .bean(inquireAvailabilityTransformation, "processResponse")
                .end();
    }
}
