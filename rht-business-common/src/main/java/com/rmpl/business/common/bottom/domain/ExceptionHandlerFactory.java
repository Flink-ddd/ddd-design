package com.rmpl.business.common.bottom.domain;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;

public class ExceptionHandlerFactory {
    public ExceptionHandlerFactory(){
    }

    public static ExceptionHandlerI getExceptionHandler(){
        try{
            return (ExceptionHandlerI) ApplicationContextHelper.getBean(ExceptionHandlerI.class);
        }catch(NoSuchBeanDefinitionException var1){
            return DefaultExceptionHandler.singleton;
        }
    }
}
