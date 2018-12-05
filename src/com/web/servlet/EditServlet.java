package com.web.servlet;

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

@WebServlet(name = "EditServlet")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int sid=Integer.parseInt(request.getParameter("sid"));

        Student student = null;
        StudentService studentService = new StudentServiceImpl();
        try {
            student = studentService.searchStudentById(sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //存数据
        request.setAttribute("s",student);
        //跳转
        request.getRequestDispatcher("edit_student.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
