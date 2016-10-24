package com.kami.app.key.ActionFactoryDemo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * assign the  base method to action
 * Created by shidian on 2016/10/24.
 */

public interface Action {
    /**
     * do sth and return the show pages
     * (here we can do more to adapt the variable kinds of response, such as map, stream and html pages)
     * @param request
     * @param response
     * @return
     *
     */
    public String execute(HttpServletRequest request, HttpServletResponse response);
}
