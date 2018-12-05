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
import java.util.List;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String sname = request.getParameter("sname");
        String gender = request.getParameter("gender");
        StudentService studentDao=new StudentServiceImpl();
        List<Student> list= null;
        try {
            list = studentDao.searchStudent(sname,gender);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("list",list);
        //这里直接跳转到list界面，因为list已经存放了数据
        request.getRequestDispatcher("list_student.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
