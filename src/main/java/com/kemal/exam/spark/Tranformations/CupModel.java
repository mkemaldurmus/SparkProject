package com.kemal.exam.spark.Tranformations;

import java.io.Serializable;

public class CupModel implements Serializable {
    String year;
    String hometeam;
    String first;
    String second;
    String third;
    String fourth;
    int totalGoal;
    int totalCountry;
    int totalGame;
    String totalAudience;

    public CupModel(String year, String hometeam, String first, String second, String third, String fourth, int totalGoal, int totalCountry, int totalGame, String totalAudience) {
        this.year = year;
        this.hometeam = hometeam;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.totalGoal = totalGoal;
        this.totalCountry = totalCountry;
        this.totalGame = totalGame;
        this.totalAudience = totalAudience;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getHometeam() {
        return hometeam;
    }

    public void setHometeam(String hometeam) {
        this.hometeam = hometeam;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getFourth() {
        return fourth;
    }

    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    public int getTotalGoal() {
        return totalGoal;
    }

    public void setTotalGoal(int totalGoal) {
        this.totalGoal = totalGoal;
    }

    public int getTotalCountry() {
        return totalCountry;
    }

    public void setTotalCountry(int totalCountry) {
        this.totalCountry = totalCountry;
    }

    public int getTotalGame() {
        return totalGame;
    }

    public void setTotalGame(int totalGame) {
        this.totalGame = totalGame;
    }

    public String getTotalAudience() {
        return totalAudience;
    }

    public void setTotalAudience(String totalAudience) {
        this.totalAudience = totalAudience;
    }
}
