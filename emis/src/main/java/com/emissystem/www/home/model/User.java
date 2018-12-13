package com.emissystem.www.home.model;

import java.util.Objects;

// All fields are private and final. Getters (but not setters) are generated (https://projectlombok.org/features/Value.html)
public class User {
    private final String    EMAIL;
    private final String    SALT;
    private final String    PASS;
    private final String    PRIVLEVEL; //PAT REC NUR DOC ADM

    @java.beans.ConstructorProperties({"EMAIL", "SALT", "PASS", "PRIVLEVEL"})
    public User(String EMAIL, String SALT, String PASS, String PRIVLEVEL) {
        this.EMAIL = EMAIL;
        this.SALT = SALT;
        this.PASS = PASS;
        this.PRIVLEVEL = PRIVLEVEL;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getSALT() {
        return SALT;
    }

    public String getPASS() {
        return PASS;
    }

    public String getPRIVLEVEL() {
        return PRIVLEVEL;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(EMAIL, user.EMAIL) &&
               Objects.equals(SALT, user.SALT) &&
               Objects.equals(PASS, user.PASS) &&
               Objects.equals(PRIVLEVEL, user.PRIVLEVEL);
    }

    @Override
    public int hashCode() {

        return Objects.hash(EMAIL, SALT, PASS, PRIVLEVEL);
    }

    @Override
    public String toString() {
        return "User{" +
               "EMAIL='" + EMAIL +
               "', SALT='" + SALT +
               "', PASS='" + PASS +
               "', PRIVLEVEL='" + PRIVLEVEL +
               "'}";
    }
}

