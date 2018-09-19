package restaurantproject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class EmployeeManager {
    
    static DecimalFormat df = new DecimalFormat("#.##");
    static ArrayList<Employee> employeeList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addEmployee() {
        System.out.println("Input the name of the Employee: ");
        String name = readText();
        System.out.println("Input the employees gender: (male/female/unknown)");
        String gender = readText();
        while (!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("Unknown"))){
                    System.out.println("Please input Male, Female or Unknown.");
                    gender = readText();
                }
        System.out.println("Input employees personal number with 12 digits. yyyyMMddxxxx");
        String pnum = readText();
        while(!(pnum.length() == 12)){
                    System.out.println("Please insert a personal number using 12 digits in the format; yyyyMMddxxxx");
                    pnum = readText();
                }
        System.out.println("What profession does the Employee have?\n1. Owner \n2. Headchef \n3. Chef \n4. Waiter ");
        String job = readText();
        job = job.toUpperCase();
        switch (job) {
            case "1":
                Owner owner = new Owner(name, gender, pnum);
                employeeList.add(owner);
                System.out.println("Employee added!");
                break;
            case "OWNER":
                Owner owner1 = new Owner(name, gender, pnum);
                employeeList.add(owner1);
                System.out.println("Employee added!");
                break;
            case "2":
                HeadChef headchef = new HeadChef(name, gender, pnum);
                employeeList.add(headchef);
                System.out.println("Employee added!");
                break;
            case "HEADCHEF":
                HeadChef headchef1 = new HeadChef(name, gender, pnum);
                employeeList.add(headchef1);
                System.out.println("Employee added!");
                break;
            case "3":
                Chef chef = new Chef(name, gender, pnum);
                employeeList.add(chef);
                System.out.println("Employee added!");
                break;
            case "CHEF":
                Chef chef1 = new Chef(name, gender, pnum);
                employeeList.add(chef1);
                System.out.println("Employee added!");
                break;
            case "4":
                Waiter waiter = new Waiter(name, gender, pnum);
                employeeList.add(waiter);
                System.out.println("Employee added!");
                break;
            case "WAITER":
                Waiter waiter1 = new Waiter(name, gender, pnum);
                employeeList.add(waiter1);
                System.out.println("Employee added!");
                break;
            default:
                System.out.println("Can't understand command.");
                break;
        }
    }

    public static void removeEmployeeById(int id) {
        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                System.out.println(employeeList.get(i) + " is now fired.");
                employeeList.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No person with that employeeID found.");
        }
    }

    public static void updateEmployeeNameById(int id) {
        boolean found = false;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                System.out.println("Employee found. Insert new name: ");
                String name = readText();
                employee.setName(name);
                System.out.println("Name changed!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Can't find an employee with that EmployeeID.");
        }
    }

    public static void updateSalaryById(int id) {
        boolean found = false;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                System.out.println("Employee found. Insert new Salary: ");
                int salary = readInt();
                employee.setSalary(salary);
                System.out.println("Salary changed!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Can't find an employee with that EmployeeID.");
        }
    }

    public static void updateEmployeeJobById(int id) {
        boolean found = false;
        Employee temp = null;
        String newJob = "";
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                System.out.println("Employee found. Insert new job (\n1. Owner \n2. Headchef \n3. Chef \n4. Waiter \n0. Exit ");
                newJob = readText();
                if (newJob.equals("0") || newJob.equalsIgnoreCase("Exit")) {
                    break;
                }
                temp = employee;
                employeeList.remove(employee);
                found = true;
                break;
            }
        }
        if (found) {
            if (newJob.equals("1") || newJob.equalsIgnoreCase("Owner")) {
                Owner owner = new Owner(temp.getName(), temp.getGender(), temp.getPersonalNumber());
                owner.setId(id);
                employeeList.add(owner);
                System.out.println("Profession is changed!");
            } else if (newJob.equals("2") || newJob.equalsIgnoreCase("HeadChef")) {
                HeadChef headchef = new HeadChef(temp.getName(), temp.getGender(), temp.getPersonalNumber());
                headchef.setId(id);
                employeeList.add(headchef);
                System.out.println("Profession is changed!");
            } else if (newJob.equals("3") || newJob.equalsIgnoreCase("Chef")) {
                Chef chef = new Chef(temp.getName(), temp.getGender(), temp.getPersonalNumber());
                chef.setId(id);
                employeeList.add(chef);
                System.out.println("Profession is changed!");
            } else if (newJob.equals("4") || newJob.equalsIgnoreCase("Waiter")) {
                Waiter waiter = new Waiter(temp.getName(), temp.getGender(), temp.getPersonalNumber());
                waiter.setId(id);
                employeeList.add(waiter);
                System.out.println("Profession is changed!");
            } else {
                System.out.println("Can't understand command.");
            }
        } else {
            System.out.println("Can't find an Employee with that EmlpoyeeID");
        }
    }

    public static void updateEmployeePersonalNumberById(int id) {
        boolean found = false;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                System.out.println("Employee found, insert new personal number: ");
                String pnum = readText();
                while(!(pnum.length() == 12)){
                    System.out.println("Please insert a personal number using 12 digits in the format; yyyyMMddxxxx");
                    pnum = readText();
                }
                employee.setPersonalNumber(pnum);
                System.out.println("Personal number is changed!");
                employee.setAge();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Can't find an Employee with that EmployeeID.");
        }
    }

    public static void updateAllAges() {
        for (Employee employee : employeeList) {
            employee.setAge();
        }
        System.out.println("Age updated!");
    }

    public static void printEmployeeById(int id) {
        boolean found = false;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                System.out.println(employee);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Can't find an Employee with that EmployeeID.");
        }
    }

    public static void printAllEmployees() {
        System.out.println("ID    Name              Gender   Age  Profession");
        System.out.println("------------------------------------------------");
        employeeList.sort(Comparator.comparing(Employee::getHierarki));
        for (Employee employee : employeeList) {
            System.out.println(fixStringLength(employee.getId(), 4) + "  "
                    + fixStringLength(employee.getName(), 16) + "  "
                    + fixStringLength(employee.getGender(), 7) + "  "
                    + fixStringLength(employee.getAge(), 3) + "  "
                    + employee.getJob());
        }
        System.out.println("------------------------------------------------");
        calculateGenderEquality();
    }

    public static void printEmployeesByJob(String job) {
        System.out.println("ID    Name              Gender   Age  Profession");
        System.out.println("------------------------------------------------");
        if (job.equalsIgnoreCase("owner")) {
            for (Employee employee : employeeList) {
                if (employee instanceof Owner) {
                    System.out.println(fixStringLength(employee.getId(), 4) + "  "
                    + fixStringLength(employee.getName(), 16) + "  "
                    + fixStringLength(employee.getGender(), 7) + "  "
                    + fixStringLength(employee.getAge(), 3) + "  "
                    + employee.getJob());
                }
            }
        }
        if (job.equalsIgnoreCase("headchef")) {
            for (Employee employee : employeeList) {
                if (employee instanceof HeadChef) {
                    System.out.println(fixStringLength(employee.getId(), 4) + "  "
                    + fixStringLength(employee.getName(), 16) + "  "
                    + fixStringLength(employee.getGender(), 7) + "  "
                    + fixStringLength(employee.getAge(), 3) + "  "
                    + employee.getJob());
                }
            }
        }
        if (job.equalsIgnoreCase("chef")) {
            for (Employee employee : employeeList) {
                if (employee instanceof Chef) {
                    System.out.println(fixStringLength(employee.getId(), 4) + "  "
                    + fixStringLength(employee.getName(), 16) + "  "
                    + fixStringLength(employee.getGender(), 7) + "  "
                    + fixStringLength(employee.getAge(), 3) + "  "
                    + employee.getJob());
                }
            }
        }
        if (job.equalsIgnoreCase("waiter")) {
            for (Employee employee : employeeList) {
                if (employee instanceof Waiter) {
                    System.out.println(fixStringLength(employee.getId(), 4) + "  "
                    + fixStringLength(employee.getName(), 16) + "  "
                    + fixStringLength(employee.getGender(), 7) + "  "
                    + fixStringLength(employee.getAge(), 3) + "  "
                    + employee.getJob());
                }
            }
        }
        System.out.println("------------------------------------------------");
    }
    
    public static void printSalaryList() {
        boolean found = false;
        System.out.println("What month you like to print? (1-12)");
        int month = readInt();
        for (Income t : Transactionlist.incomeList) {
            if (t.getMonth() == month) {
                Transactionlist.setAllBonusByMonth(month);
                Transactionlist.setAllSalary();                
                for (Employee employee : employeeList) {
                    if (employee instanceof Owner){
                        employee.setSalary((int)t.getProfit());
                    }
                }
                found = true;
                break;
            }

        }
        if (found) {
            System.out.println("ID  Profession    Name                  Salary    Bonus     Total Salary");
            System.out.println("-----------------------------------------------------------------------------");
            for (Employee employee : employeeList) {
                System.out.println(fixStringLength(employee.getId(), 4)
                        + fixStringLength(employee.getJob(), 14)
                        + fixStringLength(employee.getName(), 22)
                        + fixStringLength(employee.getSalary(), 10)
                        + fixStringLength(df.format(employee.getBonus()), 10)
                        + df.format(employee.getSalary() + employee.getBonus()));
            }
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Average salary (excluding the owner): " + ((getAllSalary()-(employeeList.size()-1))) + ":-");
            System.out.println("Highest salary (excluding the owner): " + getMaxSalary() + ":-");
            System.out.println("Lowest salary: " + getMinSalary() + ":-");
        } else {
            System.out.println("Can't find an income for that month");
        }
    }
    
    private static int getMinSalary () {
        int minSalary = employeeList.get(0).getSalary();
        for (Employee i : employeeList) {
            if (i.getSalary() < minSalary) {
                minSalary = i.getSalary();
            }
        }
        return minSalary;
    } 
    
    private static int getMaxSalary () {
        int maxSalary = 0;
        for (Employee i : employeeList) {
            if (i instanceof Owner) {                
            }
            else if (i.getSalary() > maxSalary) {
                maxSalary = i.getSalary();
            }
        }
        return maxSalary;
    }

    private static String fixStringLength(String start, int length) {
        if (start.length() >= length) {
            return start.substring(0, length);
        } else {
            while (start.length() < length) {
                start += " ";
            }
        }
        return start;
    }

    private static String fixStringLength(int start, int length) {
        String stringStart = String.valueOf(start);
        return fixStringLength(stringStart, length);
    }

    private static String fixStringLength(double start, int length) {
        String stringStart = String.valueOf(start);
        return fixStringLength(stringStart, length);
    }

    public static int getAllSalary() {
        int salary = 0;
        for (Employee employee : employeeList) {
            salary += employee.getSalary();
        }
        return salary;
    }
    
    public static void calculateGenderEquality () {
        double male = 0;
        double female = 0;
        double unknown= 0;
        int nEmployees = employeeList.size();
        
        for (Employee i : employeeList) {
            if (i.getGender().equalsIgnoreCase("Female")) {
                female++;
                
            } else if (i.getGender().equalsIgnoreCase("Male")) {
                male++;
            }
        }
        if (((female+male)/nEmployees) == 1) {
            unknown = 0;
        } else {
            unknown = nEmployees - (male + female);
        }
        System.out.println("Female percentage: " + ((female / nEmployees) * 100) +"%");
        System.out.println("Male percentage: " + ((male / nEmployees) * 100) +"%");
        System.out.println("Unknown percentage: " + ((unknown / nEmployees) * 100) +"%");
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
