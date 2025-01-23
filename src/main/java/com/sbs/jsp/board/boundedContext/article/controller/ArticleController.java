package com.sbs.jsp.board.boundedContext.article.controller;

import com.sbs.jsp.board.base.Rq;
import com.sbs.jsp.board.boundedContext.article.dto.Article;
import com.sbs.jsp.board.boundedContext.article.service.ArticleService;
import com.sbs.jsp.board.container.Container;

import java.util.Arrays;
import java.util.List;

public class ArticleController {
  private ArticleService articleService;

  public ArticleController() {
    articleService = Container.articleService;
  }

  public void showList(Rq rq) {
    List<Article> articles = articleService.getArticles();

    if(articles.isEmpty()) {
      rq.print("게시물이 존재하지 않습니다.");
      return;
    }

    rq.setAttr("articles", articles);

    rq.view("usr/article/list");
  }

  public void showWrite(Rq rq) {
    rq.view("usr/article/write");
  }

  public void doWrite(Rq rq) {
    String subject = rq.getParam("subject", "");

    if(subject.trim().isEmpty()) {
      rq.print("제목을 입력해주세요.");
      return;
    }

    String content = rq.getParam("content", "");

    if(content.trim().isEmpty()) {
      rq.print("내용을 입력해주세요.");
      return;
    }

    long id = articleService.write(subject, content);

    rq.print("<div>%d번 게시물이 생성되었습니다.</div>\n".formatted(id));
  }

  public void showDetail(Rq rq) {
    long id = rq.getLongPathValueByIndex(1, 0);

    if(id == 0) {
      rq.print("올바른 요청이 아닙니다.");
    }

    Article article = articleService.findById(id);

    if(article == null) {
      rq.print("%d번 게시물은 존재하지 않습니다.".formatted(id));
      return;
    }

    rq.setAttr("article", article);

    rq.view("usr/article/detail");
  }

  public void doDelete(Rq rq) {
    long id = rq.getLongPathValueByIndex(1, 0);

    if(id == 0) {
      rq.print("올바른 요청이 아닙니다.");
    }

    Article article = articleService.findById(id);

    if(article == null) {
      rq.print("%d번 게시물은 존재하지 않습니다.".formatted(id));
      return;
    }

    articleService.delete(article.getId());

    rq.print("<div>%d번 게시물이 삭제되었습니다.</div>\n".formatted(id));
  }
}
