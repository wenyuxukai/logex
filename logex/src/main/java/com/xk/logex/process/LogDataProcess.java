package com.xk.logex.process;

import com.xk.logex.dao.LogMapper;
import com.xk.logex.helper.LogHelper;

public class LogDataProcess extends BaseProcess{
    private LogHelper logHelper;
    private LogMapper logMapper;

    public LogDataProcess(LogHelper logHelper, LogMapper logMapper) {
        this.logHelper = logHelper;
        this.logMapper = logMapper;
    }

    public String mark(){
        try{
            logMapper.insert(logHelper.getLogEntity());
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
