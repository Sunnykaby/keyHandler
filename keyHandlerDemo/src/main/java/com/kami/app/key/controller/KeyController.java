package com.kami.app.key.controller;

import com.kami.app.key.ActionFactoryDemo.Action;
import com.kami.app.key.ActionFactoryDemo.ActionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by shidian on 2016/10/24.
 */
//annotation for servlet mapping
//@WebServlet(name = "KeyControler")
public class KeyController extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestPath = request.getServletPath();
        System.out.println(requestPath);
        ActionFactory actionFactory = new ActionFactory();
        String actionName = actionFactory.getActionName(requestPath);
        Action executionA = actionFactory.createAction(actionName);

        if (executionA == null)
            getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        String forwardUrl = executionA.execute(request,response);
        if (forwardUrl != null) getServletContext().getRequestDispatcher(forwardUrl).forward(request,response);
    }
}
