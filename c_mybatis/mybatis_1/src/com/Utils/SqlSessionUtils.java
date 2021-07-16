package com.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author LX
 * @Time 2021/7/16
 **/
public class SqlSessionUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String config="mybtais_config.xml";
        InputStream inputStream=null;
        try {
            inputStream= Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();

    public static SqlSession getSession(){
        SqlSession session=threadLocal.get();
        if (session==null){
            session=sqlSessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }
    public static void closeSqlsssion(SqlSession session){
        if (session !=null){
            session.close();
            threadLocal.remove();
        }
    }
}
