package org.jay.order.management.worker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoginVerification {
    public int getSLA(DelegateExecution execution) throws JsonProcessingException {
        String order = (String) execution.getVariable("order");
        return (Integer) (new ObjectMapper().readValue(order, Map.class)).get("sla");
    }
}