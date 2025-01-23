package com.sbs.jsp.board.boundedContext.article.repository;

import com.sbs.jsp.board.boundedContext.article.dto.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleRepository {
  private List<Article> articleList;
  private long lastId;

  public ArticleRepository() {
    articleList = new ArrayList<>();

    makeTestData();

    // 게시물의 마지막 번호
    lastId = articleList.get(articleList.size() - 1).getId();
  }

  private void makeTestData() {
    // 스트림 문법
    IntStream.rangeClosed(1, 5)
        .forEach(i ->
            articleList.add(new Article(i, "제목 %d".formatted(i), "내용 %d".formatted(i)))
        );
  }

  public List<Article> getArticles() {
    List<Article> articles = articleList.stream()
        .sorted((a1, a2) -> Long.compare(a2.getId(), a1.getId()))
        .toList();

    return articles;
  }

  public long write(String subject, String content) {
    long id = ++lastId;

    Article article = new Article(id, subject, content);

    articleList.add(article);

    return id;
  }

  public Article findById(long id) {
    return articleList.stream().filter(
            article -> article.getId() == id
        )
        .findFirst()
        .orElse(null);
  }

  public void delete(long id) {
    Article article = findById(id);

    if(article == null) return;

    articleList.remove(article);
  }

  public void modify(long id, String subject, String content) {
    Article article = findById(id);

    if(article == null) return;

    article.setSubject(subject);
    article.setContent(content);
  }
}
