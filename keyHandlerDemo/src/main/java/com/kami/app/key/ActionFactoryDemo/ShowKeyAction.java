package com.kami.app.key.ActionFactoryDemo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * add key into the keyLists
 * it is same to be a service(but it has a request(it wouldn't be a param in service))
 * Created by shidian on 2016/10/24.
 */

public class ShowKeyAction extends KeyAction{

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/pages/keyIndex.jsp";//the response page
    }
}
