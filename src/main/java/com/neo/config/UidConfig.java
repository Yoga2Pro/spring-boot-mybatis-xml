package com.neo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@MapperScan("com.baidu.fsg.uid.worker.dao")
@ImportResource(locations = {"classpath:/uid/cached-uid-spring.xml"})
public class UidConfig {
}