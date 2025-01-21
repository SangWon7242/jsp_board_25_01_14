<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>게시물 작성</h1>

<script>
  function ArticleSave__submitForm(form) {
    form.subject.value = form.subject.value.trim();

    if(form.subject.value.length == 0) {
      alert("제목을 입력해주세요.");
      form.subject.focus();
      return;
    }

    form.content.value = form.content.value.trim();

    if(form.content.value.length == 0) {
      alert("내용을 입력해주세요.");
      form.content.focus();
      return;
    }

    form.submit();
  }

</script>

<section>
  <form method="POST" onsubmit="ArticleSave__submitForm(this); return false;">
    <div>
      <span>제목</span>
      <div>
        <input type="text" name="subject" placeholder="제목을 입력해주세요." maxlength="50">
      </div>
    </div>
    <div>
      <span>내용</span>
      <div>
        <textarea name="content" cols="30" rows="10" placeholder="내용을 입력해주세요."></textarea>
      </div>
    </div>
    <br>
    <div>
      <button type="submit">작성</button>
      <a href="list">취소</a>
    </div>
  </form>
</section>