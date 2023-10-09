package lecture.week6;

public class Programmer extends Employee2{
    private int bonus;
    public Programmer(String name, int baseSalary, int bonus){
        super(name, baseSalary);
        this.bonus = bonus;
    }
    public int getBonus(){
        return bonus;
    }
    @Override
    public int calculateSalary(){
        return super.calculateSalary() + bonus;
    }
}
