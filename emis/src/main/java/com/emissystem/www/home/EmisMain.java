package com.emissystem.www.home;

import static spark.Spark.*;

public class EmisMain {
    public static void main(String[] args) {
        staticFileLocation("/public");
        // All static files (images, html files) should be placed in "/emis/src/main/resources/public"
        // When the app/server is running, access it with "localhost:4567" in a browser
        // To display an html page you made and put in /public, access it with "localhost:4567/FileName.html"

        //get("/", (req, res) -> );
        get("/", (request, response) -> {
            response.redirect("login.html");
            return null;
        });
        get("/main", (request, response) -> {
            return null;
        });
    }
}
