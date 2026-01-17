import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while(true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    int accNum = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();
                    bank.addAccount(new BankAccount(accNum, name, balance));
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    accNum = sc.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    bank.depositToAccount(accNum, depositAmount);
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accNum = sc.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    bank.withdrawFromAccount(accNum, withdrawAmount);
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    accNum = sc.nextInt();
                    bank.displayAccount(accNum);
                    break;

                case 5:
                    System.out.println("Thank you for using the bank!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}

