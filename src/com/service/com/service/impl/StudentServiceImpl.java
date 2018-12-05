package com.service.com.service.impl;

import com.bean.PageBean;
import com.bean.Student;
import com.dao.StudentDao;
import com.dao.com.dao.impl.StudentDaoImpl;
import com.service.StudentService;
import com.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;
import java.util.List;

/*
 *      这是学生的业务处理规范的实现
 *      通过StudentDao实现
 */

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findAll() throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.findAll();
    }

    @Override
    public void insertStudent(Student student) throws SQLException {

        StudentDao studentDao = new StudentDaoImpl();
        studentDao.insertStudent(student);

    }

    @Override
    public void deleteStudent(int sid) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        studentDao.deleteStudent(sid);
    }

    @Override
    public Student searchStudentById(int sid) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.searchStudentById(sid);
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        StudentDao studentDao=new StudentDaoImpl();
        studentDao.updateStudent(student);
    }

    @Override
    public List<Student> searchStudent(String sname, String gender) throws SQLException {
        StudentDao studentDao = new StudentDaoImpl();
        return studentDao.searchStudent(sname,gender);
    }

    @Override
    public PageBean findStudentByPage(int currentPage) throws SQLException {
        int pageSize = StudentDao.PAGE_SIZE;
        PageBean<Student> pageBean = new PageBean<Student>();

        pageBean.setCurrentPage(currentPage);           //设置当前页面
        pageBean.setPageSize(pageSize);                 //设置页面容量大小

        StudentDao studentDao=new StudentDaoImpl();
        int count = studentDao.totalSize();
        pageBean.setTotalSize(count);      //设置总记录数
        pageBean.setList(studentDao.searchStudentByPage(currentPage));  //获取学生列表

        int pageCount = count%pageSize==0? count/pageSize : count/pageSize+1;

        pageBean.setTotalPage(pageCount);
        return pageBean;
    }
}
