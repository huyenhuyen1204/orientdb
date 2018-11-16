package com.example.apporientdb.entry;



import javax.persistence.*;

@Entity
@Table(name = "name_basics")
public class NameBasics {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "nconst")
    private String tconst;

    @Column(name = "primaryName")
    private String primaryName;

    @Column(name = "birthYear")
    private Long birthYear;

    @Column(name = "deathYear")
    private Long deathYear;

    @Column(name = "primaryProfession")
    private String primaryProfession;

    @Column(name = "knownForTitles")
    private String knownForTitles;

    public NameBasics(NameBasicsRequest nameBasicsRequest) {
        this.primaryName = nameBasicsRequest.getPrimaryName();
        this.birthYear = nameBasicsRequest.getBirthYear();
        this.deathYear = nameBasicsRequest.getDeathYear();
        this.primaryProfession = nameBasicsRequest.getPrimaryProfession();
        this.knownForTitles = nameBasicsRequest.getKnownForTitles();
    }

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

    public Long getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Long birthYear) {
        this.birthYear = birthYear;
    }

    public Long getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Long deathYear) {
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
