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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
     *  用于处理学生的添加请求
     */
@WebServlet(name = "InsertStudentServlet")
public class InsertStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String sname = request.getParameter("sname");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String[] hobbys = request.getParameterValues("hobby");
        String information = request.getParameter("information");
        String hobby= Arrays.toString(hobbys);
        hobby = hobby.substring(1,hobby.length()-1);
        Student student = new Student(sname,gender,phone, MyTimeUtil.dateChange(birthday),hobby,information);

        StudentService studentService=new StudentServiceImpl();
        try {
            studentService.insertStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(student.getBirthday());
        //跳转到studentList这个Servlet，重新查询数据库
        request.getRequestDispatcher("studentList").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
