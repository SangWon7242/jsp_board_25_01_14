package com.sbs.jsp.board.boundedContext.article.service;

import com.sbs.jsp.board.boundedContext.article.dto.Article;
import com.sbs.jsp.board.boundedContext.article.repository.ArticleRepository;
import com.sbs.jsp.board.container.Container;

import java.util.List;

public class ArticleService {
  private ArticleRepository articleRepository;

  public ArticleService() {
    articleRepository = Container.articleRepository;
  }

  public List<Article> getArticles() {
    return articleRepository.getArticles();
  }

  public long write(String subject, String content) {
    return articleRepository.write(subject, content);
  }

  public Article findById(int id) {
    return articleRepository.findById(id);
  }
}
