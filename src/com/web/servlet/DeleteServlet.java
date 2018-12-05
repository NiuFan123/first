package com.web.servlet;

import com.service.StudentService;
import com.service.com.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int sid=Integer.parseInt(request.getParameter("sid"));
        StudentService studentService=new StudentServiceImpl();
        try {
            studentService.deleteStudent(sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //跳转到studentList这个Servlet，重新查询数据库
        request.getRequestDispatcher("studentList").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
