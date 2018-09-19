package restaurantproject;

import java.util.Scanner;

public class SwitchCase {

    static Scanner sc = new Scanner(System.in);

    public static void switchCase(int choice) {
        int i;
        String s;
        switch (choice) {
            case 1:
                EmployeeManager.addEmployee();
                break;
            case 2:
                System.out.println("Insert employeeID to fire that employee: ");
                i = readInt();
                EmployeeManager.removeEmployeeById(i);
                break;
            case 3:
                System.out.println("Insert employeeID to change that employees name: ");
                i = readInt();
                EmployeeManager.updateEmployeeNameById(i);
                break;
            case 4:
                System.out.println("Insert employeeID to update that employees salary");
                i = readInt();
                EmployeeManager.updateSalaryById(i);
                break;
            case 5:
                System.out.println("Insert employeeID to change that employees profession");
                i = readInt();
                EmployeeManager.updateEmployeeJobById(i);
                break;
            case 6:
                System.out.println("Insert employeeID to update that employees personal number");
                i = readInt();
                EmployeeManager.updateEmployeePersonalNumberById(i);
                break;
            case 7:
                EmployeeManager.updateAllAges();
                break;
            case 8:
                System.out.println("Insert employeeID to show");
                i = readInt();
                EmployeeManager.printEmployeeById(i);
                break;
            case 9:
                EmployeeManager.printAllEmployees();
                break;
            case 10:
                System.out.println("Insert profession you want to list employees of (Owner, HeadChef, Chef or Waiter): ");
                s = readText();
                EmployeeManager.printEmployeesByJob(s);
                break;
            case 11:
                EmployeeManager.printSalaryList();
                break;
            case 12:
                Transactionlist.addMonthlyIncome();
                break;
            case 13:
                Transactionlist.printIncomeList();
                break;
            case 99:
                RestaurantProject.loop = false;
                break;
            case 0:
                RestaurantProject.loop = false;
                RestaurantProject.jobLoop = false;
                break;
            default:
                System.out.println("Can't understand command.");
                break;

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
