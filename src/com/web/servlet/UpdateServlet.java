package com.web.servlet;

import com.bean.Student;
import com.service.StudentService;
import com.service.com.service.impl.StudentServiceImpl;
import com.util.MyTimeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int sid= Integer.parseInt(request.getParameter("sid"));
        String sname = request.getParameter("sname");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String[] hobbys = request.getParameterValues("hobby");
        String information = request.getParameter("information");
        String hobby= Arrays.toString(hobbys);
        hobby = hobby.substring(1,hobby.length()-1);
        Student student = new Student(sid,sname,gender,phone, MyTimeUtil.dateChange(birthday),hobby,information);

        StudentService studentService = new StudentServiceImpl();
        try {
            studentService.updateStudent(student);
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
