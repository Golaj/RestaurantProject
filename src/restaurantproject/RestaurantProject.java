package restaurantproject;

import java.util.Scanner;

public class RestaurantProject {

    static boolean loop = false;
    static boolean jobLoop = true;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        fakeDatabase();

//        System.out.println("We are going to create a starting squad for our restaurant, follow the instructions.");
        while (jobLoop) {
            jobCase();
            while (loop) {
                SwitchCase.switchCase(Menu.menu());
            }
        }
        
        sc.close();

    }

    private static void fakeDatabase() {
        /* Fin restaurang. 50 platser, 3 sittning/plats och dag.
        snitt 40 kunder/ sittning. 1200kr/kund och sittning:
        48 000 / sittning = 144 000 / dag.
        4 320 000 / månad. nettoAmount =  3 801 600 :- / månad.
        Profit = nettoAmount - (alla löner + Chefs bonusar + 100000 (hyra) + rörliga kostnader(nettoAmount * 0,2)).
         */
        Owner o1 = new Owner("Trump", "Murican", "195003300101");
        HeadChef h1 = new HeadChef("Joane", "Female", "199001010101");
        Chef c1 = new Chef("Jenna", "Female", "199001010101");
        Chef c2 = new Chef("James", "Male", "199001010101");
        Chef c3 = new Chef("Viktora", "Female", "199001010101");
        Chef c4 = new Chef("Harald", "Male", "199001010101");
        Waiter w1 = new Waiter("Henrik", "Male", "199001010101");
        Waiter w2 = new Waiter("Lars", "Male", "199001010101");
        Waiter w3 = new Waiter("Klara", "Female", "199001010101");
        Waiter w4 = new Waiter("Peter", "Male", "199001010101");
        Waiter w5 = new Waiter("Anna", "Female", "199001010101");
        Waiter w6 = new Waiter("Klas-Göran", "Male", "199001010101");
        Waiter w7 = new Waiter("Berith", "Female", "199001010101");

        EmployeeManager.employeeList.add(o1);
        EmployeeManager.employeeList.add(h1);
        EmployeeManager.employeeList.add(c1);
        EmployeeManager.employeeList.add(c2);
        EmployeeManager.employeeList.add(c3);
        EmployeeManager.employeeList.add(c4);
        EmployeeManager.employeeList.add(w1);
        EmployeeManager.employeeList.add(w2);
        EmployeeManager.employeeList.add(w3);
        EmployeeManager.employeeList.add(w4);
        EmployeeManager.employeeList.add(w5);
        EmployeeManager.employeeList.add(w6);
        EmployeeManager.employeeList.add(w7);

        Income jan = new Income(1, 3800000, 10000);
        Income feb = new Income(2, 3950000, 10000);
        Income mars = new Income(3, 3811098, 10000);
        Income apr = new Income(4, 4200000, 10000);
        Income maj = new Income(5, 4500000, 10000);
        Income jun = new Income(6, 3876500, 10000);
        Income jul = new Income(7, 3684627, 10000);
        Income aug = new Income(8, 3747276, 10000);
        Income sept = new Income(9, 3992652, 10000);
        Income okt = new Income(10, 4890234, 10000);
        Income nov = new Income(11, 4812644, 10000);
        Income dec = new Income(12, 3200000, 10000);

        Transactionlist.incomeList.add(jan);
        Transactionlist.incomeList.add(feb);
        Transactionlist.incomeList.add(mars);
        Transactionlist.incomeList.add(apr);
        Transactionlist.incomeList.add(maj);
        Transactionlist.incomeList.add(jun);
        Transactionlist.incomeList.add(jul);
        Transactionlist.incomeList.add(aug);
        Transactionlist.incomeList.add(sept);
        Transactionlist.incomeList.add(okt);
        Transactionlist.incomeList.add(nov);
        Transactionlist.incomeList.add(dec);
    }

    public static void jobCase() {
        loop = false;
        System.out.println("");
        System.out.println("We are going to create a new employee. Press 1 to continue with that, 2 to get to next menu or 0 to exit program.");
        int choice = readInt();
        switch (choice) {
            case 1:
                EmployeeManager.addEmployee();
                break;
            case 2:
                loop = true;
                break;
            case 0:
                jobLoop = false;
                loop = false;
                break;
        }
    }

    private static String readText() {
        return sc.nextLine();
    }

    private static int readInt() {
        int a = sc.nextInt();
        sc.nextLine();
        return a;
    }

}
