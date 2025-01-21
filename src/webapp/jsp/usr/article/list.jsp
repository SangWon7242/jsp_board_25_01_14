<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- daisy UI 적용 -->
<link href="https://cdn.jsdelivr.net/npm/daisyui@4.12.23/dist/full.min.css" rel="stylesheet" type="text/css" />

<!-- 테일윈드 css 적용 -->
<script src="https://cdn.tailwindcss.com"></script>

<style>
  @font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
  }

  html > body {
    font-family: 'GmarketSansMedium';
  }
</style>

<section class="article-list">
  <div class="container mx-auto">
    <h1 class="text-2xl mt-3">게시물 리스트</h1>
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
    <div>
      <a href="write" class="btn btn-primary">게시물 작성</a>
    </div>
  </div>
</section>