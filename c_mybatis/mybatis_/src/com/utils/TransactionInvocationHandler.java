package com.utils;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LX
 * @Time 2021/7/15
 **/
public class TransactionInvocationHandler implements InvocationHandler {
    //traget:zs
    private Object object;

    public TransactionInvocationHandler(Object object) {
        this.object = object;
    }

    //代理类业务方法
    //ls的表白方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session = null;
        Object obj = null;
        try {
            session = SqlSessionUtil.getSession();
            //处理业务逻辑
            //method.invoke:zs的表白方法
            obj = method.invoke(object, args);
            //处理完业务后，提交事务
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();

        } finally {
            SqlSessionUtil.Myclose(session);
        }
        return obj;
    }

    //取得李四duixiang
    public Object getproxy() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), this);

    }
}
