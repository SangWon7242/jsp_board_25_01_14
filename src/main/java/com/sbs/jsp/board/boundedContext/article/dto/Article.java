package com.sbs.jsp.board.boundedContext.article.dto;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Article {
  private final long id;
  private String subject;
  private String content;
}
