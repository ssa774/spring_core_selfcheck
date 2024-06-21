package ru.innotech.task_selfcheck;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class RandomGenerator implements Generatorable{
    private Set<Integer> lst = new HashSet<>();
    private int min;
    private int max;
    private Random random;

    public RandomGenerator(int min, int max) {
        //записываем значения от min, max в lst. проверка, что значения для генерации исчерпаны будут проверяться удалением значений
        for(int i=min; i<=max; i++){
            lst.add(i);
        }
        this.min = min;
        this.max = max;
        this.random = new Random(99);
    }

    @Override
    public String toString() {
        return "RandomGenerator{" +
                "lst=" + lst +
                ", min=" + min +
                ", max=" + max +
                '}';
    }

    @Override
    public int generate() {

        int randomNum;

        //уже можно повторять значения
        if (lst.size()==0)
            return random.nextInt(max - min + 1)+min;
        //возвращаем значение в границах min..max
        do {
            randomNum = random.nextInt(max - min + 1)+min;

        }while (!lst.contains(randomNum));
        //удаляем значение
        lst.remove(randomNum);

        return randomNum;
    }
}