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

@Configuration
class Config{

    @Bean
    public String getStr(){
        return "Hello world";
    }
    @Bean
    @Lazy //по условию должен возвращать дату и время !первого! обращения к бину, значит создавать не сразу
    public Date getDate(){
        return new Date();
    }
    @Bean
    public Predicate<Integer> getPredicate(){
        return (x)->(x>=2 && x<=5);
    }

    @Bean
    public int min(){
        return 1;
    }
    @Bean
    public int max(){
        return 10;
    }

    @Bean
    public Generatorable randomGenerator(){
        return new RandomGenerator(min(), max());
    }

    @Bean()
    @Scope("prototype")

    public int getRandom(Generatorable randomGenerator){
        return randomGenerator.generate();
    }
    @Bean
    public FeedBack veryGood(){
        return new FeedBack("Очень хорошо", 4);
    }
    @Bean
    public FeedBack soGood(){
        return new FeedBack("Сойдет", 3);
    }
    @Bean
    @Scope("prototype")
    public FeedBack cantSay(){
        return new FeedBack("Сложно сказать", getRandom(randomGenerator())); //вот так можно вообще? два бина один над другим
    }

    @Bean
    @Scope("prototype")
    public FeedBack getTheBest(List<FeedBack> lst){ // внедряем лист бинов
        return lst.stream()
                .max(Comparator.comparing(FeedBack::getMark))
                .orElseThrow(NoSuchElementException::new);
    }


}
