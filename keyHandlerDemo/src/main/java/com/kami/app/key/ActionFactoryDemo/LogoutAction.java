package com.kami.app.key.ActionFactoryDemo;

import com.kami.app.key.model.UserKeys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * Created by shidian on 2016/10/27.
 */

public class LogoutAction implements Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserKeys userKeys = (UserKeys) session.getAttribute("user");
        session.setAttribute("message","GoodBye, " + userKeys.getUserName());
        return "/pages/logout.jsp";
    }
}
