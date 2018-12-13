package com.emissystem.www.home.util;

import lombok.*;

public class Path {

    // The @Getter methods are needed in order to access
    public static class Web {
        @Getter public static final String INDEX = "/index/";
        @Getter public static final String LOGIN = "/login/";
        @Getter public static final String LOGOUT = "/logout/";
        @Getter public static final String MAIN = "/main/";
        @Getter public static final String PATIENTLIST = "/patientList/";
        @Getter public static final String ADDPATIENT = "/patientList/add/";
        @Getter public static final String CHART = "/chart/";
        @Getter public static final String APPOINTMENT = "/appointment/";
        @Getter public static final String SCHEDULE = "/schedule/";
        @Getter public static final String PROFILE = "/profile/";
        @Getter public static final String BILLING = "/billing/";
        @Getter public static final String SIGNUP = "/signup/";
    }

    public static class Template {
        public final static String INDEX = "/freemarker/index.ftlh";
        public final static String LOGIN = "/public/login.html";
        public final static String MAIN = "/freemarker/main.ftlh";
        public static final String PATIENTLIST = "/freemarker/patientList.ftlh";
        public static final String CHART = "/freemarker/chart.ftlh";
        public static final String SCHEDULE = "/freemarker/schedule.ftlh";
        public static final String PROFILE = "/freemarker/profile.ftlh";
        public static final String BILLING = "/freemarker/billing.ftlh";
        public static final String SIGNUP = "/freemarker/signup.ftlh";
        public static final String NOT_FOUND = "/freemarker/notFound.ftlh";
    }
}
