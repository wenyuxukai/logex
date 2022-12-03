package com.xk.logex.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.slf4j.Logger;

import java.util.Date;
@Data
public class LogEntity {

    @TableField(exist = false)
    protected Logger log;
    @TableField(exist = false)
    protected Integer level;
    @TableField(exist = false)
    protected  String msg;
    protected boolean isAsync = false;
    public LogEntity setAsync(boolean async){
        this.isAsync = async;
        return this;
    }
    @Override
    public String toString(){
        return "需要实现此方法";
    }
}
