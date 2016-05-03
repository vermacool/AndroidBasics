package com.sked.androidbasics.core;

/**
 * Created by manish on 2/8/2016.
 */
import java.util.Scanner;
public class ScannerClass {
    public  static void main(String args[]){
        System.out.println("enter ID,Name,Salary");
        Scanner sc=new Scanner(System.in);
        int id=sc.nextInt();
        String name=sc.next();
        float salary=sc.nextFloat();
        System.out.println("ID No."+id);
        System.out.println("Name."+name);
        System.out.println("Salary."+salary);

    }
}
