package restaurantproject;

public class Owner extends Employee{
    
    public Owner(String name, String gender, String personalNumber){
        super(name, gender, personalNumber);
        setJob("Owner");
        setHierarki(1);
    }
    
    @Override
    public void setSalary(int profit){
        super.setSalary(profit);
    }
    
    @Override
    public void setBonus(double bonus){
        bonus = 0;
    }
    
}
