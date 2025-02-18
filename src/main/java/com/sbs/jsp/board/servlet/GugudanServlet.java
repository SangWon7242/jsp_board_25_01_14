package com.sbs.jsp.board.servlet;

import com.sbs.jsp.board.base.Rq;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Rq rq = new Rq(req, resp);

    int dan = rq.getIntParam("dan", 9);
    int limit = rq.getIntParam("limit", 9);

    req.setAttribute("dan", dan); // key, value
    req.setAttribute("limit", limit);

    // request에 정보를 담는다.
    // gugudan2.jsp 단에 나머지 작업을 위임
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/gugudan2.jsp");
    requestDispatcher.forward(req, resp);
  }
}
