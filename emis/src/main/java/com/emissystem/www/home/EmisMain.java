package com.emissystem.www.home;

import static spark.Spark.*;

public class EmisMain {
    public static void main(String[] args) {
        //TODO: cannot mix static files and resources from a jar with spark.
        staticFileLocation("/public");
        static int counter = 0;
        // All static files (images, html files) should be placed in "/emis/src/main/resources/public"
        // When the app/server is running, access it with "localhost:4567" in a browser
        // To display an html page you made and put in /public, access it with "localhost:4567/FileName.html"

        get("/", (request, response) -> {
            response.redirect("login.html");
            return null;
        });
        get("/main", (request, response) -> {
            if(counter == 0) {
              response.redirect("mainDoctor.html");
              counter++;
            } else if (counter == 1) {
              response.redirect("mainReceptionist.html");
              counter++
            } else {
              response.redirect("mainPatient.html");
            }
            return null;
        });
        //get("/", (req, res) -> );
    }
}
