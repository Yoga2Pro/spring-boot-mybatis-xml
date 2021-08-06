package com.neo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Data
@Getter
@Setter
public class WorkerNode {
    private Long id;
    private String hostName;
    private String port;
    private Integer type;
    private Date launchDate;
    private Date modified;
    private Date created;
}
