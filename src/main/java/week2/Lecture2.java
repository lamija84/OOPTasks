package week2;

import java.util.Scanner;

public class Lecture2 {
    public static void main(String[] args)
    {
        System.out.println("Enter your age:");
        Scanner reader=new Scanner(System.in);
        int age=Integer.parseInt(reader.nextLine());
        while(age>5 || age<58)
        {
            System.out.println("Its ok");
            break;

        }
        System.out.println("Enter your age:");
}}
