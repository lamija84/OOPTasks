package week6.lab;
import java.util.ArrayList;
import java.util.List;

public class GenericsMethods {
    /*public static void main(String[] args)
    {
        List < Integer > integers = List.of(1, 2, 3, 4, 5, 6, 7);
        List < Double > doubles = List.of(2.0, 1.5, 4.5, 2.5, 1.5);
        sum(integers);
        sum(doubles);
    }
*/

    public static <T extends Number> void sum(List<T> numbers)
    {
        double evenSum=0;
        double oddSum=0;
       for(T number:numbers)
       {
           if(number.doubleValue()%2==0)
           {
               evenSum+=number.doubleValue();
           }
           else {
               oddSum+=number.doubleValue();
           }
       }
        System.out.println("\nOriginal list of numbers: " + numbers);
        System.out.println("Sum of even numbers: " + evenSum);
        System.out.println("Sum of odd numbers: " + oddSum);

    }


    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversedList = new ArrayList<>();

        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }

    /*public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<String> colors = List.of("Red", "Green", "Orange");

        List<Integer> reversedNumbers = reverseList(numbers);
        System.out.println("Original list of numbers: " + numbers);
        System.out.println("Reversed numbers: " + reversedNumbers); // Output: [6, 5, 4, 3, 2, 1]

        List<String> reversedWords = reverseList(colors);
        System.out.println("\nOriginal list of colors: " + colors);
        System.out.println("Reversed colors: " + reversedWords); // Output: [Orange, Green, Red]
    }

     */
}
