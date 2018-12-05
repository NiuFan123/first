package com.service;

import com.bean.PageBean;
import com.bean.Student;

import java.sql.SQLException;
import java.util.List;
/*
 *      这是学生的业务处理规范
 *      和StudentDao相同
 */
public interface StudentService {
    List<Student> findAll() throws SQLException;
    void insertStudent(Student student) throws SQLException;
    void deleteStudent(int sid) throws SQLException;
    Student searchStudentById(int sid) throws SQLException;
    void updateStudent(Student student)throws SQLException;
    List<Student> searchStudent(String sname,String gender) throws SQLException;

    //分页查询
    PageBean findStudentByPage(int currentPage) throws SQLException;
}
