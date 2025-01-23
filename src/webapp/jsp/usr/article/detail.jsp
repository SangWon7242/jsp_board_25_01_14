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

<section class="article-detail">
  <div class="container mx-auto flex justify-center mt-[50px]">
    <div class="max-w-[900px] w-full bg-white shadow-md rounded-lg p-6">
      <h1 class="text-2xl font-bold text-gray-800 mb-4">게시물 상세보기</h1>
      <div class="border-b pb-4 mb-4">
        <p class="text-sm text-gray-500">
          게시물 ID : <span class="font-semibold text-gray-700">${article.id}</span>
        </p>
      </div>
      <div class="mb-4">
        <h2 class="text-xl font-semibold text-gray-800">제목</h2>
        <p class="mt-2 text-gray-700">${article.subject}</p>
      </div>
      <div>
        <h2 class="text-xl font-semibold text-gray-800">내용</h2>
        <p class="mt-2 text-gray-700 leading-relaxed">
          ${article.content}
        </p>
      </div>
      <div class="mt-6 flex">
        <div class="flex-1 flex gap-2">
          <a href="/usr/article/modify/free/${article.id}" class="btn btn-outline btn-primary">
            수정
          </a>
          <a href="/usr/article/delete/free/${article.id}" class="btn btn-outline btn-secondary">
            삭제
          </a>
        </div>
        <div class="flex-1 flex justify-end">
          <a href="/usr/article/list" class="btn btn-primary">
            리스트로 이동
          </a>
        </div>
      </div>
    </div>
  </div>
</section>

