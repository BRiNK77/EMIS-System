package com.emissystem.www.home;



import org.eclipse.jetty.util.resource.Resource;


import static spark.Spark.*;

public class EmisMain {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //routes go here
    }
}
