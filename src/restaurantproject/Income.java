package restaurantproject;

import java.util.ArrayList;

public class Income {
    
    private double netAmount;
    private double income;
    private double profit;
    private static double tip;
    private int month;
    private static int rent = 100000;
    
    public Income(int month, double income, double tip){
        this.month = month;
        this.income = income;
        this.tip = tip;
        netAmount = income - (income*0.12);
        double newProfit = netAmount - (netAmount*0.4) - rent - Transactionlist.getAllSalary() - Transactionlist.getAllChefBonus();
        profit = newProfit;
        
//        Transactionlist.setAllSalary();
//        Transactionlist.setAllBonusByMonth(month);
//        profit = netAmount - (netAmount * 0.2) - rent - Transactionlist.getAllSalary() - Transactionlist.getAllChefBonus();
    }
    

    public int getMonth() {
        return month;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getProfit() {
        return profit;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "Month: " + month + "   Income: " + income +  "   Netamount: " + netAmount+"   Profit: " + profit;
    }
    
    

}
