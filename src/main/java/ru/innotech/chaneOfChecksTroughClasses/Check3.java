package ru.innotech.chaneOfChecksTroughClasses;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Check3 extends CheckAbstract implements Checkeable {

    public Check3(@Value("#{null}") Checkeable nextCheck) {
        super(nextCheck);
    }

    @Override
    public List<Model> doCheck(List<Model> modelList) {
        modelList.forEach(x->x.setField(x.getField()+"Check3"));

        if (this.getNextCheck()!= null)
            return this.getNextCheck().doCheck(modelList);

        return modelList;
    }
}
