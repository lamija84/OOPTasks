package week6.lab;

public class lab6TasksBeforeNightSky {
    /*public static int smallest(int[] array)
    {
        int minValue=array[0];
        for(int i=1;i< array.length;i++)
        {
            if(array[i]<minValue)
            {
                minValue=array[i];
            }
        }
        return minValue;
    }
    public static void main(String[] args)
    {
        int[] myArray={6,5,8,7,11};
        int smallestValue=smallest(myArray);
        System.out.println("The smallest value in the array is: " + smallestValue);
    }


    public static int indexOfTheSmallest(int[] array)
    {
        int min=array[0];
        int minIndex=0;
        for(int i=1;i< array.length;i++)
        {
            if(array[i]<min)
            {
                min=array[i];
                minIndex=i;
            }
        }
        return minIndex;
    }
    public static void main(String[] args)
    {
        int[] myArray={6,5,8,7,11};
        int minIndex=indexOfTheSmallest(myArray);
        System.out.println("Index of the smallest: " + minIndex);
    }


    public static int indexOfTheSmallestStartingFrom(int[] array, int index)
    {
        int smallestValue=array[index];
        int smallestIndex=index;
        for(int i=index+1;i< array.length;i++)
        {
            if(array[i]<smallestValue)
            {
                smallestValue=array[i];
                smallestIndex=i;
            }
        }
        return smallestIndex;
    }
    public static void main(String[] args)
    {
        int[] myArray={-1,6,9,8,12};
        System.out.println(indexOfTheSmallestStartingFrom(myArray,1));
        System.out.println(indexOfTheSmallestStartingFrom(myArray,2));
        System.out.println(indexOfTheSmallestStartingFrom(myArray,4));
    }


    public static void swap(int[] array, int index1, int index2)
    {
        int temp=array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
        }
        public static void main(String[] args)
        {
            int[] myArray={3,2,5,4,8};
            System.out.println(Arrays.toString(myArray));
            swap(myArray,1,0);
            System.out.println(Arrays.toString(myArray));
            swap(myArray,0,3);
            System.out.println(Arrays.toString(myArray));
        }


    public static boolean search(int[] array, int searchedValue)
    {
        int left=0;
        int right=array.length-1;
        while(left<=right)
        {
            int middle = left + (right - left) / 2;

            if(array[middle]==searchedValue)
            {
                return true;
            }
            if(array[middle]<searchedValue) //ignoring left half
            {
                left=middle+1;
            }
            else
            {
                right=middle-1;   //ignoring right half
            }

        }
        return false;

    }
    public static void main(String[] args) {
        int[] array = {-3, 2, 3, 4, 7, 8, 12};
        Scanner reader=new Scanner(System.in);

        System.out.println("Values of the array: " + Arrays.toString(array));
        System.out.println();

        System.out.println("Enter a searched number: ");
        String searchedValue= reader.nextLine();
        System.out.println();

        boolean result=search(array, Integer.parseInt(searchedValue));
        if(result==true)
        {
            System.out.println("Value " + searchedValue + " is in the array");
        }
        else
        {
            System.out.println("Value " + searchedValue + " is not in the array");
        }

    }

     */
    public static void printElegantly(int[] array) {
        if (array.length > 0) {     //// Print the first element without a leading comma.
            System.out.print(array[0]);

            for (int i = 1; i < array.length; i++) {
                System.out.print(", " + array[i]);
            }

        }

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        printElegantly(array);
    }
}




