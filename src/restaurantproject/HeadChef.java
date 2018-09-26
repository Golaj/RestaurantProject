package restaurantproject;

public class HeadChef extends Employee{

    public HeadChef(String name, String gender, String personalNumber){
        super(name, gender, personalNumber);
        setJob("Head Chef");
        setSalary(85000);
        setHierarki(2);
    }
    
    @Override
    public void setBonus(double netAmount){
        double newBonus = 0;
        if (netAmount >= 3800000){
            newBonus = (netAmount * 0.005);
        }
        setPersonalBonus(newBonus);
    }
    
}
