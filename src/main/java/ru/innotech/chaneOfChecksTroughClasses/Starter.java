package ru.innotech.chaneOfChecksTroughClasses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.innotech.chaneOfChecksTroughClasses");

        App ap = ctx.getBean(App.class);
        ap.exec();


    }
}
@Component
class App{

    Checkeable first;

    @Autowired
    @Qualifier("first")
    public void setFirst(Checkeable first) {
        this.first = first;
    }

    public void exec(){

        List<Model> modelList =
                List.of(new Model("Model1 ")
                        , new Model("Model2 ")
                        , new Model("Model3 "));

        System.out.println("Models before Checks ");
        System.out.println(modelList.toString());

        //выполнится вся цепочка проверок
        first.doCheck(modelList);

        System.out.println("Models after Checks ");
        System.out.println(modelList.toString());
    }
}
