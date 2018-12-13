package com.emissystem.www.home;

import com.emissystem.www.home.util.*;
import spark.*;
import java.util.*;
import static com.emissystem.www.home.util.RequestUtil.*;

class MainController {

    public static Route serveMainPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("loggedOut", removeSessionAttrLoggedOut(request));
        model.put("loginRedirect", removeSessionAttrLoginRedirect(request));
        return ViewUtil.render(request, model, Path.Template.LOGIN);
    };

    public static Route handleMainPost = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
//        if (!UserController.authenticate(getQueryUsername(request), getQueryPassword(request))) {
//            model.put("authenticationFailed", true);
//            return ViewUtil.render(request, model, Path.Template.LOGIN);
//        }
//        model.put("authenticationSucceeded", true);
//        request.session().attribute("currentUser", getQueryUsername(request));
//        if (getQueryLoginRedirect(request) != null) {
//            response.redirect(getQueryLoginRedirect(request));
//        }
        return ViewUtil.render(request, model, Path.Template.MAIN);
    };
}
