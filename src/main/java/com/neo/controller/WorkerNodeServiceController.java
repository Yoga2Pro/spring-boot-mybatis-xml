package com.neo.controller;

import com.neo.service.WorkerNodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class WorkerNodeServiceController {
    @Resource
    private WorkerNodeService workerNodeService;

    @GetMapping("/uid")
    public long genUid(){
        return workerNodeService.genUid();
    }
}
