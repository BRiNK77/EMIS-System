package com.emissystem.www.home;

import com.emissystem.www.home.model.ChartDao;
import com.emissystem.www.home.model.UserDao;
import com.emissystem.www.home.util.*;
import static spark.Spark.*;

public class EmisMain {

    static UserDao userDao;
    static ChartDao chartDao;

    public static void main(String[] args) {
        // SERVER CONFIGURATION
        staticFileLocation("/public");

        // All static files (images, html files) should be placed in "/emis/src/main/resources/public"
        // When the app/server is running, access it with "localhost:4567" in a browser
        // To display an html page you made and put in /public, access it with "localhost:4567/FileName.html"


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
