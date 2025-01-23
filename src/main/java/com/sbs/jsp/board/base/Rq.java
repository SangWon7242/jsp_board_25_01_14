package com.sbs.jsp.board.base;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Rq {
  private final HttpServletRequest req;
  private final HttpServletResponse resp;

  public Rq(HttpServletRequest req, HttpServletResponse resp) {
    this.req = req;
    this.resp = resp;

    try {
      req.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=utf-8");
  }

  public int getIntParam(String paramName, int defaultValue) {
    String value = req.getParameter(paramName);
    
    // 파리미터 값이 존재하지 않으면 defaultValue 리턴
    if(value == null) return defaultValue;

    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public String getParam(String paramName, String defaultValue) {
    String value = req.getParameter(paramName);

    if(value == null) return defaultValue;

    return value;
  }

  public void setAttr(String attrName, Object value) {
    req.setAttribute(attrName, value);
  }

  public void print(String str) {
    try {
      resp.getWriter().append(str);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void view(String path) {
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/" + path + ".jsp");

    try {
      requestDispatcher.forward(req, resp);
    } catch (ServletException | IOException e) {
      throw new RuntimeException(e);
    }
  }

  public String getUrlPath() {
    return req.getRequestURI();
  }

  public String getMethod() {
    return req.getMethod(); // GET, POST, PUT, DELETE
  }

  public String getActionPath() {
    String[] bits = req.getRequestURI().split("/");
    // System.out.println(Arrays.toString(bits));
    return "/%s/%s/%s".formatted(bits[1], bits[2], bits[3]);
  }

  public long getLongPathValueByIndex(int index, int defaultValue) {
    String value = getPathValueByIndex(index, null);

    if (value == null) return defaultValue;

    try {
      return Long.parseLong(value);
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public String getPathValueByIndex(int index, String defaultValue) {
    String[] bits = req.getRequestURI().split("/");
    System.out.println(Arrays.toString(bits));

    try {
      return bits[4 + index];
    } catch (ArrayIndexOutOfBoundsException e) {
      return defaultValue;
    }
  }
}
