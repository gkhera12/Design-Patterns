package com.eightleaves.examples.proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{
    private Object object;
    public MyInvocationHandler(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        Object result;
        try{
            if(method.getName().indexOf("get")>-1){
                System.out.println("...get Method Executing...");
            }else if(object.getClass().getName().contains(TaskImpl.class.getName())){
                System.out.println("...set Method Executing...");
            } else{
                System.out.println("Not Allowed");
            }
            result = method.invoke(object, args);
        } catch (InvocationTargetException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
}
