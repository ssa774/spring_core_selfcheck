package ru.innotech.task_selfcheck;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TrafficLight{

    private Colorable curColor;

    @Override
    public String toString() {
        return "TrafficLight{" +
                "curColor=" + curColor + ", " + curColor.hashCode() +
                '}';
    }
    @Autowired
    @Qualifier("yellow")
    public void setCurColor(Colorable curColor) {
        this.curColor = curColor;
    }

    public void next(){
        this.curColor = this.curColor.getNextColor();
        System.out.println(this);
    }
}
