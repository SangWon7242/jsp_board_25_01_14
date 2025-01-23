<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String pageTitle = "게시물 리스트";

request.setAttribute("pageTitle", pageTitle);
%>


<%@ include file="../../common/head.jspf" %>

<section class="article-list">
  <div class="container mx-auto flex justify-center mt-[50px]">
    <div class="max-w-[900px] w-full bg-white shadow-md rounded-lg p-8">
      <h1 class="text-2xl font-bold text-gray-800 mb-4">게시물 리스트</h1>
      <div class="overflow-x-auto">
        <table class="table">
          <colgroup>
            <col width="100px">
            <col width="500px">
            <col width="300px">
          </colgroup>

          <thead class="text-center">
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>비고</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="article" items="${articles}">
            <tr>
              <th class="text-center">${article.id}</th>
              <td class="hover:text-red-500 hover:underline">
                <a href="detail/free/${article.id}">
                  ${article.subject}
                </a>
              </td>
              <td>비고</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
      <div class="flex justify-end">
        <a href="write" class="btn btn-primary">게시물 작성</a>
      </div>
    </div>
  </div>
</section>

<%@ include file="../../common/foot.jspf" %>