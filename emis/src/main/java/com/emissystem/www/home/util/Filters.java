package com.emissystem.www.home.util;

import spark.*;
import static com.emissystem.www.home.util.RequestUtil.*;
import static spark.Spark.halt;

public class Filters {

    // If a user manually manipulates paths and forgets to add
    // a trailing slash, redirect the user to the correct path
    public static Filter addTrailingSlashes = (Request request, Response response) -> {
        if (!request.pathInfo().endsWith("/")) {
            response.redirect(request.pathInfo() + "/");
        }
    };

    // Enable GZIP for all responses
    public static Filter addGzipHeader = (Request request, Response response) -> response.header("Content-Encoding", "gzip");

    public static Filter checkForSession = (Request request, Response response) -> {
        // if user isn't logged in, redirect to the login screen
        if ((request.session(false) == null || getSessionCurrentUser(request) == null)
            && ! request.pathInfo().equals(Path.Web.LOGIN)) {
            response.redirect(Path.Web.LOGIN);
            halt();
        }
    };
}
