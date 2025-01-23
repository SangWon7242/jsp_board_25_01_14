<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String pageTitle = "게시물 작성";

request.setAttribute("pageTitle", pageTitle);
%>

<%@ include file="../../common/head.jspf" %>

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

<section class="article-write">
  <div class="container mx-auto flex justify-center mt-[50px]">
    <div class="max-w-[900px] w-full bg-white shadow-md rounded-lg p-8">
      <h1 class="text-2xl font-bold text-gray-800 mb-6">게시물 작성</h1>
      <form method="POST" onsubmit="ArticleSave__submitForm(this); return false;" class="space-y-6">
        <!-- 제목 입력 -->
        <div>
          <label for="subject" class="block text-sm font-medium text-gray-700 mb-1">제목</label>
          <input
              type="text"
              id="subject"
              name="subject"
              class="input input-bordered w-full"
              placeholder="제목을 입력하세요"
              required>
        </div>

        <!-- 내용 입력 -->
        <div>
          <label for="content" class="block text-sm font-medium text-gray-700 mb-1">내용</label>
          <textarea
              id="content"
              name="content"
              rows="6"
              class="textarea textarea-bordered w-full"
              placeholder="내용을 입력하세요"
              required></textarea>
        </div>

        <!-- 제출 버튼 -->
        <div class="flex justify-end gap-3">
          <button type="submit" class="btn btn-primary">
            작성 완료
          </button>
          <a href="/usr/article/list" class="btn btn-secondary">취소</a>
        </div>
      </form>
    </div>
  </div>
</section>


<%@ include file="../../common/foot.jspf" %>