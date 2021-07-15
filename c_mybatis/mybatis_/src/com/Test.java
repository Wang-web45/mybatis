package com;

import com.dao.StudentDao;
import com.domian.Student;
import com.utils.ServiceFactory;
import com.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LX
 * @Time 2021/7/15
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        StudentDao studentDao= SqlSessionUtil.getSession().getMapper(StudentDao.class);
        /*Student student=studentDao.getById(1001);
        System.out.println(student);*/

        /*Student student =new Student();
        student.setName("wtt");
        student.setAge(22);
        List<Student> list=studentDao.getstudent(student);
        for (Student student1:list){
            System.out.println(student1);
        }*/
        /*String config="mybatis_config.xml";
        InputStream inputStream= Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=sqlSessionFactoryBuilder.build(inputStream);
        SqlSession session=factory.openSession();*/
       /* Student student=new Student();
        student.setId(1001013);
        student.setEmail("wtt@163.com");
        student.setName("wtt");
        student.setAge(22);
        studentDao.save(student);
        SqlSessionUtil.getSession1();*/
       /* List<Student> list=studentDao.getlike("w");
        for (Student student:list){
            System.out.println(student);
        }*/

        String str[]={"1001","1002"};
        List<Student> list= studentDao.selectfor(str);
        for (Student student:list){
            System.out.println(student);
        }

    }

}
