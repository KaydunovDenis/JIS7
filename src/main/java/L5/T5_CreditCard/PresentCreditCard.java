package L5.T5_CreditCard;

public class PresentCreditCard {
    public static void main(String[] args) {
        CreditCard myCard = new CreditCard("6467041946153399", "1234");
        myCard.setLimit(500);
        myCard.setCreditLoan(100);
        myCard.deposit(150, "1234");

        System.out.println(myCard.getBalance());

        myCard.withdraw(50, "1234");
//Should reject operation due to incorrect pin
        myCard.deposit(500, "4321");
//Should reject operation due to incorrect pin
        myCard.withdraw(500, "4321");
//Should reject operation because amount exceeds limit
        myCard.withdraw(5000, "1234");
    }
}
