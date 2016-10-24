package com.kami.app.key.ActionFactoryDemo;

import com.kami.app.key.model.KeyInfo;
import com.kami.app.key.model.KeyList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * add key into the keyLists
 * Created by shidian on 2016/10/24.
 */

public class AddKeyAction extends KeyAction{

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        KeyInfo keyInfo = createByRequest(request);
        HttpSession session = request.getSession();
        KeyList keyList = (KeyList) session.getAttribute("keyLists");
        if (keyList == null){
            keyList = new KeyList();
        }
        keyList.addKey(keyInfo);
        session.setAttribute("keyLists",keyList);
        return "/addKey.jsp";//the response page
    }

    /**
     * create Keyinfo from request param (maybe from form submit)
     * @param request
     * @return
     */
    protected KeyInfo createByRequest(HttpServletRequest request){
        KeyInfo keyInfo = new KeyInfo();
        keyInfo.setKeyName(request.getParameter("NAME"));
        keyInfo.setKeyValue(request.getParameter("VALUE"));
        keyInfo.setUpdateTime(new Date());
        return  keyInfo;
    }

}
