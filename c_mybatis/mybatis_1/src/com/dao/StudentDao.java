package com.dao;

import com.domian.Student;

/**
 * @author LX
 * @Time 2021/7/16
 **/
public interface StudentDao {
    Student select(Integer id);

    Student selectfor(String[] str);
}
