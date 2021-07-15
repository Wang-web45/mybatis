package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author LX
 * @Time 2021/7/14
 **/
public class SqlSessionUtil {
    public SqlSessionUtil() {
    }

    private static SqlSessionFactory sqlSessionFactory;

    static {
        String config = "mybatis_config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    //获取sqlsession对象
    public static SqlSession getSession() {
        SqlSession session = threadLocal.get();
        if (session == null) {
            session = sqlSessionFactory.openSession();
            threadLocal.set(session);
        }
       return session;
    }
    public static void getSession1(){
        SqlSession session = threadLocal.get();
        session.commit();
    }

    //关闭session对象
    public  static void Myclose(SqlSession session){
        if (session !=null){
            session.close();
            threadLocal.remove();
        }
    }

}
