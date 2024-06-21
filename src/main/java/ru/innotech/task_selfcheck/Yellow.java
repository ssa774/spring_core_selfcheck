package ru.innotech.task_selfcheck;

import org.springframework.stereotype.Component;

@Component
public class Yellow implements Colorable {
    public static Yellow ownColor = new Yellow();


    private static boolean isNight = false;

    @Override
    public Colorable getNextColor() {
        if (isNight) return ownColor;
        return Green.ownColor;
    }

    public static void setNight(boolean night) {
        isNight = night;
    }

    @Override
    public String toString() {
        return "Yellow";
    }
}
