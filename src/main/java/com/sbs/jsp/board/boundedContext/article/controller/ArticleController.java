package com.sbs.jsp.board.boundedContext.article.controller;

import com.sbs.jsp.board.base.Rq;
import com.sbs.jsp.board.boundedContext.article.dto.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleController {
  private List<Article> articleList;

  public ArticleController() {
    articleList = new ArrayList<>();
    makeTestData();
  }

  private void makeTestData() {
    // 스트림 문법
    IntStream.rangeClosed(1, 5)
        .forEach(i ->
            articleList.add(new Article(i, "제목 %d".formatted(i), "내용 %d".formatted(i)))
        );
  }

  public void showList(Rq rq) {
    // articleList : 정렬되지 않은 1 ~ 5까지의 게시물 리스트

    // a1, a2 : article 객체
    // Integer.compare : 두 정수를 비교하는 메서드
    // - a < b : 음수 반환
    // - a == b : 0을 반환
    // - a > b : 양수 반환
    // Long.compare(a2.getId(), a1.getId()) : 둘을 비교해서 내림차순 정렬
    List<Article> articles = articleList.stream()
        .sorted((a1, a2) -> Long.compare(a2.getId(), a1.getId()))
        .toList(); // stream의 결과를 list로 변환

    rq.setAttr("articles", articles);

    rq.view("usr/article/list");
  }

  public void showWrite(Rq rq) {
    rq.view("usr/article/write");
  }
}
