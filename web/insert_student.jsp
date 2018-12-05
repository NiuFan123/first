<%--
  Created by IntelliJ IDEA.
  User: 牛帆
  Date: 2018/11/22
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>添加学生信息</h3>

    <form action="insertStudent" method="post">
        <table border="1px solid gray">
            <tr>
                <td>姓名</td>
                <td>
                    <input type="text" name="sname" >
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input type="radio" name="gender" value="男">男
                    <input type="radio" name="gender" value="女">女
                </td>
            </tr>
            <tr>
                <td>联系方式</td>
                <td>
                    <input type="text" name="phone">
                </td>
            </tr>
            <tr>
                <td>出生日期</td>
                <td>
                    <input type="date" name="birthday">
                </td>
            </tr>
            <tr>
                <td>爱好</td>
                <td>
                    <input type="checkbox" name="hobby" value="游泳">游泳
                    <input type="checkbox" name="hobby" value="篮球">篮球
                    <input type="checkbox" name="hobby" value="运动">运动
                    <input type="checkbox" name="hobby" value="爬山">爬山
                </td>
            </tr>
            <tr>
                <td>个人简介</td>
                <td>
                    <textarea name="information" id="" cols="20" rows="3"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
