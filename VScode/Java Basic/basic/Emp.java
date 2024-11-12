import java.util.Scanner;

public class Emp {
    static String emp_name;
    static float emp_sal;

    static void set(String name , float sal){
        emp_name = name;
        emp_sal = sal;
    }

    static void get(){
        System.out.print("Employee Name : " + emp_name);
        System.out.println();
        System.out.print("Employee salary : " + emp_sal);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = scn.nextLine();
        System.out.print("Enter your salary : ");
        float salary = scn.nextFloat();

        Emp.set(name,salary);
        Emp.get();

    }
}
