package com.kami.app.key.ActionFactoryDemo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * assign the  base method to action
 * Created by shidian on 2016/10/24.
 */

public interface Action {
    public String execute(HttpServletRequest request, HttpServletResponse response);
}
