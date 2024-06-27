package ru.innotech.chaneOfChecksTroughClasses;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("first")
public class Check1 extends CheckAbstract implements Checkeable {


    public Check1(@Qualifier("check2") Checkeable nextCheck) {
        super(nextCheck);
    }

    @Override
    public List<Model> doCheck(List<Model> modelList) {
        modelList.forEach(x->x.setField(x.getField()+"Check1"));
        if (this.getNextCheck()!= null)
            return this.getNextCheck().doCheck(modelList);

        return modelList;
    }
}
