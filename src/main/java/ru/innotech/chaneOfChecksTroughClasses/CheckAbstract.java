package ru.innotech.chaneOfChecksTroughClasses;

public class CheckAbstract {
    private Checkeable nextCheck;

    public CheckAbstract(Checkeable nextCheck) {
        this.nextCheck = nextCheck;
    }

    public Checkeable getNextCheck() {
        return nextCheck;
    }

}
