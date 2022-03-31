package com.tax.calculator.controller;

import com.tax.calculator.service.TaxCalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TaxCalculatorController {
    private final TaxCalculatorService taxCalculatorService;

    @GetMapping("/calculate-tax")
    public ResponseEntity<Double> calculateTax(@RequestParam double income) {
        Double tax = taxCalculatorService.calculateTax(income);
        return ResponseEntity.ok(tax);
    }
}
