package com.academy.atilla.dto;

import javax.persistence.*;

@Entity
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private int startingYear;
    private int endingYear;

    private int startingMonth;
    private int endingMonth;

    public WorkExperience() { };

    public WorkExperience(long id, String name, int startingYear, int endingYear, int startingMonth, int endingMonth) {
        this.id = id;
        this.name = name;
        this.startingYear = startingYear;
        this.endingYear = endingYear;
        this.startingMonth = startingMonth;
        this.endingMonth = endingMonth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getStartingYear() {
        return startingYear;
    }

    public int getEndingYear() {
        return endingYear;
    }

    public int getStartingMonth() {
        return startingMonth;
    }

    public int getEndingMonth() {
        return endingMonth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartingYear(int startingYear) {
        this.startingYear = startingYear;
    }

    public void setEndingYear(int endingYear) {
        this.endingYear = endingYear;
    }

    public void setStartingMonth(int startingMonth) {
        this.startingMonth = startingMonth;
    }

    public void setEndingMonth(int endingMonth) {
        this.endingMonth = endingMonth;
    }
}
