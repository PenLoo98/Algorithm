package lecture.week6;

public class Employee2 {
    private String name;
    private int baseSalary;
    public Employee2(String name, int baseSalary){
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public String getName(){
        return name;
    }
    public int getBaseSalary(){
        return baseSalary;
    }
    public int calculateSalary() {
        return baseSalary;
    }

    static public class EmployeeTest2{
        public static void main(String[] args) {
            Programmer programmer = new Programmer("Kim", 300000, 200000);
            Manager manager = new Manager("Lee", 300000, 300000);

            System.out.println(programmer.getName() + "'s Salary: " + programmer.calculateSalary() + "원");
            System.out.println(manager.getName() + "'s Salary: " + manager.calculateSalary() + "원");
        }
    }
}
