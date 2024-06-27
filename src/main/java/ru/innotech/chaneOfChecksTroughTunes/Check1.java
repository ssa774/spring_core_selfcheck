package ru.innotech.chaneOfChecksTroughTunes;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(3)
public class Check1 implements Checkeable {

    @Override
    public List<Model> doCheck(List<Model> modelList) {

        modelList.forEach(x->x.setField(x.getField()+"Check1"));

        return modelList;
    }
}
