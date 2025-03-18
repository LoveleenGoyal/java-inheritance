class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber + " | Balance: " + balance);
    }

    public void displayAccountType() {
        System.out.println("This is a generic Bank Account.");
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest applied: " + interest + " | New Balance: " + balance);
    }

    @Override
    public void displayAccountType() {
        System.out.println("This is a Savings Account. Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > withdrawalLimit) {
            System.out.println("Withdrawal failed. Exceeds withdrawal limit of " + withdrawalLimit);
        } else {
            super.withdraw(amount);
        }
    }

    @Override
    public void displayAccountType() {
        System.out.println("This is a Checking Account. Withdrawal Limit: " + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    private int duration;
    private double interestRate;

    public FixedDepositAccount(String accountNumber, double balance, int duration, double interestRate) {
        super(accountNumber, balance);
        this.duration = duration;
        this.interestRate = interestRate;
    }

    public void matureAccount() {
        double interest = balance * (interestRate / 100) * (duration / 12.0);
        balance += interest;
        System.out.println("Fixed Deposit matured! Interest Earned: " + interest + " | New Balance: " + balance);
    }

    @Override
    public void displayAccountType() {
        System.out.println("This is a Fixed Deposit Account. Duration: " + duration + " months | Interest Rate: " + interestRate + "%");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA12345", 5000, 4.5);
        CheckingAccount checking = new CheckingAccount("CA67890", 3000, 1000);
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD11122", 10000, 12, 5.0);

        savings.displayAccountType();
        checking.displayAccountType();
        fixedDeposit.displayAccountType();

        System.out.println("\n--- Transactions ---");
        savings.deposit(1000);
        savings.applyInterest();

        checking.withdraw(500);
        checking.withdraw(1500);

        fixedDeposit.matureAccount();
        fixedDeposit.displayBalance();
    }
}
