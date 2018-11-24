package com.example.apporientdb.Utils;

public class OutputRow<T extends Object> {
    private double time;
    private int records;
    private T row;

    public OutputRow(double time, int records, T row) {
        this.time = time;
        this.records = records;
        this.row = row;
    }

    public OutputRow() {
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

    public T getRow() {
        return row;
    }

    public void setRow(T row) {
        this.row = row;
    }
}
