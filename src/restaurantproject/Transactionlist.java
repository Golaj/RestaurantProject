package restaurantproject;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Transactionlist {

    static ArrayList<Income> incomeList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    private static double allBonus;
    private static int allSalary;

    public static void addMonthlyIncome() {
        boolean createIncome = true;
        System.out.println("Insert month. 1-12");
        int month = readInt();
        for (Income i : incomeList) {
            if (i.getMonth() == month) {
                System.out.println("Income already exists for that month.");
                System.out.println("Do you want to overwrite existing month? Yes/No");
                String overwrite = readText();
                if (overwrite.equalsIgnoreCase("Yes")) {
                    incomeList.remove(i);
                    break;
                } else {
                    createIncome = false;
                    break;
                }
            }
        }
        if (createIncome) {
            System.out.println("Insert restaurants income for that month");
            double income = (double)readInt();
            System.out.println("Insert tip for that month");
            double tip = (double)readInt();
            Income inc = new Income(month, income, tip);
            incomeList.add(inc);
        }
    }

    public static void setAllSalary() {
        allSalary = EmployeeManager.getAllSalary();
    }

    public static int getAllSalary() {
        return allSalary;
    }

    public static void setAllBonusByMonth(int month) {
        Income boll = null;
        for (Income income : incomeList) {
            if (month == income.getMonth()) {
                boll = income;
                break;
            }
        }
        for (Employee employee : EmployeeManager.employeeList) {
            if (employee instanceof Waiter) {
                employee.setBonus(boll.getTip());
            } else {
                employee.setBonus(boll.getIncome());
            }
        }
    }

    public static double getAllChefBonus() {
        double bonus = 0;
        for (Employee employee : EmployeeManager.employeeList) {
            if (employee instanceof Waiter) {
            } else {
                bonus += employee.getBonus();
            }
        }
        return bonus;
    }

    public static void printIncomeList() {
        incomeList.sort(Comparator.comparing(Income::getMonth));
        for (Income i : incomeList) {
            System.out.println(i);
        }
    }

    private static int readInt() {
        int a = sc.nextInt();
        sc.nextLine();
        return a;
    }

    private static String readText() {
        return sc.nextLine();
    }

}
