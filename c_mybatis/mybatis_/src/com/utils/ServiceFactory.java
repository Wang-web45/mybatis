package com.utils;

import java.io.ObjectStreamException;

/**
 * @author LX
 * @Time 2021/7/15
 **/
public class ServiceFactory {
    public static Object getService(Object object) {
        return new TransactionInvocationHandler(object).getproxy();

    }
}
