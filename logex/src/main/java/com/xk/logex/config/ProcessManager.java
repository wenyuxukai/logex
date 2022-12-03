package com.xk.logex.config;

import com.xk.logex.process.BaseProcess;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class ProcessManager {
    private static CompletionService<Object> cService = null;
    static {
        int processnums = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor exec = new ThreadPoolExecutor(
                2*processnums,Integer.MAX_VALUE,60000, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(64));
        exec.allowCoreThreadTimeOut(true);
        exec.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        cService = new ExecutorCompletionService<>(exec);
    }
    public static Future<Object> submit(BaseProcess dataProcess){
        return cService.submit(dataProcess);

    }
}

