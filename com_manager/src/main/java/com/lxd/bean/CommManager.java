package com.lxd.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
public class CommManager {
    private Integer id;

    private String commId;
    private String commName;


    private String commAddres;

    private String commSize;

    private String totalNumHouse;

    private Integer greeGate;

    private String img;

    private String developersName;

    private String proManagerName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date createTime;

    private Integer type;

    private String propertyCode;

    private String blockNumberCode;

    private String peopleCard;

    private String totalNumberBuild;


}