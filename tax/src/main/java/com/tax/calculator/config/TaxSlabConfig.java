package com.tax.calculator.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tax.calculator.model.TaxSlabs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.io.InputStream;

@Configuration
@PropertySource(value = "classpath:taxConfig.json")
@Slf4j
public class TaxSlabConfig {
    @Bean
    TaxSlabs taxSlabs() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<TaxSlabs> typeReference = new TypeReference<>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/taxConfig.json");
        try {
            TaxSlabs taxSlabs = mapper.readValue(inputStream, typeReference);
            return taxSlabs;

        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return null;
    }
}
