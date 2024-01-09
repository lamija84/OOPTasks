package week13.github.lab.task2;

public class CreditCardPaymentFactory implements PaymentFactory {
    public Payment createPayment() {
return new CreditCardPayment();
    }
}

