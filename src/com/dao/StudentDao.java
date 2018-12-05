package com.dao;

import com.bean.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    int PAGE_SIZE=3;
    //查询所有学生
    List<Student> findAll() throws SQLException;
    void insertStudent(Student student) throws SQLException;
    void deleteStudent(int sid) throws SQLException;
    Student searchStudentById(int sid) throws SQLException;

    //更新操作
    void updateStudent(Student student)throws SQLException;
    //实现模糊查询
    List<Student> searchStudent(String sname,String gender) throws SQLException;

    //下面的方法在service实现PageBean
    //分页查询，Dao只做单一的逻辑，所以分页的内容在service内实现
    List<Student> searchStudentByPage(int currentPage) throws SQLException;
    //查询数据库的所有记录
    int totalSize()throws SQLException;
}
