package com.exercise;

import com.utils.TransactionInvocationHandler;

/**
 * @author LX
 * @Time 2021/7/15
 **/
public class ServiceFactory2 {

    private static Object getService(Object object){
        return new TransactionInvocationHandler(object).getproxy();
    }
}
