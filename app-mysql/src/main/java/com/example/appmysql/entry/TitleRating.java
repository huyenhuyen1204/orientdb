package com.example.appmysql.entry;

import javax.persistence.*;

@Entity
@Table
public class TitleRating {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String tconst;

    private double averageRating;

    private double numVotes;

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public double getNumVotes() {
        return numVotes;
    }

    public void setNumVotes(double numVotes) {
        this.numVotes = numVotes;
    }
}
