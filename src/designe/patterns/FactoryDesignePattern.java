package designe.patterns;

enum PaymentModeOptions {
    UPI,
    CREDIT_CARD,
    DEBIT_CARD,
    NET_BANKING;
}

interface PaymentStratgies {
    public void pay(Double amount);
}

class Upi implements PaymentStratgies{

    @Override
    public void pay(Double amount) {
        // validation for amount from bank api
        System.out.println("payment done by upi for amount : "+ amount);
    }
}
class Credit implements PaymentStratgies{

    @Override
    public void pay(Double amount) {
        System.out.println("payment done by Credit for amount : "+ amount);
    }
}
class Debit implements PaymentStratgies{

    @Override
    public void pay(Double amount) {
        System.out.println("payment done by debit for amount : "+ amount);
    }
}


class PaymentModeFactory {
    public static PaymentStratgies getPayMentMode(PaymentModeOptions mode){
        switch (mode){
            case UPI: {
                return new Upi();
            }
            case CREDIT_CARD: {
                return new Credit();
            }
            case DEBIT_CARD:{
                return new Debit();
            }
            default:{
                throw new IllegalArgumentException("this is not valid payment Mode "+mode+
                        "Pls select correct mode of payment" );
            }
        }
    }
}


class PaymentContexts {

    public void makePayment(Double amount , PaymentModeOptions mode ){
        PaymentStratgies paymentStratgies = PaymentModeFactory.getPayMentMode(mode);
        paymentStratgies.pay(amount);
    }
}


public class FactoryDesignePattern {
    public static void main(String[] args) {
        PaymentContexts paymentContexts = new PaymentContexts();
        try{
            paymentContexts.makePayment(1200.0,PaymentModeOptions.CREDIT_CARD);
            paymentContexts.makePayment(1200.0,PaymentModeOptions.UPI);
            paymentContexts.makePayment(1200.0,PaymentModeOptions.DEBIT_CARD);
            paymentContexts.makePayment(1200.0,PaymentModeOptions.NET_BANKING);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
