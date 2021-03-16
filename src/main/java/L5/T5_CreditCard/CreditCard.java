package L5.T5_CreditCard;

public class CreditCard {
    private String number;
    private String password;
    private int balance;
    private int creditLimit;
    private int creditLoan;

    public CreditCard(String number, String password) {
        this.number = number;
        this.password = password;
    }


    public boolean deposit(int deposit, String password) {
        if (checkPassword(password)) {
            if (creditLoan > 0) {
                if (deposit <= creditLoan) {
                    creditLoan -= deposit;
                } else {
                    balance += deposit - creditLoan;
                    creditLoan = 0;
                }
            } else {
                balance += deposit;
            }
            System.out.println("Баланс успешно пополнен");
            return true;
        }
        return false;
    }



    public boolean withdraw(int withdraw, String password) {
        if (checkPassword(password)) {
            if (withdraw <= balance) {
                balance -= withdraw;
                System.out.println("списание с баланса");
            } else if (withdraw <= (balance + creditLimit - creditLoan)) {
                creditLoan = creditLoan - balance + withdraw;
                balance = 0;
            } else {
                System.out.println("Недостаточно средств");
                return false;
            }
            System.out.println("Транзакция произведена успешно!");
            return true;
        } else return false;
    }

    private boolean checkPassword(String password) {
        if ((this.password).equals(password)) {
            return true;
        }
        System.out.println("Не верный пин-код.");
        return false;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setLimit(int limit) {
        creditLimit = limit;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public int getBalance() {
        return balance;
    }

    public int getCreditLoan() {
        return creditLoan;
    }

    public void setCreditLoan(int creditLoan) {
        this.creditLoan = creditLoan;
    }
}
