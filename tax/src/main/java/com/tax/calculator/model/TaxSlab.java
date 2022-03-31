package com.tax.calculator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TaxSlab {
    private double startIncome;
    private double endIncome;
    private double taxRate;
}
