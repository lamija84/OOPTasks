package week13.github.lab.task2;

import week13.github.lab.task2.Payment;

public class CreditCardPayment implements Payment {
    @Override
    public void processPayment() {
        System.out.println("Processing Credit Card Payment");
    }
}
