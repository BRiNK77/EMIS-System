package com.emissystem.www.home;



import org.eclipse.jetty.util.resource.Resource;


import static spark.Spark.*;

public class EmisMain {
    public static void main(String[] args) {
        //TODO: cannot mix static files and resources from a jar with spark.
        staticFileLocation("/public");
        // All static files (images, html files) should be placed in "/emis/src/main/resources/public"
        // When the app/server is running, access it with "localhost:4567" in a browser
        // To display an html page you made and put in /public, access it with "localhost:4567/FileName.html"
        Resource resource = Resource.newClassPathResource("/META-INF/resources");
        get("/list", (req, res) -> resource.getListHTML("/", true));
        //get("/", (req, res) -> );
    }
}
