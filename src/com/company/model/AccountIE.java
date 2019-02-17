package com.company.model;

import java.math.BigDecimal;

public class AccountIE extends Account {
    @Override
    public BigDecimal getTax(int quarter, int year){
        //fixed tax
        return new BigDecimal(60);
    }
}
