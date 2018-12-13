package com.emissystem.www.home;

import com.emissystem.www.home.model.ChartDao;
import com.emissystem.www.home.model.UserDao;
import com.emissystem.www.home.util.*;
import static spark.Spark.*;

public class EmisMain {

    static UserDao userDao = new UserDao();
    static ChartDao chartDao = new ChartDao();

    public static void main(String[] args) {
        // SERVER CONFIGURATION
        port(80);
        staticFileLocation("/public");

        // ROUTING MAP
        get("/test", (req, res) -> {res.redirect("login.html"); return null;});
        get(Path.Web.INDEX,         IndexController.serveIndexPage);
        get(Path.Web.LOGIN,         LoginController.serveLoginPage);
        post(Path.Web.LOGIN,        LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,       LoginController.handleLogoutPost);
        get(Path.Web.MAIN,          MainController.serveMainPage);
        get(Path.Web.PATIENTLIST,   MainController.servePatientListPage);
        get(Path.Web.CHART,         MainController.serveChartPage);
        post(Path.Template.CHART,   MainController.handleChartPage);
        get("*",              ViewUtil.notFound);

        // AFTER FILTERS
        after("*",        Filters.addGzipHeader);
    }
}
