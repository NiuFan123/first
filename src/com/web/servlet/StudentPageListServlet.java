package com.web.servlet;

import com.bean.PageBean;
import com.bean.Student;
import com.service.StudentService;
import com.service.com.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "StudentPageListServlet")
public class StudentPageListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));

        StudentService studentService=new StudentServiceImpl();
        try {
            PageBean<Student> pageBean = studentService.findStudentByPage(currentPage);
            request.setAttribute("pageBean",pageBean);
            request.getRequestDispatcher("listpage_student.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
