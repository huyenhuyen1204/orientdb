package com.example.apporientdb.entry;

import javax.persistence.*;

@Entity
@Table(name = "title_principals")
public class TitlePrincipals {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "tconst")
    private String tconst;

    @Column(name = "ordering")
    private Long ordering;

    @Column(name = "nconst")
    private String nconst;

    @Column(name = "category")
    private String category;

    @Column(name = "job")
    private String job;

    @Column(name = "characters")
    private String characters;

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public Long getOrdering() {
        return ordering;
    }

    public void setOrdering(Long ordering) {
        this.ordering = ordering;
    }

    public String getNconst() {
        return nconst;
    }

    public void setNconst(String nconst) {
        this.nconst = nconst;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }
}
