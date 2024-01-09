package week13.github.lab.task2;

public class Main2 {
    public static void main(String[] args)
    {
      PaymentFactory CreditCardFactory=new CreditCardPaymentFactory();
      Payment CreditCardPayment= CreditCardFactory.createPayment();
      CreditCardPayment.processPayment();

      PaymentFactory PayPalFactory= new PayPalPaymentFactory();
      Payment PayPalPayment=PayPalFactory.createPayment();
      PayPalPayment.processPayment();  //Instantiate payment factories and use them to create different payment objects.
        // Call the processPayment method on each payment object.


    }
}
