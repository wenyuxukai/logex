package com.xk.logex.enums;

import lombok.Getter;

@Getter
public enum LogLevelEnum {

    NO_OUT(1,"不输出"),
    OUT(2,"输出"),
    IMP_OUT(3,"重要输出");

    private int code;
    private String value;
    LogLevelEnum(int code,String value){
        this.code = code;
        this.value = value;

    }
}
