package com.kami.app.key.ActionFactoryDemo;

import com.kami.app.key.model.UserKeys;
import com.kami.app.key.persistence.FileDBHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * Created by shidian on 2016/10/27.
 */

public class LogoutAction implements Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //persist the data
        //here we can get the sesson data and syn the userKeys
        //
        FileDBHelper.getInstance().closeDB();
        HttpSession session = request.getSession();
        UserKeys userKeys = (UserKeys) session.getAttribute("user");
        session.setAttribute("message","GoodBye, " + userKeys.getUserName());
        return "/pages/logout.jsp";
    }
}
