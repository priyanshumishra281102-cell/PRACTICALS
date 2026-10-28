class InvalidAmountException extends Exception {
    InvalidAmountException(String message) {
        super(message);
    }
}

class BankAccount {
    private static int count = 0;
    private final int accountNo;
    private double balance;

    BankAccount(int accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void deposit(double amount)
            throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                "Amount must be positive"
            );
        }
        balance += amount;
    }

    public void withdraw(double amount)
            throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                "Amount must be positive"
            );
        }

        if (amount > balance) {
            throw new InvalidAmountException(
                "Insufficient balance"
            );
        }

        balance -= amount;
    }

    public void display() {
        System.out.println("Account Number: " + accountNo);
        System.out.println("Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(101, 5000);

        try {
            account.deposit(1000);
            System.out.println("Deposit successful.");

            account.withdraw(2000);
            System.out.println("Withdrawal successful.");

            account.withdraw(10000);
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction completed.");
        }

        System.out.println();
        account.display();

        System.out.println("Total accounts: "
                + BankAccount.getCount());
    }
}
