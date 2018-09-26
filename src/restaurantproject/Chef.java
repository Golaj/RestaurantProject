package restaurantproject;

public class Chef extends Employee{
    
    

    public Chef(String name, String gender, String personalNumber){
        super(name, gender, personalNumber);
        setJob("Chef");
        super.setSalary(32000);
        setHierarki(3);
    }
    
    @Override
    public void setBonus(double netAmount){
        double newBonus = 0;
        if(netAmount >= 3800000){
            newBonus = netAmount * 0.001;
        }
        setPersonalBonus(newBonus);
    }
    
}
