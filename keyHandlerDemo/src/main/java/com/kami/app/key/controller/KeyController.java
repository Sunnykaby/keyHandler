package com.kami.app.key.controller;

import com.kami.app.key.ActionFactoryDemo.Action;
import com.kami.app.key.ActionFactoryDemo.ActionFactory;
import com.kami.app.key.persistence.FileDBHelper;

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

    public static int ServletCount = 0;
    public static int ServiceCount = 0;

    /**
     * servlet when first loaded in memory space, we should get the data from the file
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
        ServletCount++;
        System.out.println("Init Method: ServeletCount " + ServletCount +
        ",ServiceCount " + ServiceCount + "\n");
        //get the file path
        String path = getServletContext().getRealPath("");
        System.out.println(path);
        FileDBHelper.getInstance().setDbBasePath(path);
        //init the data
        FileDBHelper.getInstance().initializeInfo();
    }

    /**
     * here it should close the file and make sure that the data in the memory must be persisted into file
     */
    @Override
    public void destroy() {
        super.destroy();
        FileDBHelper.getInstance().closeDB();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceCount++;
        System.out.println("Service Method: ServeletCount " + ServletCount +
                ",ServiceCount " + ServiceCount + "\n");
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
