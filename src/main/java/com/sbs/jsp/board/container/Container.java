package com.sbs.jsp.board.container;

import com.sbs.jsp.board.boundedContext.article.controller.ArticleController;
import com.sbs.jsp.board.boundedContext.member.controller.MemberController;

public class Container {
  public static MemberController memberController;
  public static ArticleController articleController;

  static {
    memberController = new MemberController();
    articleController = new ArticleController();
  }
}
