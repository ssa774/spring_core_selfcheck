package ru.innotech.chaneOfChecksTroughTunes;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@Order(1)
public class Check3 implements Checkeable {
    @Override
    public List<Model> doCheck(List<Model> modelList) {

        modelList.forEach(x->x.setField(x.getField()+"Check3"));

        return modelList;
    }
}
