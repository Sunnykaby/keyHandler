package com.kami.app.key.ActionFactoryDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * according the url, get the action the app should  execute
 * Created by shidian on 2016/10/24.
 */

public class ActionFactory {
    protected Map actions;//its child can access

    public ActionFactory(Map actions) {
        this.actions = actions;
    }

    public ActionFactory() {
        //actions = new HashMap<String,Class>();
        actions = defaultActions();
    }

    private Map defaultActions(){
        Map defaultMap = new HashMap<String, Class>();
        //add the action

        //
        return defaultMap;
    }



}
