<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sbs.jsp.board.base.Rq"%>

<!-- 스클립틀릿 문법 -->
<%
Rq rq = new Rq(request, response);

int dan = rq.getIntParam("dan", 9);
int limit = rq.getIntParam("limit", 9);
%>


<h1>== <%=dan%>단 ==</h1>
<% for(int i = 1; i <= limit; i++) { %>
  <div><%=dan%> * <%=i%> = <%=dan * i%></div>
<% } %>
