package org.jay.order.management.camel.process;

import org.apache.camel.Exchange;
import org.jay.order.management.camel.TransformationService;
import org.springframework.stereotype.Component;

@Component
public class InquireAvailabilityTransformation extends TransformationService {
    @Override
    protected Object transform(Exchange exchange) {
        return super.transform(exchange);
    }

    @Override
    protected void processResponse(Exchange exchange) {
        super.processResponse(exchange);
    }
}
