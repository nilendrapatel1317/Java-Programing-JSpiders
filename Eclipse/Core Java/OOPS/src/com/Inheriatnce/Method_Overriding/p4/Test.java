package com.Inheriatnce.Method_Overriding.p4;

public class Test {
    public static void main(String[] args) {
        char grade = 'B';
        short num = 10;
        String str = "Nilendra";
        
        switch (grade) {
            case 'A':
                System.out.println("Excellent");
                break;
            case 'B':
                System.out.println("Good");
                break;
            case 'C':
                System.out.println("Fair");
                break;
            default:
                System.out.println("Invalid Grade");
        }
        
        switch (str) {
        case "Nilendra":
        	System.out.println("Nilendra");
        	break;
        case "Nilofer":
        	System.out.println("Nilofer");
        	break;
        case "Jojo":
        	System.out.println("Jojo");
        	break;
        default:
        	System.out.println("Invalid Grade");
        }
        
        switch (num) {
        case 10:
        	System.out.println("10");
        	break;
        case 20:
        	System.out.println("20");
        	break;
        case 30:
        	System.out.println("30");
        	break;
        default:
        	System.out.println("Invalid Grade");
        }
    }
}
