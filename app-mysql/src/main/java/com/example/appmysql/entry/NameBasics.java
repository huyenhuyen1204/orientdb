package com.example.appmysql.entry;


import javax.persistence.*;

@Entity
@Table(name = "name_basics")
public class NameBasics {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String tconst;

    private String primaryName;

    private double birthYear;

    private double deathYear;

    private String primaryProfession;

    private String knownForTitles;

    public String getNconts() {
        return tconst;
    }

    public void setNconts(String nconts) {
        this.tconst = nconts;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public double getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(double birthYear) {
        this.birthYear = birthYear;
    }

    public double getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(double deathYear) {
        this.deathYear = deathYear;
    }

    public String getPrimaryProfession() {
        return primaryProfession;
    }

    public void setPrimaryProfession(String primaryProfession) {
        this.primaryProfession = primaryProfession;
    }

    public String getKnownForTitles() {
        return knownForTitles;
    }

    public void setKnownForTitles(String knownForTitles) {
        this.knownForTitles = knownForTitles;
    }


}
