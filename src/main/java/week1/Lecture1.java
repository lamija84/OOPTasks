package week1;

import java.util.Scanner;

public class Lecture1 {
    public static void main(String[] args)
    {
        System.out.println("Welcome to the calculator!");
        while(true)
        {
            System.out.println("Enter the opperation(sum,difference,quit):");
            Scanner reader=new Scanner(System.in);
            String opperation= reader.nextLine();
            if(opperation.equals("quit"))
            {
                break;
            }
            System.out.println("Enter the numbers: ");
            int firstNumber=Integer.parseInt(reader.nextLine());
            int secondNumber=Integer.parseInt(reader.nextLine());
            if(opperation.equals("sum"))
            {
                int sum=firstNumber+secondNumber;
                System.out.println("Sum is: "+sum);
            }
            else if(opperation.equals("difference"))
            {
                int diff=firstNumber-secondNumber;
                System.out.println("Difference is: "+diff);
            }
            else
            {
                System.out.println("Sorry, you entered unknown opperation.");
            }
        }
        System.out.println("Thanks,bye!");
    }
}
