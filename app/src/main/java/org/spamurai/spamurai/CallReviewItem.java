package org.spamurai.spamurai;


public class CallReviewItem {
    private String name;
    private int date;
    private int number;

    public CallReviewItem(){

    }

    public CallReviewItem(String name, int date, int number){
        this.name = name;
        this.date = date;
        this.number = number;
    }

    // NAME
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // DATE
    public String getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }

    // NUMBER
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

}
