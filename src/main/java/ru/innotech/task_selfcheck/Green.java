package ru.innotech.task_selfcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Green implements Colorable {
    private Colorable nextColor;

    @Autowired
    @Qualifier("red")
    public void setNextColor(Colorable nextColor) {
        this.nextColor = nextColor;
    }

    @Override
    public Colorable getNextColor() {
        return nextColor;
    }

    @Override
    public String toString() {
        return "Green";
    }
}
