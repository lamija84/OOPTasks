package week13.github.lab.task2;

import week13.github.lab.task2.PayPalPayment;
import week13.github.lab.task2.Payment;
import week13.github.lab.task2.PaymentFactory;

public class PayPalPaymentFactory implements PaymentFactory {
    @Override
    public Payment createPayment() {
      return new PayPalPayment();
    }
}
