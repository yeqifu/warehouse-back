package com.yeqifu.system.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 当实现了ApplicationContextAware之后，IOC容器初始化会回调setApplicationContext把IOC容器对象转传到里面
 * @Author: 落亦-
 * @Date: 2020/2/7 12:36
 */
@Component
public class AppUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    public static ApplicationContext getContext(){
        return context;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }
}
