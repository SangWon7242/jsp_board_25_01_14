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
    /*
    for(int i = 1; i <= 5; i++) {
      articleList.add(new Article(i, "제목 %d".formatted(i), "내용 %d".formatted(i)));
    }
    */

    // 스트림 문법
    IntStream.rangeClosed(1, 5)
        .forEach(i ->
            articleList.add(new Article(i, "제목 %d".formatted(i), "내용 %d".formatted(i)))
        );
  }

  public void showList(Rq rq) {
    List<Article> articles = articleList;

    rq.setAttr("articles", articles);

    rq.view("usr/article/list");
  }
}
