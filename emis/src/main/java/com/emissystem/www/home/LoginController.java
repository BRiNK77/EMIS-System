package com.emissystem.www.home;

import com.emissystem.www.home.util.*;
import spark.*;
import java.util.*;

import static com.emissystem.www.home.EmisMain.userDao;
import static com.emissystem.www.home.util.RequestUtil.*;

public class LoginController {

    public static Route serveLoginPage = (Request request, Response response) -> {
        response.redirect("/login.html");
        return null;
    };

    public static Route handleLoginPost = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        if (!UserController.authenticate(getQueryEmail(request), getQueryPassword(request))) {
            model.put("authenticationFailed", true);
            return ViewUtil.render(request, model, Path.Template.LOGIN);
        }
        model.put("authenticationSucceeded", true);
        request.session().attribute("currentUser", getQueryEmail(request));
        request.session().attribute("privilege", UserController.getPrivilege(getQueryEmail(request)));
        model.put("PRIVLEVEL", userDao.getUserByUsername(getQueryEmail(request)).getPRIVLEVEL() );
        model.put("UID", userDao.getUserByUsername(getQueryEmail(request)).getUID());
        model.put("NAME", getQueryEmail(request));
        return ViewUtil.render(request, model, Path.Template.MAIN);
    };

    public static Route handleLogoutPost = (Request request, Response response) -> {
        request.session().removeAttribute("currentUser");
        request.session().attribute("loggedOut", true);
        response.redirect(Path.Web.LOGIN);
        return null;
    };
}