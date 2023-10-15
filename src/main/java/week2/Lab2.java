package week2;

import java.util.Scanner;

/*public class Lab2 {
    public static void main(String[] args)
    {

        String password="carrot";
        Scanner reader=new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter a password: ");
            String yourPassword=reader.nextLine();
            if(yourPassword.equals(password))
            {
                System.out.println("Correct!");
                System.out.println("Secret message is: jryy qbar!");
                break;
            }
            else
            {
                System.out.println("Wrong!");
            }

        }

    }
}
 */
/*
import java.util.Scanner;
public class Lab2 {
    public static void main(String[] args)
    {
        Scanner reader=new Scanner(System.in);
        int sum=0;
        int read=3;

        for(int i=0;i<read;i++)
        {
            System.out.println("Type the number: ");
            sum+=Integer.parseInt(reader.nextLine());
        }
        System.out.println("Sum is: "+ sum);
    }
}

public class Lab2{
    public static void main(String[] args)
    {
        int sum=0;
        Scanner reader=new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter a number: ");
            int read=Integer.parseInt(reader.nextLine());
            if(read==0)
            {
                break;
            }
            sum+=read;
            System.out.println("Sum now is:" +sum);
        }
        System.out.println("Sum in the end is: " +sum);
    }
}
*/
public class Lab2{
    public static void main(String[] args)
    {

        Scanner reader=new Scanner(System.in);
        System.out.println("Enter first number: ");
        int first=Integer.parseInt(reader.nextLine());
        System.out.println("Enter last number: ");
        int last=Integer.parseInt(reader.nextLine());
        if(first<last)
        {
            int i=first;
            while(i<=last)
            {
                System.out.println(i);
                i++;
            }
        }
        else {
            System.out.println();
        }
    }
}