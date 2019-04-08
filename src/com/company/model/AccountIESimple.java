package com.company.model;

import java.math.BigDecimal;

public class AccountIESimple extends Account {
    public AccountIESimple(Integer id, BigDecimal sumValue) {
        super(id, sumValue);
        if (isInPreferentialTaxZone) {
            setTaxRate(3);
        } else {
            setTaxRate(5);
        }
    }
}
