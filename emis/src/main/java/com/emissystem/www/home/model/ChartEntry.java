package com.emissystem.www.home.model;

import java.sql.Date;
import java.util.Objects;

//CHART ENTRY MODEL FOR A PATIENT
public class ChartEntry {

    private final int UID;
    private final Date DATE;
    private final String DOCTORNOTE;
    private final int BP;
    private final int HEIGHT;
    private final int WEIGHT;
    // relationally a CHART ENTRY row will HAVE-A rows in a PRESCRIPTION table and a DIAGNOSIS table
    //      for if there are multiple prescriptions or multiple diagnosis made on a single date of the patient chart

    public ChartEntry(int UID, String DATE, String DOCTORNOTE, double BP, double HEIGHT, double WEIGHT) {
        this.UID = UID;
        this.DATE = Date.valueOf(DATE);
        this.DOCTORNOTE = DOCTORNOTE;
        this.BP = (int) BP;
        this.HEIGHT = (int) HEIGHT;
        this.WEIGHT = (int) WEIGHT;
    }

    public int getUID() {
        return UID;
    }

    public Date getDATE() {
        return DATE;
    }

    public String getDOCTORNOTE() {
        return DOCTORNOTE;
    }

    public int getBP() {
        return BP;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWEIGHT() {
        return WEIGHT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChartEntry that = (ChartEntry) o;
        return UID == that.UID &&
               BP == that.BP &&
               HEIGHT == that.HEIGHT &&
               WEIGHT == that.WEIGHT &&
               Objects.equals(DATE, that.DATE) &&
               Objects.equals(DOCTORNOTE, that.DOCTORNOTE);
    }

    @Override
    public int hashCode() {

        return Objects.hash(UID, DATE, DOCTORNOTE, BP, HEIGHT, WEIGHT);
    }

    @Override
    public String toString() {
        return "ChartEntry{" +
               "UID=" +
               UID +
               ", DATE=" +
               DATE +
               ", DOCTORNOTE='" +
               DOCTORNOTE +
               '\'' +
               ", BP=" +
               BP +
               ", HEIGHT=" +
               HEIGHT +
               ", WEIGHT=" +
               WEIGHT +
               '}';
    }
}
