<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>게시물 상세보기</h1>

<section class="article-detail">
  <div>
    <div>
      ID : ${article.id}
    </div>
    <div>
      SUBJECT : ${article.subject}
    </div>
    <div>
      CONTENT : ${article.content}
    </div>
  </div>
  <div>
    <a href="list">리스트로 이동</a>
  </div>
</section>