package com.web.servlet;

import com.bean.Student;
import com.dao.StudentDao;
import com.dao.com.dao.impl.StudentDaoImpl;
import com.service.StudentService;
import com.service.com.service.impl.StudentServiceImpl;
import com.util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentListServlet")
public class StudentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> list=null;
        try {
            StudentService studentService=new StudentServiceImpl();
            list = studentService.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("list",list);
        request.getRequestDispatcher("list_student.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
