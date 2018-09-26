package restaurantproject;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Employee {

    private String name;
    private String gender;
    private String personalNumber;
    private int age;
    private int salary;
    private double bonus;
    private int id;
    private String job;
    private int hierarki;
    
    private static int nId = 1;
    private static String pattern = "yyyyMMdd";
    private static SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    private static int date = Integer.parseInt(sdf.format(new Date()));
    
    public Employee(String name, String gender, String personalNumber){
        this.name = name;
        this.gender = gender;
        this.personalNumber = personalNumber;
        age = setAgeByPnum();
        id = nId;
        nId++;
    }

    public int getHierarki() {
        return hierarki;
    }

    public void setHierarki(int hierarki) {
        this.hierarki = hierarki;
    }
    
    
    
    public void setAge(){
        age = setAgeByPnum();
    }
    
    private int setAgeByPnum(){
        int pNumber = Integer.parseInt(personalNumber.substring(0, 8));
        String sage = String.valueOf(date-pNumber);
        int newAge = Integer.parseInt(sage.substring(0, 2));
        return newAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public abstract void setBonus(double bonus);
    
    public void setPersonalBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getGender() {
        return gender;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }
    
    public void setPersonalNumber(String pnum){
        personalNumber = pnum;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    @Override
    public String toString() {
        return "{" + "ID = " + id + ", Name = " + name + ", Gender = " + gender + ", Age = " + age + ", Profession = " + job + '}';
    }
    
    
}
