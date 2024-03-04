import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.println("Welcome to the ATM Interface!");

        System.out.print("Enter User ID: ");
        String userID = scanner.next();

        System.out.print("Enter PIN: ");
        String userPIN = scanner.next();

        if (atm.authenticateUser(userID, userPIN)) {
            System.out.println("Authentication successful. Welcome, " + userID + "!");
            displayMenu(atm, userID, scanner);
        } else {
            System.out.println("Invalid credentials. Exiting...");
        }
        scanner.close();
    }

    private static void displayMenu(ATM atm, String userID, Scanner scanner) {
        while (true) {
            System.out.println("\n ATM Menu: ");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + atm.checkBalance(userID));
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdrawMoney(userID, withdrawAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    atm.depositMoney(userID, depositAmount);
                    break;

                case 4:
                    System.out.println("Exiting. Thank you!");
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
