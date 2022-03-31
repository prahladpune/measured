package com.tax.calculator.service;

import com.tax.calculator.model.TaxSlab;
import com.tax.calculator.model.TaxSlabs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaxCalculatorService {

    private final TaxSlabs taxSlabs;
    public double calculateTax(Double income){

        Double taxableIncome = income;
        double tax = 0.0;
        while(taxableIncome>0) {
            TaxSlab slab = getSlab(taxableIncome);
            if(slab!=null) {
                tax += calculateTax(taxableIncome - slab.getStartIncome(), slab.getTaxRate());
                taxableIncome = slab.getStartIncome();
            }else{
                break;
            }
        }

        return tax;
    }

    private TaxSlab getSlab(Double income) {
        for(TaxSlab slab: taxSlabs.getTaxSlabs()){
            if(income.compareTo(slab.getStartIncome())>0 && (slab.getEndIncome()==-1.0 || income.compareTo(slab.getEndIncome())<=0)){
                return slab;
            }
        }

        return null;
    }

    private Double calculateTax(Double income, Double rate){
        return income * (rate/100);
    }
}
