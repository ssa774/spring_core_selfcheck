package ru.innotech.task_selfcheck;

import org.springframework.stereotype.Component;

@Component
public class Red implements Colorable {
    public static Red ownColor = new Red();

    @Override
    public Colorable getNextColor() {
        return Yellow.ownColor;
    }

    @Override
    public String toString() {
        return "Red";
    }
}
