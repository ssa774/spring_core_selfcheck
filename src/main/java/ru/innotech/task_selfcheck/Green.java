package ru.innotech.task_selfcheck;

import org.springframework.stereotype.Component;

@Component
public class Green implements Colorable {
    public static Green ownColor = new Green();


    @Override
    public Colorable getNextColor() {
        return Red.ownColor;
    }

    @Override
    public String toString() {
        return "Green";
    }
}
