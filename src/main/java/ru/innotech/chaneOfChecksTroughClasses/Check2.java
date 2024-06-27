package ru.innotech.chaneOfChecksTroughClasses;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Check2 extends CheckAbstract implements Checkeable {

        public Check2(@Qualifier("check3")  Checkeable nextCheck) {
            super(nextCheck);
        }


    @Override
    public List<Model> doCheck(List<Model> modelList) {
        modelList.forEach(x->x.setField(x.getField()+"Check2"));
        if (this.getNextCheck()!= null)
            return this.getNextCheck().doCheck(modelList);
        return modelList;
    }
}
