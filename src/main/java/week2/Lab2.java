package week2;
import java.util.Random;
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

public class Lab2 {
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a number of raising: ");
        int power = reader.nextInt();
        int sum = 0;
        for (int i = 0; i <= power; i++)
        {
            int result = (int) Math.pow(2, i);
            sum += result;
        }
        System.out.println("Result is: " + sum);
    }
}

public class Lab2 {
    public static void main(String[] args)
    {
        Scanner reader=new Scanner(System.in);
        System.out.println("Enter the number of times that text should be printed: ");
        int number=Integer.parseInt(reader.nextLine());
        for(int i=0;i<number;i++)
        {
            printText();

        }

    }
    public static void printText()
    {
        System.out.println("In the beginning there were the swamp, the hoe and Java.");

    }
}

public class Lab2 {
    public static void main(String[] args)
    {
        printStars(3);
        printStars(5);
        printStars(1);
    } private static void printStars(int amount)
    {
        for(int i=0;i<amount;i++) //ne smije biti jednako amountu jer kreće od 0
        {
            System.out.print("*"); //samo print zato što ne treba odmah ići u drugi red
        }
        System.out.println();
    }

}
public class Lab2 {
    public static void main(String[] args)
    {
       drawStarsPiramid(5);
    }
    public static void drawStarsPiramid(int rows)
    {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
public class Lab2 {
    public static void main(String[] args)
    {
        drawStarsPiramid(5);
    }
    public static void drawStarsPiramid(int rows)
    {
        for(int i=rows-1;i>=0;i--) // i>=0 da bi dosao i do zadnje prve zvjezdice
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
}
public class Lab2 {
    public static void main(String[] args)
    {
        drawStarsPiramid(5);
    }
    public static void drawStarsPiramid(int rows)
    {
        for(int i=0;i<rows;i++)
        {
            int number=1;
            for(int j=0;j<=i;j++)
            {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }
}
public class Lab2 {
    public static void main(String[] args)
    {
        drawStarsPiramid(10);
    }
    public static void drawStarsPiramid(int rows)
    {

        for(int i=1;i<=rows;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print(i + " ");

            }

            System.out.println();
        }
    }
}
//drugi način
public class Lab2 {
    public static void main(String[] args) {
        drawStarsPiramid(10);
    }

    public static void drawStarsPiramid(int rows) {
        int number = 1;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                System.out.print(number + " ");

            }
            number++;
            System.out.println();
        }
    }
}
public class Lab2
{
    public static void main(String[] args)
    {
        Random random = new Random();
        int numberToGuess = drawNumber(random);
        Scanner scanner = new Scanner(System.in);
        int numberOfGuesses = 0;
        int userGuess; // Declare the variable outside the loop

        do {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt(); // Move this line inside the loop
            numberOfGuesses++;

            if (userGuess < 0 || userGuess > 100) {
                System.out.println("Please enter a number between 0 and 100.");
            } else if (userGuess == numberToGuess) {
                System.out.println("Congratulations, your guess is correct!");
                System.out.println("You made " + numberOfGuesses + " guesses.");
            } else if (userGuess < numberToGuess) {
                System.out.println("The number is greater.");
            } else {
                System.out.println("The number is lesser.");
            }
        } while (numberToGuess != userGuess);

        scanner.close();
    }

    // Method to draw a random number
    public static int drawNumber(Random random) {
        return random.nextInt(101); // Generate a random number between 0 and 100
    }
}
*/






