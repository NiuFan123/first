<%--
  Created by IntelliJ IDEA.
  User: 牛帆
  Date: 2018/11/23
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>更新学生数据</title>
</head>
<body>
<form action="updateServlet" method="post">
    <input type="hidden" name="sid" value="${s.sid}">
    <table border="1px solid gray">
        <tr>
            <td>姓名</td>
            <td>
                <input type="text" name="sname" value="${s.sname}">
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="男" <c:if test="${s.gender=='男'}">checked</c:if>>男
                <input type="radio" name="gender" value="女" <c:if test="${s.gender=='女'}">checked</c:if>>女
            </td>
        </tr>
        <tr>
            <td>联系方式</td>
            <td>
                <input type="text" name="phone" value="${s.phone}">
            </td>
        </tr>
        <tr>
            <td>出生日期</td>
            <td>
                <input type="date" name="birthday" value="${s.birthday}">
            </td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <input type="checkbox" name="hobby" value="游泳" <c:if test="${fn:contains(s.hobby,'游泳' )}">checked</c:if>>游泳
                <input type="checkbox" name="hobby" value="篮球" <c:if test="${fn:contains(s.hobby,'篮球' )}">checked</c:if>>篮球
                <input type="checkbox" name="hobby" value="运动" <c:if test="${fn:contains(s.hobby,'运动' )}">checked</c:if>>运动
                <input type="checkbox" name="hobby" value="爬山" <c:if test="${fn:contains(s.hobby,'爬山' )}">checked</c:if>>爬山
            </td>
        </tr>
        <tr>
            <td>个人简介</td>
            <td>
                <textarea name="information" id="" cols="20" rows="3"> ${s.information}</textarea>
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
