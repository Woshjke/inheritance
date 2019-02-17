package com.company;

import com.company.model.Account;
import com.company.utils.DataProvider;

public class Main {

    public static void main(String[] args) {

        DataProvider dataProvider = new DataProvider();
        Account painter = dataProvider.getPainter();

        System.out.println("painter tax for 4 quarter 2018: " + painter.getTax(4, 2018));

    }
}
