package com.kami.app.key.ActionFactoryDemo;

import com.kami.app.key.model.UserKeys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * add key into the keyLists
 * it is same to be a service(but it has a request(it wouldn't be a param in service))
 * Created by shidian on 2016/10/24.
 */

public class RemoveKeyAction extends KeyAction{

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String keyId = request.getParameter("keyId");
        HttpSession session = request.getSession();
        UserKeys keyList = (UserKeys) session.getAttribute("user");
        if (keyList == null){
            keyList = new UserKeys();
        }
        keyList.removeKey(Long.parseLong(keyId));
        session.setAttribute("user",keyList);
        //syn the data to dn
        //FileDBHelper.getInstance().putUserKey(keyList);
        return "/pages/keyIndex.jsp";//the response page
    }
}
