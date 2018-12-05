<%--
  Created by IntelliJ IDEA.
  User: 牛帆
  Date: 2018/11/21
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息</title>
    <script>
        function doDelete(sid) {
            var flag=confirm("是否删除该学生");
            if(flag==true){
                // 在当前的标签页上，打开超链接
                location.href="deleteServlet?sid="+sid;
            }
        }
    </script>
</head>
<body>
    <h3>欢迎使用学生信息管理系统</h3>
    <form action="searchServlet" method="post">
        <table border="1px solid gray">
            <tr>
                <td colspan="8">
                    按姓名查询：<input type="text" name="sname">
                    &nbsp;
                    按性别查询：<select name="gender">
                    <option value="">请选择</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
                    &nbsp;
                    <input type="submit" name="query" value="查询">
                    &nbsp;&nbsp;&nbsp;
                    <a href="insert_student.jsp">添加</a>
                </td>
            </tr>
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>性别</td>
                <td>联系方式</td>
                <td>出生日期</td>
                <td>爱好</td>
                <td>个人简介</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${pageBean.list}" var="s">
                <tr>
                    <td>${s.sid}</td>
                    <td>${s.sname}</td>
                    <td>${s.gender}</td>
                    <td>${s.phone}</td>
                    <td>${s.birthday}</td>
                    <td>${s.hobby}</td>
                    <td>${s.information}</td>
                    <td>
                        <a href="editServlet?sid=${s.sid}">修改</a>
                        <a href="#" onclick="doDelete(${s.sid})">删除</a>
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="8">
                    第 ${pageBean.currentPage }/ ${pageBean.totalPage } 页，每页显示${pageBean.pageSize }条，总记录${pageBean.totalSize }条，
                    <c:if test="${pageBean.currentPage!=1}">
                        <a href="studentPageList?currentPage=1">首页&nbsp;|&nbsp;</a>
                        <a href="studentPageList?currentPage=${pageBean.currentPage-1 }">上一页&nbsp;&nbsp;</a>
                    </c:if>

                    <c:forEach begin="1" end="${pageBean.totalPage }" var="i" step="1">
                        <c:if test="${pageBean.currentPage == i}">
                            ${i }&nbsp;&nbsp;
                        </c:if>
                        <c:if test="${pageBean.currentPage != i}">
                            <a href="studentPageList?currentPage=${i }" >${i }&nbsp;&nbsp;</a>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pageBean.currentPage!=pageBean.totalPage}">
                        <a href="studentPageList?currentPage=${pageBean.currentPage+1}" >下一页&nbsp;|&nbsp;</a>
                        <a href="studentPageList?currentPage=${pageBean.totalPage}">尾页&nbsp;&nbsp;</a>
                    </c:if>

                </td>
            </tr>
        </table>
    </form>

</body>
</html>
