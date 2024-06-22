package ru.innotech.task_selfcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Red implements Colorable {
    private Colorable nextColor;

    @Autowired
    @Qualifier("yellow")
    public void setNextColor(Colorable nextColor) {
        this.nextColor = nextColor;
    }

    @Override
    public Colorable getNextColor() {
        return nextColor;
    }

    @Override
    public String toString() {
        return "Red";
    }
}
