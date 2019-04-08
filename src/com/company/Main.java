package com.company;

import com.company.model.Account;
import com.company.model.AccountIE;
import com.company.model.AccountIESimple;
import com.company.utils.DataProvider;

public class Main {

    public static void main(String[] args) {

        DataProvider dataProvider = new DataProvider();

        Account painter = dataProvider.getPainter();
        AccountIE company = new AccountIE();
        Account ieSimple = dataProvider.getIeSimple();

        ieSimple.setPayments(dataProvider.generateIESimplePayments());
        ieSimple.setRegion("Minsk");


        ieSimple.setInPreferentialTaxZone(true);
        System.out.println("painter tax for 4 quarter 2018: " + painter.getTax(4, 2018));
        System.out.println("Printing fixed tax for individual entrepreneur : " + company.getTax(1,2));
        System.out.println("Printing tax for individual entrepreneur in simple tax system  : " + ieSimple.getTax(4,2018));
        System.out.println(ieSimple.getRegion());
        System.out.println(ieSimple.isInPreferentialTaxZone());
    }
}
