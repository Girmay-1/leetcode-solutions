import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Comparator;

//to sort an array of objects we can implement comparable
public class Employees implements Comparable<Employees>{
    private String fistName;
    private String lastName;
    private double Salary;

    public Employees(String fistName, String lastName, double salary) {
        this.fistName = fistName;
        this.lastName = lastName;
        Salary = salary;
    }


    @Override
    public int compareTo(Employees o) {
        return (int) (this.getSalary() - o.getSalary());
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public static Comparator<Employees> salaryComparator= (emp1, emp2) -> (int) (emp1.getSalary() - emp2.getSalary());
    public static Comparator<Employees> nameComparator = Comparator.comparing(Employees::getFistName);

    public static void main(String[] args) {
        Employees[] employees =  new Employees[4];
        employees[0] = new Employees("Robert","Isabell",12400);
        employees[1] = new Employees("Amy","Fredo",10000);
        employees[2] = new Employees("Sara","Isreal",25000);
        employees[3] = new Employees("Simon","Tiffany",9000);
        //sorting using comparable
        Arrays.sort(employees);
        System.out.println(Arrays.toString(employees));
        //sorting using comparator
        Arrays.sort(employees, salaryComparator);
        System.out.println(Arrays.toString(employees));
        System.out.println("name comaprator:");
        Arrays.sort(employees, nameComparator);
        System.out.println(Arrays.toString(employees));



    }

    @Override
    public String toString() {

        return "Employees{" +
                "fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}


//