package com.tax.calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaxCalculatorServiceTest {

    @Autowired
    TaxCalculatorService taxCalculatorService;

    @Test
    public void income350K() {
        double taxAmount = taxCalculatorService.calculateTax(350000.0);
        Assertions.assertEquals(0.0, taxAmount);
    }

    @Test
    public void income500K() {
        double taxAmount = taxCalculatorService.calculateTax(500000.0);
        Assertions.assertEquals(13500.0, taxAmount);
    }

    @Test
    public void income625K() {
        double taxAmount = taxCalculatorService.calculateTax(625000.0);
        Assertions.assertEquals(24750.0, taxAmount);
    }

    @Test
    public void income1M() {
        double taxAmount = taxCalculatorService.calculateTax(1000000.0);
        Assertions.assertEquals(92250.0, taxAmount);
    }

    @Test
    public void incomeMoreThan12L() {
        double taxAmount = taxCalculatorService.calculateTax(1200000.0);
        Assertions.assertEquals(128250.0, taxAmount);
    }

    @Test
    public void incomeZero() {
        double taxAmount = taxCalculatorService.calculateTax(0.0);
        Assertions.assertEquals(0.0, taxAmount);
    }

    @Test
    public void incomeMinusOne() {
        double taxAmount = taxCalculatorService.calculateTax(-1.0);
        Assertions.assertEquals(0.0, taxAmount);
    }

    @Test
    public void incomeInNegative() {
        double taxAmount = taxCalculatorService.calculateTax(-10000.0);
        Assertions.assertEquals(0.0, taxAmount);
    }

}