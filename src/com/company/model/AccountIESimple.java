package com.company.model;

import java.math.BigDecimal;

public class AccountIESimple extends Account {
    public AccountIESimple(Integer id, BigDecimal sumValue) {
        super(id, sumValue);
        setTaxRate(5);
    }

    @Override
    public void setInPreferentialTaxZone(boolean isInPreferentialTaxZone){
        if(isInPreferentialTaxZone){
            setTaxRate(3);
        }
    }
}
