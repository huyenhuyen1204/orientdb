package com.example.appmysql.Utils;

import java.util.List;

public class OutputList {
    private double time;
    private int records;
    private List<? extends Object> list;

    public OutputList() {
    }

    public OutputList(Long time, int records, List<? extends Object> list) {
        this.time = time;
        this.records = records;
        this.list = list;
    }

    public double getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public List<? extends Object> getList() {
        return list;
    }

    public void setList(List<? extends Object> list) {
        this.list = list;
    }
}
