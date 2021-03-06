package com.company.utils;

import com.company.model.Account;
import com.company.model.AccountIESimple;
import com.company.model.Payment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataProvider {

    private Account painter = new Account(1, new BigDecimal(100), "Brest");
    private Account seller = new Account(2, new BigDecimal(700), "Minsk");
    private Account client = new Account(3, new BigDecimal(600), "Grodno");
    private Account ieSimple = new AccountIESimple(4, new BigDecimal(800), "Drogichin");

    public Account getIeSimple() {
        return ieSimple;
    }

    public DataProvider() {
        generatePaymentsForAccount();
    }

    public List<Payment> generateIESimplePayments(){
        Payment buyPencilPayment = new Payment( 1L, new BigDecimal(20));
        Payment buyPaper = new Payment(2L, new BigDecimal(30));
        Payment buyPortraitOfWife = new Payment(3L, new BigDecimal(400));
        Payment buyPortraitOfDaughter = new Payment(4L, new BigDecimal(500));
        Payment buyPortraitOfSon = new Payment(5L, new BigDecimal(600));

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 22);
        Date dateRepresentation = cal.getTime();
        buyPencilPayment.setDate(dateRepresentation);

        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, Calendar.NOVEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        dateRepresentation = cal.getTime();
        buyPaper.setDate(dateRepresentation);

        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, Calendar.OCTOBER);
        cal.set(Calendar.DAY_OF_MONTH, 21);
        dateRepresentation = cal.getTime();
        buyPortraitOfWife.setDate(dateRepresentation);

        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 23);
        dateRepresentation = cal.getTime();
        buyPortraitOfDaughter.setDate(dateRepresentation);

        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DAY_OF_MONTH, 8);
        dateRepresentation = cal.getTime();
        buyPortraitOfSon.setDate(dateRepresentation);

        buyPencilPayment.setSourceAccountId(ieSimple.getId());
        buyPencilPayment.setDestinationAccountId(seller.getId());
        buyPaper.setSourceAccountId(ieSimple.getId());
        buyPaper.setDestinationAccountId(seller.getId());
        buyPortraitOfWife.setSourceAccountId(client.getId());
        buyPortraitOfWife.setDestinationAccountId(ieSimple.getId());
        buyPortraitOfDaughter.setSourceAccountId(client.getId());
        buyPortraitOfDaughter.setDestinationAccountId(ieSimple.getId());
        buyPortraitOfSon.setSourceAccountId(client.getId());
        buyPortraitOfSon.setDestinationAccountId(ieSimple.getId());

        List<Payment> paymentList = new ArrayList<>();

        paymentList.add(buyPencilPayment);
        paymentList.add(buyPaper);
        paymentList.add(buyPortraitOfWife);
        paymentList.add(buyPortraitOfDaughter);
        paymentList.add(buyPortraitOfSon);

        return paymentList;
    }

    private void generatePaymentsForAccount(){
        Payment buyPencilPayment = new Payment( 1L, new BigDecimal(20));
        Payment buyPaper = new Payment(2L, new BigDecimal(30));
        Payment buyPortraitOfWife = new Payment(3L, new BigDecimal(400));
        Payment buyPortraitOfDaughter = new Payment(4L, new BigDecimal(500));
        Payment buyPortraitOfSon = new Payment(5L, new BigDecimal(600));

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 21);
        Date dateRepresentation = cal.getTime();
        buyPencilPayment.setDate(dateRepresentation);

        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, Calendar.NOVEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 3);
        dateRepresentation = cal.getTime();
        buyPaper.setDate(dateRepresentation);

        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, Calendar.OCTOBER);
        cal.set(Calendar.DAY_OF_MONTH, 22);
        dateRepresentation = cal.getTime();
        buyPortraitOfWife.setDate(dateRepresentation);

        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 27);
        dateRepresentation = cal.getTime();
        buyPortraitOfDaughter.setDate(dateRepresentation);

        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DAY_OF_MONTH, 7);
        dateRepresentation = cal.getTime();
        buyPortraitOfSon.setDate(dateRepresentation);

        buyPencilPayment.setSourceAccountId(painter.getId());
        buyPencilPayment.setDestinationAccountId(seller.getId());
        buyPaper.setSourceAccountId(painter.getId());
        buyPaper.setDestinationAccountId(seller.getId());
        buyPortraitOfWife.setSourceAccountId(client.getId());
        buyPortraitOfWife.setDestinationAccountId(painter.getId());
        buyPortraitOfDaughter.setSourceAccountId(client.getId());
        buyPortraitOfDaughter.setDestinationAccountId(painter.getId());
        buyPortraitOfSon.setSourceAccountId(client.getId());
        buyPortraitOfSon.setDestinationAccountId(painter.getId());

        List<Payment> paymentList = new ArrayList<>();

        paymentList.add(buyPencilPayment);
        paymentList.add(buyPaper);
        paymentList.add(buyPortraitOfWife);
        paymentList.add(buyPortraitOfDaughter);
        paymentList.add(buyPortraitOfSon);

        painter.setPayments(paymentList);
    }

    public Account getPainter() {
        return painter;
    }

    public Account getSeller() {
        return seller;
    }

    public Account getClient() {
        return client;
    }
}
