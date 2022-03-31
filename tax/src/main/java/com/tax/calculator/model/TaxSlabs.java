package com.tax.calculator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class TaxSlabs {
    private List<TaxSlab> taxSlabs;
}
