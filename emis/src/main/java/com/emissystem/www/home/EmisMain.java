package com.emissystem.www.home;



import org.eclipse.jetty.util.resource.Resource;


import static spark.Spark.*;

public class EmisMain {
    public static void main(String[] args) {
        //TODO: cannot mix static files and resources from a jar with spark.
        staticFileLocation("/public");
        Resource resource = Resource.newClassPathResource("/META-INF/resources");
        get("/list", (req, res) -> resource.getListHTML("/", true));
        //get("/", (req, res) -> );
    }
}
