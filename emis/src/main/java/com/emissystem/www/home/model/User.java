package com.emissystem.www.home.model;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Objects;

// All fields are private and final. Getters (but not setters) are generated (https://projectlombok.org/features/Value.html)
public class User {
    private final String    EMAIL;
    private final String    SALT;
    private final String    PASS;
    private final String    NAME;
    private final int       UID;
    private final String    PRIVLEVEL; //PAT REC NUR DOC ADM

    @java.beans.ConstructorProperties({"EMAIL", "SALT", "PASS", "NAME", "PRIVLEVEL"})
    public User(String EMAIL, String SALT, String PASS, int UID, String NAME, String PRIVLEVEL) {
        this.EMAIL = EMAIL;
        this.SALT = SALT;
        this.PASS = PASS;
        this.UID = UID;
        this.NAME = NAME;
        this.PRIVLEVEL = PRIVLEVEL;
    }

    //constructor for creating a new patient by Receptionist
    public User(String EMAIL, int UID, String NAME) {
        this.EMAIL = EMAIL;
        this.SALT = BCrypt.gensalt();
        this.PASS = "password";
        this.UID = UID;
        this.NAME = NAME;
        this.PRIVLEVEL = "PAT";
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

    public int    getUID() {
        return UID;
    }

    public String getNAME() {
        return NAME;
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
               UID == user.UID &&
               Objects.equals(NAME, user.NAME) &&
               Objects.equals(PRIVLEVEL, user.PRIVLEVEL);
    }

    @Override
    public int hashCode() {

        return Objects.hash(EMAIL, SALT, PASS, NAME, PRIVLEVEL);
    }

    @Override
    public String toString() {
        return "User{" +
               "EMAIL='" + EMAIL +
               "', SALT='" + SALT +
               "', PASS='" + PASS +
               "', UID='" + UID +
               "', NAME='" + NAME +
               "', PRIVLEVEL='" + PRIVLEVEL +
               "'}";
    }
}

