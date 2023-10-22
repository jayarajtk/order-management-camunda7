package org.jay.order.management.controller;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProcessController {

    @Autowired
    private RuntimeService runtimeService;

    @PostMapping(path = "/instance/start/{processId}")
    public ResponseEntity<Map> startProcessInstance(@RequestBody Map<String, Object> processInfo, @PathVariable String processId) {
        String orderId = (String) processInfo.get("orderId");
        if (null != processId) {
            processId = "Order_Management_7";
        }
//        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processId, processInfo);
//        ProcessInstanceWithVariables
        ProcessInstance processInstance = runtimeService.createProcessInstanceByKey(processId)
                .setVariables(processInfo)
                .businessKey(orderId)
                .execute();
//                .executeWithVariablesInReturn();
        Map result = new HashMap();
        result.put("processId", processInstance.getProcessInstanceId());
        result.put("instanceKey", processInstance.getBusinessKey());
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }
}