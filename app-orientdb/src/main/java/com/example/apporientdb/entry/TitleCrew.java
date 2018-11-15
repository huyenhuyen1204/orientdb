package com.example.apporientdb.entry;

import javax.persistence.*;

@Entity
@Table(name = "title_crew")
public class TitleCrew {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "tconst")
    private String tconst;

    @Column(name = "directors")
    private String directors;

    @Column(name = "writers")
    private String writes;

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getWrites() {
        return writes;
    }

    public void setWrites(String writes) {
        this.writes = writes;
    }
}
