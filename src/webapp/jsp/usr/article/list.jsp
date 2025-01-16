<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>게시물 리스트</h1>

<ul>
  <c:forEach var="article" items="${articles}">
    <li>
      <span>
        ${article.id} 번 :
      </span>
      &nbsp;
      <span>
        ${article.subject}
      </span>
    </li>
  </c:forEach>
</ul>
