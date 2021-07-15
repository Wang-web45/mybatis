package com.exercise;

import com.utils.TransactionInvocationHandler;

/**
 * @author LX
 * @Time 2021/7/15
 **/
public class ServcieFactory3 {
    private static Object getService(Object o){
        return new TransactionInvocationHandler(o).getproxy();
    }
}
