package com.example.appmysql.entry;

import javax.persistence.*;

@Entity
@Table(name = "title_basics")
public class TitleBasics {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String tconst;

    private String titleType;

    private String primaryTitle;

    private String originalTitle;

    private double isAdult;

    private double startYear;

    private String endYear;

    private double runtimeMinutes;

    private String genres;

    public String getTconts() {
        return tconst;
    }

    public void setTconts(String tconts) {
        this.tconst = tconts;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public double getIsAudult() {
        return isAdult;
    }

    public void setIsAudult(double isAudult) {
        this.isAdult = isAudult;
    }

    public double getStartYear() {
        return startYear;
    }

    public void setStartYear(double startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public double getRuntimeMinutes() {
        return runtimeMinutes;
    }

    public void setRuntimeMinutes(double runtimeMinutes) {
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
