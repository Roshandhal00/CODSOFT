
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true; // Withdrawal successful
        }
        return false; // Insufficient balance
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayOptions() {
        System.out.println("1. Withdraw\n2. Deposit\n3. Check Balance\n4. Exit");
    }

    public void handleOption(int option, Scanner scanner) {
        switch (option) {
            case 1:
                handleWithdrawal(scanner);
                break;
            case 2:
                handleDeposit(scanner);
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }

    private void handleWithdrawal(Scanner scanner) {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        
        if (amount > 0 && amount <= userAccount.getBalance()) {
            userAccount.withdraw(amount);
            System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    private void handleDeposit(Scanner scanner) {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        
        if (amount > 0) {
            userAccount.deposit(amount);
            System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void checkBalance() {
        System.out.println("Current balance: " + userAccount.getBalance());
    }
}

public class Codsoft_taskno4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Assuming initial balance for the user's account is $1000
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);

        int option;
        do {
            atm.displayOptions();
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            atm.handleOption(option, scanner);
        } while (option != 4);
    }
}
