package com.dao.com.dao.impl;

import com.bean.Student;
import com.dao.StudentDao;
import com.util.JDBCUtil;
import com.util.TextUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from student2";
        List<Student> list = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));

        return list;
    }

    @Override
    public void insertStudent(Student student) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "INSERT INTO student2 VALUES (null,?,?,?,?,?,?)";

        queryRunner.update(sql,
                student.getSname(),student.getGender(),student.getPhone(),
                student.getBirthday(),student.getHobby(),student.getInformation());

    }

    @Override
    public void deleteStudent(int sid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "DELETE FROM student2 WHERE sid=?";

        queryRunner.update(sql,sid);
    }

    @Override
    public Student searchStudentById(int sid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from student2 WHERE sid=?";
        return queryRunner.query(sql,new BeanHandler<Student>(Student.class),sid);
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "update student2 set sname=?,gender=?,phone=?,birthday=?,hobby=?,information=? where sid=?";
        queryRunner.update(sql,student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInformation(),
                student.getSid());
    }

    @Override
    public List<Student> searchStudent(String sname, String gender) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(JDBCUtil.getDataSource());
        String sql="select * from student2 where 1=1";
        ArrayList<String> list=new ArrayList<>();
        if(TextUtil.isEmpty(sname)!=true){
            sql=sql+" and sname like ?";
            list.add("%"+sname+"%");
        }
        if(TextUtil.isEmpty(gender)!=true){
            sql=sql+" and gender like ?";
            list.add("%"+gender+"%");
        }
        System.out.println(sql);
        return queryRunner.query(sql,new BeanListHandler<Student>(Student.class),list.toArray());
    }

    @Override
    public List<Student> searchStudentByPage(int currentPage) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql="SELECT * FROM student2 limit ? offset ?";
        return queryRunner.query(sql,new BeanListHandler<Student>(Student.class),PAGE_SIZE,(currentPage-1)*PAGE_SIZE);
    }

    @Override
    public int totalSize() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select count(*) from student2";
        //用于处理平均值、个数
        Long result = (Long) queryRunner.query(sql, new ScalarHandler());

        return result.intValue();
    }
}
