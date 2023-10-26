package com.xk.logex.test;

import com.xk.logex.enums.LogLevelEnum;
import com.xk.logex.helper.LogHelper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class test {

    /**
     *  本工具基于springboot和mybatis-plus
     *  项目中需使用mybatis-plus
     *  在子类实体类中需配置日志或异常信息表名
     *  使用logHelper或exceptionHelper保存日志或异常信息
     *  使用@Autowired注解在对应的项目位置注入logHelper或exceptionHelper类对象
     *  @Autowired
     *  private LogHelper logHelper;
     *  private ExceptionHelper exceptionHelper;
     *  在配置文件中配置一级目录logOut属性1，2，3
     *     1,不输出
     *     2,输出
     *     3,重要输出
     *
     *  案例如下：
     *
     * @param args
     */
    public static void main(String[] args) {
        LogHelper logHelper = new LogHelper();
        /**
         * 异步 setAsync(true)  异常实体类继承父类ExcepEntity使用
         */
        /*logHelper.setLogEntity(new LogObj(log,"名称","信息", LogLevelEnum.OUT.getCode()).setAsync(true))
                .save();*/
        /**
         * 同步 日志实体类继承父类LogEntity使用
         */
        logHelper.setLogEntity(new LogObj(log,"名称","信息", LogLevelEnum.OUT.getCode()))
                .save();
    }
}
