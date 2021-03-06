package com.example.apporientdb.Utils;

import java.util.List;

public class OutputList extends Base {
    private double time;
    private int records;
    private List<? extends Object> list;

    public OutputList() {
    }

    public OutputList(double time, int records, List<? extends Object> list) {
        this.time = time;
        this.records = records;
        this.list = list;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
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
