package with.templatemethod;

import without.templatemethod.VisaCard;

public abstract class PaymentProcessor {
   protected void proccessPayment(double amount, String currency, Customer customer){



       double dollarAmount=getDollarAmount(amount,currency);
       payment(dollarAmount,customer);

   }


   private double getDollarAmount(double amount, String currency){
       double dollerAmount=amount;
       // Euro
       if(currency.contentEquals("EUR")){
           dollerAmount=amount*1.1;
           System.out.println(amount +" convert "+currency+" to US dollars");
       }
       //INR
       if(currency.contentEquals("INR")){
           dollerAmount=amount*0.014;
           System.out.println(amount +" convert "+currency+" to US dollars");
       }
       return dollerAmount;
   }
   public abstract boolean validate();
   public abstract void payment(double amount,Customer customer);
}
