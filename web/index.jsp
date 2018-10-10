<%@ page import="com.ixanq.servlet3.hw1.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/28
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    我是JSP
    <%! int num1=10;%> //JSP声明
    <%! String str="我在学JSP";%> //JSP声明
    <%
        out.print(num1);
        out.print(str);
    %>
    <%String name="ixanq"; System.out.println("aaa"); out.print("1111"); %> /JSP小脚本

    <%= 1+1 %>//JSP表达式
    <%="abc" %>
    <span style="color: red">
  <%=name %>
   <%
   List list=new ArrayList();
        Student student= (Student) request.getAttribute("student");
        out.print(student);
          %>

  </body>
</html>
