package com.app.server.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements Service {

    @Override
    public BigDecimal computeSquareRootOf3Highest(List<BigDecimal> a) throws Exception {
        
        //validations
        if (CollectionUtils.isEmpty(a)) {
            throw new Exception("list is empty");
        }
        else if (a.size() < 3) {
            throw new Exception("list should have at least 3 items");
        }
        
        BigDecimal ret = BigDecimal.ZERO;

        MathContext mc = new MathContext(2);
        
        double sum = a.stream().sorted(Comparator.reverseOrder())
        .collect(Collectors.toList())
        .subList(0, 3)
        .stream()
        .map(x -> x.pow(2,mc))
        .mapToDouble(x->x.doubleValue())
        .sum();

        ret = new BigDecimal(sum).sqrt(mc);
        
        return ret;
    }

}
