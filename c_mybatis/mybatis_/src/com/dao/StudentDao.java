package com.dao;

import com.domian.Student;

import java.util.List;

/**
 * @author LX
 * @Time 2021/7/14
 **/
public interface StudentDao {
    public Student getById(Integer id);
    public void save(Student student);

    List<Student> getstudent(Student student);

    List<Student> getlike(String s);

    List<Student> select();

    List<Student> selectfor(String[] str);
}
