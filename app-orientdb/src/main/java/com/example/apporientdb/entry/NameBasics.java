package com.example.apporientdb.entry;



import com.example.apporientdb.Utils.NameBasicsRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@Entity
//@Table(name = "NameBasics")
//@JsonIgnoreProperties(value = {"handler"})
public class NameBasics {
//    @Id
//    @Column(name = "nconst")
    private String nconst;

//    @Version
//    @JsonIgnore
//    private Long version;

//    @Column(name = "primaryName")
    private String primaryName;

//    @Column(name = "birthYear")
    private Long birthYear;

//    @Column(name = "deathYear")
    private Long deathYear;

//    @Column(name = "primaryProfession")
    private String primaryProfession;

//    @Column(name = "knownForTitles")
    private String knownForTitles;
    //TODO: note : insert 1 phần
    public NameBasics(String nconst,String primaryName, Long birthYear,
                      String primaryProfession, String knownForTitles){
        setNconts(nconst);
        setPrimaryName(primaryName);
        setBirthYear(birthYear);
        setDeathYear(null);
        setKnownForTitles(knownForTitles);
        setPrimaryProfession(primaryProfession);
    }

    public NameBasics() {
    }

    public NameBasics(String primaryName) {
        this.primaryName = primaryName;
    }


    public String getNconts() {
        return nconst;
    }

    public void setNconts(String nconts) {
        this.nconst = nconts;
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
