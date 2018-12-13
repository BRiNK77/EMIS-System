package com.emissystem.www.home.util;

import lombok.*;

public class Path {

    // The @Getter methods are needed in order to access
    public static class Web {
        @Getter public static final String INDEX = "/index/";
        @Getter public static final String LOGIN = "/login/";
        @Getter public static final String LOGOUT = "/logout/";
        @Getter public static final String MAIN = "/main/";
    }

    public static class Template {
        public final static String INDEX = "/freemarker/index/index.ftlh";
        public final static String LOGIN = "/freemarker/login/login.ftlh";
        public final static String MAIN = "/freemarker/main/main.ftlh";
        public static final String NOT_FOUND = "/freemarker/notFound.ftlh";
    }
}
