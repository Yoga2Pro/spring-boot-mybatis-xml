package com.neo.service.impl;

import com.neo.service.WorkerNodeService;
import com.xfvape.uid.UidGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WorkerNodeServiceImpl implements WorkerNodeService {
    @Resource
    private UidGenerator uidGenerator;

    @Override
    public long genUid() {
        return uidGenerator.getUID();
    }
}
