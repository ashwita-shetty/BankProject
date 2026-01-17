import java.io.*;
import java.util.*;

public class Bank {
    private ArrayList<BankAccount> accounts;
    private final String FILE_NAME = "accounts.dat";

    public Bank() {
        accounts = new ArrayList<>();
        loadAccounts();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        saveAccounts();
        System.out.println("Account created successfully!");
    }

    public BankAccount findAccount(int accountNumber) {
        for(BankAccount acc : accounts) {
            if(acc.getAccountNumber() == accountNumber)
                return acc;
        }
        return null;
    }

    private void saveAccounts() {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(accounts);
        } catch(IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    private void loadAccounts() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            accounts = (ArrayList<BankAccount>) in.readObject();
        } catch(Exception e) {
            accounts = new ArrayList<>();
        }
    }

    public void depositToAccount(int accountNumber, double amount) {
        BankAccount acc = findAccount(accountNumber);
        if(acc != null) {
            acc.deposit(amount);
            saveAccounts();
        } else {
            System.out.println("Account not found!");
        }
    }

    public void withdrawFromAccount(int accountNumber, double amount) {
        BankAccount acc = findAccount(accountNumber);
        if(acc != null) {
            acc.withdraw(amount);
            saveAccounts();
        } else {
            System.out.println("Account not found!");
        }
    }

    public void displayAccount(int accountNumber) {
        BankAccount acc = findAccount(accountNumber);
        if(acc != null) {
            acc.display();
        } else {
            System.out.println("Account not found!");
        }
    }
}

