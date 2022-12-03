package com.xk.logex.helper;

import com.xk.logex.config.ProcessManager;
import com.xk.logex.dao.ExceptionMapper;
import com.xk.logex.entity.ExcepEntity;
import com.xk.logex.enums.ExcepLevelEnum;
import com.xk.logex.process.ExceptionDataProcess;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Data
public class ExceptionHelper {

    @Autowired
    private ExceptionMapper exceptionMapper;

    private ExcepEntity excepEntity;
    public ExceptionHelper setExcepEntity(ExcepEntity excepEntity){
        this.excepEntity = excepEntity;
        if(excepEntity.getLevel() == null){
            this.excepEntity.setLevel(ExcepLevelEnum.ERROR.getCode());
        }
        return this;
    }
    public void save(){
        ExceptionDataProcess exceptionDataProcess = new ExceptionDataProcess(this,exceptionMapper);
        if(this.excepEntity.isAsync()){

            ProcessManager.submit(exceptionDataProcess);
        }else{
            exceptionDataProcess.mark();
        }
    }

    @Override
    public String toString(){

        return "{ excepEntity="+excepEntity.toString()+"}";
    }

}
