package restaurantproject;

import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);
    public static int menu(){
        System.out.println("\nWhat do you want to do?");
        System.out.println("1. Add an employee.");
        System.out.println("2. Remove an employee.");
        System.out.println("3. Update employee name.");
        System.out.println("4. Update an employees salary.");
        System.out.println("5. Change employees profession.");
        System.out.println("6. Update employee personal number.");
        System.out.println("7. Update employees ages.");
        System.out.println("8. Show an employee.");
        System.out.println("9. Show all employees.");
        System.out.println("10. Show employees of certain profession.");
        System.out.println("11. Show a salary list.");
        System.out.println("12. Add monthly income.");
        System.out.println("13. Print restaurants incomelist.");
        System.out.println("99. Go back to previous list.");
        System.out.println("0. Exit program");
        return sc.nextInt();
    }
}
