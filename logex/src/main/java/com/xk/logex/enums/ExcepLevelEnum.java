package com.xk.logex.enums;

import lombok.Getter;

@Getter
public enum ExcepLevelEnum {
    WARN(1,"警告"),
    ERROR(2,"错误");

    private int code;
    private String value;
    ExcepLevelEnum(int code,String value){
        this.code = code;
        this.value = value;

    }

    
}
