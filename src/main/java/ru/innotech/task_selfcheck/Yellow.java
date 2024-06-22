package ru.innotech.task_selfcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Qualifier("first")
public class Yellow implements Colorable {
    private static boolean isNight = false;
    private Colorable nextColor;

    @Autowired
    @Qualifier("green")
    public void setNextColor(Colorable nextColor) {
        this.nextColor = nextColor;
    }

    @Override
    public Colorable getNextColor() {
        if (isNight) return this;
        return nextColor;
    }

    public static void setNight(boolean night) {
        isNight = night;
    }

    @Override
    public String toString() {
        return "Yellow";
    }
}
