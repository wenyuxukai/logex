package com.xk.logex.helper;

import com.xk.logex.config.ProcessManager;
import com.xk.logex.dao.LogMapper;
import com.xk.logex.entity.ExcepEntity;
import com.xk.logex.entity.LogEntity;
import com.xk.logex.enums.ExcepLevelEnum;
import com.xk.logex.enums.LogLevelEnum;
import com.xk.logex.process.LogDataProcess;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Data
public class LogHelper {

    @Value("${logOut}")
    private int isLogOut;
    private LogEntity logEntity;
    @Autowired
    private LogMapper logMapper;
    public LogHelper setLogEntity(LogEntity logEntity){
        this.logEntity = logEntity;
        if(logEntity.getLevel() == null){
            this.logEntity.setLevel(LogLevelEnum.OUT.getCode());
        }
        return this;
    }

    public void save(){
        if(isLogOut == 1){

            this.logEntity.setLevel(LogLevelEnum.NO_OUT.getCode());
        }else if(logEntity.getLevel() >= isLogOut){

            logEntity.getLog().info(logEntity.getMsg());
        }
        LogDataProcess logDataProcess = new LogDataProcess(this,logMapper);
        if(logEntity.isAsync()){

            ProcessManager.submit(logDataProcess);
        }else{
            logDataProcess.mark();
        }
    }

    @Override
    public String toString(){
        return "{isLogOut="+isLogOut+",logEntity="+logEntity.toString()+"}";
    }
}
