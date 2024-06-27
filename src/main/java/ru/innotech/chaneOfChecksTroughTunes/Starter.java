package ru.innotech.chaneOfChecksTroughTunes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.innotech.chaneOfChecksTroughTunes");

        App ap = ctx.getBean(App.class);
        ap.exec();
    }
}
@Component
class App{

    List<Checkeable> checkList;

    @Autowired
    public void setFirst(List<Checkeable> checkList) {
        this.checkList = checkList;
    }

    public void exec(){

        List<Model> modelList =
                List.of(new Model("ModelTunes1 ")
                        , new Model("ModelTunes1 ")
                        , new Model("ModelTunes1 "));

        System.out.println("Models before Checks ");
        System.out.println(modelList.toString());

        //выполнится вся цепочка проверок
        this.checkList.forEach(x->x.doCheck(modelList));

        System.out.println("Models after Checks ");
        System.out.println(modelList.toString());
    }
}
