package com.example.title3;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/12/9.
 */

public class Expense extends DataSupport {
    private int id;
    private String source;
    private int number;
    private String time;

    public int getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public int getNumber() {
        return number;
    }

    public String getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
