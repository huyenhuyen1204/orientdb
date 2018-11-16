package com.example.appmysql.Utils;

public class OutputDemoJoin {
    private String tconst;
    private String primaryTitle;
    private String category;


    public OutputDemoJoin(String tconst, String primaryTitle, String category) {
        this.tconst = tconst;
        this.primaryTitle = primaryTitle;
        this.category = category;
    }

    public String getTconst() {
        return tconst;
    }

    public void setTconst(String tconst) {
        this.tconst = tconst;
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public void setPrimaryTitle(String primaryTitle) {
        this.primaryTitle = primaryTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
