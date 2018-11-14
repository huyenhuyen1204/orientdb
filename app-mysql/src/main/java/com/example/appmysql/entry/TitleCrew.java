package com.example.appmysql.entry;

import javax.persistence.*;

@Entity
@Table(name = "title_crew")
public class TitleCrew {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String tconst;

    private String directors;

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
