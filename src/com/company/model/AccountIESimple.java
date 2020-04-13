package com.company.model;

import java.math.BigDecimal;

public class AccountIESimple extends Account {
    public AccountIESimple(Integer id, BigDecimal sumValue, String region) {
        super(id, sumValue, region);
        if(region == "Brest" || region == "Grodno"){
            setTaxRate(3);
        } else {
            setTaxRate(5);
        }
    }
}
