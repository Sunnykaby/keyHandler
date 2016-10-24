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
        defaultMap.put("addKey",AddKeyAction.class);
        //
        return defaultMap;
    }

    public Action createAction(String actionName){
        if (actionName == null) return  null;
        Class actionClass = (Class) actions.get(actionName);
        if (actionClass == null) {
            System.out.println("Can not find the class for this kind of Action " + actionName);
            return null;
        }
        Action actionInstance = null;
        try {
            actionInstance = (Action) actionClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  actionInstance;
    }





}
