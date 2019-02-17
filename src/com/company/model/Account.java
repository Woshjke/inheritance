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
    protected Integer taxRate;

    public Account() {
    }

    public Account(Integer id, BigDecimal sumValue) {
        this.id = id;
        this.sumValue = sumValue;
    }

    public Integer getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Integer tax) {
        this.taxRate = tax;
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


    private Date setDateBefore(int quarter, int year) {
        Calendar calendarBefore = Calendar.getInstance();
        Date dateBefore = new Date();

        switch (quarter) {
            case 1: {
                calendarBefore.set(Calendar.YEAR, year);
                calendarBefore.set(Calendar.MONTH, Calendar.APRIL);
                calendarBefore.set(Calendar.DAY_OF_MONTH, 1);
                dateBefore = calendarBefore.getTime();
                break;
            }
            case 2: {
                calendarBefore.set(Calendar.YEAR, year);
                calendarBefore.set(Calendar.MONTH, Calendar.JULY);
                calendarBefore.set(Calendar.DAY_OF_MONTH, 1);
                dateBefore = calendarBefore.getTime();
                break;
            }
            case 3: {
                calendarBefore.set(Calendar.YEAR, year);
                calendarBefore.set(Calendar.MONTH, Calendar.OCTOBER);
                calendarBefore.set(Calendar.DAY_OF_MONTH, 1);
                dateBefore = calendarBefore.getTime();
                break;
            }
            case 4: {
                calendarBefore.set(Calendar.YEAR, year + 1);
                calendarBefore.set(Calendar.MONTH, Calendar.JANUARY);
                calendarBefore.set(Calendar.DAY_OF_MONTH, 1);
                dateBefore = calendarBefore.getTime();
                break;
            }

        }
        return dateBefore;
    }

    private Date setDateAfter(int quarter, int year) {
        Calendar calendarAfter = Calendar.getInstance();
        Date dateAfter = new Date();

        switch (quarter) {
            case 1: {
                calendarAfter.set(Calendar.YEAR, year - 1);
                calendarAfter.set(Calendar.MONTH, Calendar.DECEMBER);
                calendarAfter.set(Calendar.DAY_OF_MONTH, 31);
                dateAfter = calendarAfter.getTime();
                break;
            }
            case 2: {
                calendarAfter.set(Calendar.YEAR, year);
                calendarAfter.set(Calendar.MONTH, Calendar.MARCH);
                calendarAfter.set(Calendar.DAY_OF_MONTH, 31);
                dateAfter = calendarAfter.getTime();
                break;
            }
            case 3: {
                calendarAfter.set(Calendar.YEAR, year);
                calendarAfter.set(Calendar.MONTH, Calendar.JUNE);
                calendarAfter.set(Calendar.DAY_OF_MONTH, 30);
                dateAfter = calendarAfter.getTime();
                break;
            }
            case 4: {
                calendarAfter.set(Calendar.YEAR, year);
                calendarAfter.set(Calendar.MONTH, Calendar.SEPTEMBER);
                calendarAfter.set(Calendar.DAY_OF_MONTH, 30);
                dateAfter = calendarAfter.getTime();
                break;
            }
        }
        return dateAfter;
    }

    /**
     * @param quarter - number of quarter we need
     * @param year    - year of given period
     * @return Value of tax for given quarter of current year
     */
    public BigDecimal getTax(int quarter, int year) {

        BigDecimal tax;

        Date dateBefore = setDateBefore(quarter, year);
        Date dateAfter = setDateAfter(quarter, year);

        BigDecimal income = new BigDecimal(0.00);

        for (Payment payment : payments) {
            Date paymentDate = payment.getDate();
            if (paymentDate.after(dateAfter) && paymentDate.before(dateBefore) && payment.getDestinationAccountId().equals(getId()))
                income = income.add(payment.getValue());
        }

        tax = new BigDecimal((taxRate)).multiply(income);
        return tax;
    }
}
