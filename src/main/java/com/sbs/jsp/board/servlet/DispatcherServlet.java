package com.sbs.jsp.board.servlet;

import com.sbs.jsp.board.base.Rq;
import com.sbs.jsp.board.boundedContext.article.controller.ArticleController;
import com.sbs.jsp.board.boundedContext.member.controller.MemberController;
import com.sbs.jsp.board.container.Container;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Rq rq = new Rq(req, resp);

    MemberController memberController = Container.memberController;
    ArticleController articleController = Container.articleController;

    // req.getRequestURI() 란??
    // http://localhost:8030/usr/article/list : /usr/article/list 부분을 가져옴
    String url = req.getRequestURI();


    switch (url) {
      case "/usr/article/list" -> articleController.showList(rq);
      case "/usr/member/join" -> memberController.showJoin(rq);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
