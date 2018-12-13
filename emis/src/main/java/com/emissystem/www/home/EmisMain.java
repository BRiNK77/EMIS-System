package com.emissystem.www.home;

import com.emissystem.www.home.model.UserDao;
import com.emissystem.www.home.util.*;
import static spark.Spark.*;
import static spark.debug.DebugScreen.*;

public class EmisMain {

    public static UserDao userDao;

    public static void main(String[] args) {
        // SERVER CONFIGURATION
        String projectDir = System.getProperty("user.dir");
        String staticDir = "/src/main/resources/public";
        staticFiles.externalLocation(projectDir + staticDir);
        staticFiles.expireTime(600);
        enableDebugScreen();


        //staticFileLocation("/public");
        // All static files (images, html files) should be placed in "/emis/src/main/resources/public"
        // When the app/server is running, access it with "localhost:4567" in a browser
        // To display an html page you made and put in /public, access it with "localhost:4567/FileName.html"


        // ROUTING MAP
        get(Path.Web.INDEX,     IndexController.serveIndexPage);
        get(Path.Web.LOGIN,     LoginController.serveLoginPage);
        post(Path.Web.LOGIN,    LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,   LoginController.handleLogoutPost);
        get(Path.Web.MAIN,      MainController.serveMainPage);
        post(Path.Web.MAIN,     MainController.handleMainPost);
        get("*",          ViewUtil.notFound);

        // AFTER FILTERS
        after("*",        Filters.addGzipHeader);
    }
}
