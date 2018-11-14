package com.example.appmysql.entry;

import javax.persistence.*;

@Entity
@Table
public class TitleEpisode {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String tconst;

    private String parentTconst;

    private String seasonNumber;

    private String episodeNumber;

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public String getParentTconst() {
        return parentTconst;
    }

    public void setParentTconst(String parentTconst) {
        this.parentTconst = parentTconst;
    }

    public String getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(String seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public String getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(String episodeNumber) {
        this.episodeNumber = episodeNumber;
    }
}
