<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 스클립틀릿 문법 -->
<%
int dan = Integer.parseInt(request.getParameter("dan"));
int limit = Integer.parseInt(request.getParameter("limit"));

int a = 30;

// out.println(a); // response.getWriter().append(a);
%>


<h1>== <%=dan%>단 ==</h1>
<% for(int i = 1; i <= limit; i++) { %>
  <div><%=dan%> * <%=i%> = <%=dan * i%></div>
<% } %>

<!-- 방식 1 -->
<h1>
  <%
  out.println(a);
  %>
</h1>

<!-- 방식 2 -->
<h1>
  <%=a%>
</h1>

<!-- 방식 3 -->
<h1>30</h1>

<!-- 콘솔창에 30 출력 -->
<%
System.out.println(a);
%>