package com.Utils;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LX
 * @Time 2021/7/16
 **/
public class InvocationHander implements InvocationHandler {
    private Object object;

    public InvocationHander(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session=null;
        Object obj=null;
        try {
            session=SqlSessionUtils.getSession();
            method.invoke(object,args);
            session.commit();
        }catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtils.closeSqlsssion(session);
        }
        return obj;
    }
    public Object getProxy(){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),this);
    }
}
