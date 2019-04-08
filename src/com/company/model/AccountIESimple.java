package com.company.model;

import java.math.BigDecimal;

public class AccountIESimple extends Account {
    public AccountIESimple(Integer id, BigDecimal sumValue, String region) {
        super(id, sumValue, region);
        setTaxRate(5);
    }
}
