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
    protected Integer taxRate = 13;
    protected Region region;
    protected boolean isInPreferentialTaxZone;

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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public boolean isInPreferentialTaxZone() {
        return isInPreferentialTaxZone;
    }

    public void setInPreferentialTaxZone(boolean inPreferentialTaxZone) {
        isInPreferentialTaxZone = inPreferentialTaxZone;
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

    private Date generateDate(int month, int year, int dayOfMonth){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        return calendar.getTime();
    }

    private boolean isDateInQuarter(int quarter, int year, Date paymentDate) {
        Date dateAfter = null;
        Date dateBefore = null;
        switch (quarter) {
            case 1: {
                dateAfter = generateDate(Calendar.DECEMBER, year - 1, 31);
                dateBefore = generateDate(Calendar.APRIL, year, 1);
                break;
            }
            case 2: {
                dateAfter = generateDate(Calendar.MARCH, year, 31);
                dateBefore = generateDate(Calendar.JULY, year, 1);
                break;
            }
            case 3: {
                dateAfter = generateDate(Calendar.JUNE, year, 30);
                dateBefore = generateDate(Calendar.OCTOBER, year, 1);
                break;
            }
            case 4: {
                dateAfter = generateDate(Calendar.SEPTEMBER, year, 30);
                dateBefore = generateDate(Calendar.JANUARY, year + 1, 1);
                break;
            }
        }
        return paymentDate.after(dateAfter) && paymentDate.before(dateBefore);
    }

    /**
     * @param quarter - number of quarter for tax calculation
     * @param year - year of given period
     * @return Value of tax for given quarter of given year
     */
    public BigDecimal getTax(int quarter, int year) {
        BigDecimal tax;
        BigDecimal income = new BigDecimal(0.00);

        for (Payment payment : payments) {
            Date paymentDate = payment.getDate();
            if (isDateInQuarter(quarter, year, paymentDate) && payment.getDestinationAccountId().equals(getId()))
                income = income.add(payment.getValue());
        }

        tax = new BigDecimal((taxRate)).multiply(income.divide(new BigDecimal(100)));
        return tax;
    }
}
