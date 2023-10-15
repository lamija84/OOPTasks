package week2;

import java.util.Scanner;

public class Lecture2 {
    public static void main(String[] args)
    {
        System.out.println("Enter your age:");
        Scanner reader=new Scanner(System.in);
        int age=Integer.parseInt(reader.nextLine());
        while(age < 5 || age > 85)
        {

            if (age < 5)
            {
                System.out.println("Its not okay!");
            }
            else if(age > 85) {
                System.out.println("Its not okay again");
            }
            System.out.println("Enter your age again: ");
            age = Integer.parseInt(reader.nextLine());


        }
        System.out.println("Your age is " + age);
    }
}