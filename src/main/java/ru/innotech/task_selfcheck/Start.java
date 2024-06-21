package ru.innotech.task_selfcheck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.util.*;
import java.util.function.Predicate;

public class Start {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.innotech.task_selfcheck");

        String str = ctx.getBean("getStr", String.class);
        System.out.println("str = " + str);

        Date dateBean = ctx.getBean("getDate", Date.class);
        System.out.println("dateBean = " + dateBean);

        int i = ctx.getBean("getRandom", int.class);
        System.out.println("i = " + i);
        i = ctx.getBean("getRandom", int.class);
        System.out.println("i = " + i);
        i = ctx.getBean("getRandom", int.class);
        System.out.println("i = " + i);
        i = ctx.getBean("getRandom", int.class);
        System.out.println("i = " + i);

        FeedBack best = ctx.getBean("getTheBest", FeedBack.class);
        System.out.println(best);

        System.out.println("Svetofor-test");
        TrafficLight tr = ctx.getBean(TrafficLight.class);

        System.out.println("traffic = " + tr);
        tr.next();
        tr.next();
        tr.next();
        tr.next();
        tr.next();
        tr.next();
        Yellow.setNight(true);
        tr.next();
        tr.next();
        tr.next();
        tr.next();
        Yellow.setNight(false);
        tr.next();
        tr.next();


    }
}

