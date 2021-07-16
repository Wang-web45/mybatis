package com.Utils;

import java.io.ObjectStreamException;
/**
 * @author LX
 * @Time 2021/7/16
 **/
public class ServiceFactory {

    public static Object getService(Object object){
        return new InvocationHander(object).getProxy();

    }
}
