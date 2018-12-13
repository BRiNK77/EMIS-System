package com.emissystem.www.home;

import com.emissystem.www.home.util.*;
import spark.*;
import java.util.*;

import static com.emissystem.www.home.EmisMain.userDao;
import static com.emissystem.www.home.util.RequestUtil.*;

public class LoginController {

    static Route serveLoginPage = (Request request, Response response) -> {
        //invalidate the current session if login is shown
        request.session().invalidate();
        return ViewUtil.render(request, new HashMap<>(), Path.Template.LOGIN);
    };

    static Route handleLoginPost = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        // authenticate the user
        if (!UserController.authenticate(getQueryEmail(request), getQueryPassword(request))) {
            //if failed, then return user to the login page to try again
            model.put("authenticationFailed", true);
            return ViewUtil.render(request, model, Path.Template.LOGIN);
        }
        // success, so set the session's attribute to the current user's credential and route to main page
        request.session(true);
        request.session().attribute("currentUser", userDao.getUserByUsername(getQueryEmail(request)));
        return MainController.serveMainPage.handle(request, response);
    };

    static Route handleLogoutPost = (Request request, Response response) -> {
        request.session().removeAttribute("currentUser");
        request.session().attribute("loggedOut", true);
        response.redirect(Path.Web.LOGIN);
        return null;
    };
}