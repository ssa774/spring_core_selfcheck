package ru.innotech.task_selfcheck;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

@Configuration
public class Config {

    @Bean
    public String getStr() {
        return "Hello world";
    }

    @Bean
    @Lazy //по условию должен возвращать дату и время !первого! обращения к бину, значит создавать не сразу
    public Date getDate() {
        return new Date();
    }

    @Bean
    public Predicate<Integer> getPredicate() {
        return (x) -> (x >= 2 && x <= 5);
    }

    @Bean
    public int min() {
        return 1;
    }

    @Bean
    public int max() {
        return 10;
    }

    @Bean
    public Generatorable randomGenerator() {
        return new RandomGenerator(min(), max());
    }

    @Bean()
    @Scope("prototype")

    public int getRandom(Generatorable randomGenerator) {
        return randomGenerator.generate();
    }

    @Bean
    public FeedBack veryGood() {
        return new FeedBack("Очень хорошо", 4);
    }

    @Bean
    public FeedBack soGood() {
        return new FeedBack("Сойдет", 3);
    }

    @Bean
    @Scope("prototype")
    public FeedBack cantSay() {
        return new FeedBack("Сложно сказать", getRandom(randomGenerator())); //вот так можно вообще? два бина один над другим
    }

    @Bean
    @Scope("prototype")
    public FeedBack getTheBest(List<FeedBack> lst) { // внедряем лист бинов
        return lst.stream()
                .max(Comparator.comparing(FeedBack::getMark))
                .orElseThrow(NoSuchElementException::new);
    }


}
