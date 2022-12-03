package com.xk.logex.test;

import com.baomidou.mybatisplus.annotation.TableName;
import com.xk.logex.entity.LogEntity;
import lombok.Data;
import org.slf4j.Logger;

@Data
@TableName(value = "")
public class LogObj extends LogEntity {
    private String name;

    public LogObj(Logger log,String name,String msg,Integer level) {
        this.log = log;
        this.name = name;
        this.msg = msg;
        this.level = level;
    }

    @Override
    public String toString() {
        return "{name="+name+",msg="+msg+",level="+level+",isAnsync="+isAsync+"}";
    }
}
