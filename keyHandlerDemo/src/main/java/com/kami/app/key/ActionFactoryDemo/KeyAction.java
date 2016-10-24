package com.kami.app.key.ActionFactoryDemo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * make a type of action's father class
 * Created by shidian on 2016/10/24.
 */

public abstract class KeyAction implements Action{
    abstract public String execute(HttpServletRequest request, HttpServletResponse response);
}
