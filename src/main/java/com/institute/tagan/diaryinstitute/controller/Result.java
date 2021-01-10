package com.institute.tagan.diaryinstitute.controller;

public class Result {
    public Result() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountlab() {
        return countlab;
    }

    public void setCountlab(int countlab) {
        this.countlab = countlab;
    }

    public int getCounttest() {
        return counttest;
    }

    public void setCounttest(int counttest) {
        this.counttest = counttest;
    }

    public int getCountcoursework() {
        return countcoursework;
    }

    public void setCountcoursework(int countcoursework) {
        this.countcoursework = countcoursework;
    }

    public int[] getResult() {
        return result;
    }

    public void setResult(int[] result) {
        this.result = result;
    }

    int id;
   int countlab;
   int counttest;
   int countcoursework;
   int[] result;
}
