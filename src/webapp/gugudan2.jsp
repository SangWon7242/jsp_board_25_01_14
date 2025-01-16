<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>== ${dan}단 ==</h1>
<c:forEach var="i" begin="1" end="${limit}" step="1">
  <div>${dan} * ${i} = ${dan * i}</div>
</c:forEach>

