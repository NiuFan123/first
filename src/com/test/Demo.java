package com.test;

import com.bean.PageBean;
import com.bean.Student;
import com.dao.StudentDao;
import com.dao.com.dao.impl.StudentDaoImpl;
import com.service.StudentService;
import com.service.com.service.impl.StudentServiceImpl;

import com.util.MyTimeUtil;
import com.util.TextUtil;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public class Demo {
    public static void main(String[] args) throws SQLException {
//        StudentDao studentDao = new StudentDaoImpl();
//        List<Student> list=studentDao.searchStudentByPage(1);
//        System.out.println(list.size());
//
//        System.out.println(studentDao.totalSize());

        StudentService studentService=new StudentServiceImpl();
        PageBean<Student> pageBean = studentService.findStudentByPage(1);
        System.out.println(pageBean.getList());
        System.out.println(pageBean.getTotalSize());
        System.out.println(pageBean.getTotalPage());
    }
}
