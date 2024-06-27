package ru.innotech.chaneOfChecksTroughClasses;

public class Model {
    String field;

    public Model(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Model{" +
                "field='" + field + '\'' +
                '}';
    }
}
