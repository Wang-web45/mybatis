package com.exercise;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LX
 * @Time 2021/7/15
 **/
public class TransacationinvocationHandler2 implements InvocationHandler {
    private Object object;

    public TransacationinvocationHandler2(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session=null;
        Object obj=null;
        try {
            session=SqlSessionUtil.getSession();
            obj =method.invoke(object,args);
            session.commit();

        }catch (Exception e){
            session.rollback();
            e.printStackTrace();

        }finally {
          SqlSessionUtil.closeSqlssion(session);

        }
        return obj;
    }
    public Object getproxy(){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),this);
    }
}
