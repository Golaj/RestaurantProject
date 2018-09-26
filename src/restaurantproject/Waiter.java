package restaurantproject;

public class Waiter extends Employee{
    
    private static int numberOfWaiters = 0;

    public Waiter (String name, String gender, String personalNumber){
        super(name, gender, personalNumber);
        setJob("Waiter");
        super.setSalary(25000);
        numberOfWaiters++;
        setHierarki(4);
    }
    
    @Override
    public void setBonus(double tip){
        double newBonus = (tip / numberOfWaiters);
        setPersonalBonus(newBonus);
    }

}
