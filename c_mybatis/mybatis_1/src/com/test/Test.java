package com.test;

import com.Utils.SqlSessionUtils;
import com.dao.StudentDao;
import com.domian.Student;

/**
 * @author LX
 * @Time 2021/7/16
 **/
public class Test {
    public static void main(String[] args) {
        StudentDao studentDao= SqlSessionUtils.getSession().getMapper(StudentDao.class);
       /* Student student=studentDao.select(1001);
        System.out.println(student);*/
        String str[]={"1001","1002"};
        Student student1 =studentDao.selectfor(str);

    }
}
