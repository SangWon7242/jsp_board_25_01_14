<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>게시물 작성</h1>

<section>
  <form>
    <div>
      <span>제목</span>
      <div>
        <input type="text" name="subject" placeholder="제목을 입력해주세요." maxlength="50">
      </div>
    </div>
    <div>
      <span>내용</span>
      <div>
        <textarea name="content" rows="10" placeholder="내용을 입력해주세요."></textarea>
      </div>
    </div>
    <br>
    <div>
      <button type="submit">작성</button>
      <button>취소</button>
    </div>
  </form>
</section>