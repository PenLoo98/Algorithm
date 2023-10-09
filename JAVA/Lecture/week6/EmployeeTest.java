package lecture.week6;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee e = new Employee("Kim", "20210001");
        System.out.println(e);

        Employee e2 = new Employee("Kim");
        System.out.println(e2);

        Employee e3 = new Employee();
        System.out.println(e3);
    }
}
