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
        staticFileLocation("/public"); //routes static html file paths to the file

        // BEFORE FILTERS
        before("*",     Filters.addTrailingSlashes);
        before("*",     Filters.checkForSession);

        // ROUTING MAP
        get(Path.Web.LOGIN,         LoginController.serveLoginPage);
        post(Path.Web.LOGIN,        LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,       LoginController.handleLogoutPost);
        get(Path.Web.MAIN,          MainController.serveMainPage);
        get(Path.Web.SCHEDULE,      MainController.serveMainPage);      //currently unimplemented
        get(Path.Web.PATIENTLIST,   MainController.servePatientListPage);
        post(Path.Web.ADDPATIENT,   MainController.handleAddPatient);
        get(Path.Web.PROFILE,       (req, res) -> {res.redirect("/profile.html"); return null;});    //currently unimplemented
        get(Path.Web.BILLING,       (req, res) -> {res.redirect("/billingPage.html"); return null;}); //currently unimplemented
        get(Path.Web.CHART,         MainController.serveChartPage);
        post(Path.Template.CHART,   MainController.handleChartPage); //currently unimplemented
        get("*",              ViewUtil.notFound);

        // AFTER FILTERS
        after("*",        Filters.addGzipHeader);
    }
}
