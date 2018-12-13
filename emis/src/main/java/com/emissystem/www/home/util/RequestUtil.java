package com.emissystem.www.home.util;

import com.emissystem.www.home.model.User;
import spark.*;

public class RequestUtil {
    public static String getQueryEmail(Request request) {
        return request.queryParams("email");
    }

    public static String getQueryPassword(Request request) {
        return request.queryParams("password");
    }

    public static User getSessionCurrentUser(Request request) {
        return request.session().attribute("currentUser");
    }

}