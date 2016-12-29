package com.gecko.web;

import com.gecko.domain.ToDoItem;
import com.gecko.repository.InMemoryRepository;
import com.gecko.repository.ToDoRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by hlieu on 12/28/16.
 */
public class ToDoServlet extends HttpServlet {
   private ToDoRepository repository = new InMemoryRepository ();

   @Override
   protected void service (HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      String servletPath = request.getServletPath();
      String view = processRequest (servletPath, request);
      RequestDispatcher dispatcher = request.getRequestDispatcher (view);
      dispatcher.forward (request, response);
   }

   private String processRequest (String servletPath, HttpServletRequest request) {
      if (servletPath.equals("/all")) {
         List<ToDoItem> items = repository.findAll();
         request.setAttribute ("todoitems", items);
         return "/jsp/todo-list.jsp";
      } else {

      }

      return "/all";
   }
}
