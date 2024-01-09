package week13.github.lab.task2;

import week13.github.lab.task2.Payment;

public class PayPalPayment implements Payment {
    @Override
    public void processPayment() {
        System.out.println("Processing PayPal Payment");
    }
}
