package com.xk.logex.process;

import com.xk.logex.dao.ExceptionMapper;
import com.xk.logex.helper.ExceptionHelper;

public class ExceptionDataProcess extends BaseProcess {
    private ExceptionHelper obj;
    private ExceptionMapper exceptionMapper;
    public ExceptionDataProcess(ExceptionHelper obj,ExceptionMapper exceptionMapper){
        this.obj = obj;
        this.exceptionMapper = exceptionMapper;
    }
    public String mark(){
        try{
            exceptionMapper.insert(obj.getExcepEntity());
            return "ok";
        }catch (Exception e){

            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public Object call() throws Exception {
        return mark();
    }
}
