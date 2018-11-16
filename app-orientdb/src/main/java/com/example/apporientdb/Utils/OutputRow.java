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
}
