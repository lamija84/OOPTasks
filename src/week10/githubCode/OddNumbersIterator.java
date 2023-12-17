package week10.githubCode;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OddNumbersIterator implements Iterator<Integer> {
    private int[] numbers;
    private int currentIndex = 0;

    public OddNumbersIterator(int[] numbers) {
        this.numbers = numbers;
    }

    public boolean hasNext() {
        while (currentIndex < numbers.length && numbers[currentIndex] % 2 == 0) {
            currentIndex++; //skip even numbers
        }
        return currentIndex < numbers.length;
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return numbers[currentIndex++];
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        OddNumbersIterator oddNumbersIterator = new OddNumbersIterator(numbers);
        while (oddNumbersIterator.hasNext()) {
            System.out.println(oddNumbersIterator.next());
        }
    }
}
