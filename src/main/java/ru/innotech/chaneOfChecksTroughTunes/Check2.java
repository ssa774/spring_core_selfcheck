package ru.innotech.chaneOfChecksTroughTunes;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Order(2)
public class Check2 implements Checkeable {
    @Override
    public List<Model> doCheck(List<Model> modelList) {

        modelList.forEach(x->x.setField(x.getField()+"Check2"));

        return modelList;
    }
}
