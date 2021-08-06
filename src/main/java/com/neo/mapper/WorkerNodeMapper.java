package com.neo.mapper;

import com.neo.model.WorkerNode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WorkerNodeMapper {

    int addWorkerNode(WorkerNode workerNodeEntity);


    WorkerNode getWorkerNodeByHostPort(@Param("host") String host, @Param("port") String port);

}
