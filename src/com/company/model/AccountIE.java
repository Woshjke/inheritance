package com.company.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class AccountIE extends Account{
    AccountIE(){ super();}

    @Override
    public BigDecimal getTax(int quarter, int year){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 30);

        Date dateAfter = cal.getTime();

        Calendar ca2 = Calendar.getInstance();
        ca2.set(Calendar.YEAR, year+1);
        ca2.set(Calendar.MONTH, Calendar.JANUARY);
        ca2.set(Calendar.DAY_OF_MONTH, 1);

        Date dateBefore = ca2.getTime();

        if(quarter == 4){

            BigDecimal income = new BigDecimal(0.00);

            for(Payment payment: payments){
                Date paymentDate = payment.getDate();
                if (paymentDate.after(dateAfter) && paymentDate.before(dateBefore)){
                    if(payment.getDestinationAccountId().equals(getId())) {
                        income = income.add(payment.getValue());
                    }
                }
            }
            BigDecimal tax = income.multiply(new BigDecimal(0.05));
            return tax;
        }
        else if(quarter == 3){

        }
        else if(quarter == 2){

        }
        else if(quarter == 1){

        }
        return null;
    }
}
