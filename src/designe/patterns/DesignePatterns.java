package designe.patterns;

enum PaymentMode{
    UPI,
    CREDIT_CARD,
    DEBIT_CARD;
}


interface PaymentStratgy {

    public void pay(Double amount);
}

class UPI implements PaymentStratgy{
    @Override
    public void pay(Double amount) {
        // validation like amount should be in account : might be some bank api  is use here
        System.out.println("paying by UPI mode  and amount is : "+amount);
    }
}

class DebitCard implements PaymentStratgy{
    @Override
    public void pay(Double amount) {
        // validation like amount should be in account : might be some bank api  is use here
        System.out.println("paying by Debit card and amount is : "+amount);
    }
}

class PaymentmodeContext{

    public static PaymentStratgy getPaymentMode(PaymentMode mode){
        switch (mode){
            case UPI: {
                return new UPI();
            }
            case DEBIT_CARD:{
                return new DebitCard();
            }
            default:{
                throw new IllegalArgumentException("Unsupported payment mode: " + mode);
            }
        }
    };
}


class PaymentContext {

    public void MakePayment(Double amount, PaymentMode mode){
        PaymentStratgy paymentStratgy = PaymentmodeContext.getPaymentMode(mode);
        paymentStratgy.pay(amount);
    }
}


public class DesignePatterns {

    public static void main(String[] args) {
        try {
            PaymentContext paymentContext = new PaymentContext();
            paymentContext.MakePayment(1000.0 , PaymentMode.UPI);
            paymentContext.MakePayment(1000.0,PaymentMode.DEBIT_CARD);
            paymentContext.MakePayment(2000.0,PaymentMode.CREDIT_CARD);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
