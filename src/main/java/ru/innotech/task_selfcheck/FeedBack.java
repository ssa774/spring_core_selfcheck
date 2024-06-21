package ru.innotech.task_selfcheck;

public class FeedBack {
    private String text;
    private int mark;


    public FeedBack(String text, int mark) {
        this.text = text;
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "text='" + text + '\'' +
                ", mark=" + mark +
                '}';
    }
}
