package ma.enset.service;

import ma.enset.aspect.Log;
import ma.enset.aspect.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements Imetier{
    @Override
    @Log
    @SecuredByAspect(roles={"USER","ADMIN"})
    public void process() {
        System.out.println("Business Process ......");
    }

    @Override
    @SecuredByAspect(roles={"ADMIN"})
    public double compute() {
        double data = 78;
        System.out.println("Business Computing and returning");
        return data;
    }
}
