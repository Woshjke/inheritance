package com.company.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * This is like bank account of physical person
 */
public class Account {
    protected Integer id;
    protected BigDecimal sumValue;
    protected List<Payment> payments;

    public Account(){}

    public Account(Integer id, BigDecimal sumValue){
        this.id = id;
        this.sumValue = sumValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSumValue() {
        return sumValue;
    }

    public void setSumValue(BigDecimal sumValue) {
        this.sumValue = sumValue;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    /**
     *
     * @param quarter
     * @param year
     * @return Value of tax for given quarter of qurrent year
     */
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
            BigDecimal tax = income.multiply(new BigDecimal(0.13));
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
