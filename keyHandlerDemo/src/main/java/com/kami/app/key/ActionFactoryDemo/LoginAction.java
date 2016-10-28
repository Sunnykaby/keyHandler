package com.kami.app.key.ActionFactoryDemo;

import com.kami.app.key.model.UserKeys;
import com.kami.app.key.persistence.FileDBHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by shidian on 2016/10/27.
 */

public class LoginAction implements Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        UserKeys userKeys = FileDBHelper.getInstance().getUserKey(userName, password);
        HttpSession session = request.getSession();
        if (userKeys == null) {
            // make some message to show that username and password is not correct
            session.setAttribute("message","The Name or Password may be not correct.");
            session.setAttribute("error","1");
            return "/pages/error.jsp";
        }
        else{
            session.setAttribute("user",userKeys);
            session.setAttribute("error",0);
            return  "/pages/keyIndex.jsp";
        }
    }
}
