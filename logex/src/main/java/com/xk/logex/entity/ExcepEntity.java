package com.xk.logex.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class ExcepEntity {

    @TableField(exist = false)
    private Integer level=2;
    private boolean isAsync = false;
    public ExcepEntity setAsync(boolean async){
        this.isAsync = async;
        return this;
    }
    @Override
    public String toString(){
        return "需要实现此方法";
    }
}
