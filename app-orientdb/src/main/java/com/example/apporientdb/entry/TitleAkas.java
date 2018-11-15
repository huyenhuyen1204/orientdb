package com.example.apporientdb.entry;

import javax.persistence.*;

@Entity
@Table(name = "title_akas")
public class TitleAkas {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "titleId")
    private String titleId;

    @Column(name = "ordering")
    private Long ordering;

    @Column(name = "title")
    private String title;

    @Column(name = "region")
    private String region;

    @Column(name = "language")
    private String language;

    @Column(name = "types")
    private String types;

    @Column(name = "attributes")
    private String attributes;

    @Column(name = "isOriginalTitle")
    private Long isOriginalTitle;

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public Long getOrdering() {
        return ordering;
    }

    public void setOrdering(Long ordering) {
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

    public Long getIsOriginalTitle() {
        return isOriginalTitle;
    }

    public void setIsOriginalTitle(Long isOriginalTitle) {
        this.isOriginalTitle = isOriginalTitle;
    }
}
