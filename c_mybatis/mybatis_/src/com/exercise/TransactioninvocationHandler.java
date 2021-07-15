package com.exercise;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author LX
 * @Time 2021/7/15
 **/
public class TransactioninvocationHandler implements InvocationHandler {
    //创建代理类对象
    private Object object;

    public TransactioninvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession sqlSession=null;
        Object obj=null;
        try {
            //主要业务
            sqlSession = SqlSessionUtil.getSession();
            obj= method.invoke(object,args);
            sqlSession.commit();

        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            SqlSessionUtil.closeSqlssion(sqlSession);

        }
        return obj;
    }
    //获取被代理类
    public Object getproxy(){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),this);
    }
}
