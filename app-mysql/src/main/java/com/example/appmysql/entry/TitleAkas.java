package com.example.appmysql.entry;

import javax.persistence.*;

@Entity
@Table(name = "title_akas")
public class TitleAkas {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String titleId;

    private double ordering;

    private String title;

    private String region;

    private String language;

    private String types;

    private String attributes;

    private double isOriginalTitle;

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public double getOrdering() {
        return ordering;
    }

    public void setOrdering(double ordering) {
        this.ordering = ordering;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public double getIsOriginalTitle() {
        return isOriginalTitle;
    }

    public void setIsOriginalTitle(double isOriginalTitle) {
        this.isOriginalTitle = isOriginalTitle;
    }
}
