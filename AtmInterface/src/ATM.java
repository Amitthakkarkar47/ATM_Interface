import java.util.HashMap;
import java.util.Map;

public class ATM {
    
    private Map<String, User> userDatabase;

    public ATM() {
        this.userDatabase = new HashMap<>();
        // Add some sample users
        userDatabase.put("user123", new User("user123", "1998", 1000.0));
        userDatabase.put("user456", new User("user456", "1998", 2000.0));
        userDatabase.put("user321", new User("user321", "1998", 3000.0));
        userDatabase.put("user567", new User("user567", "1998", 4000.0));
    }

    //Authenticate User method
    public boolean authenticateUser(String userID, String userPIN) {
        User user = userDatabase.get(userID);
        return user != null && user.getUserPIN().equals(userPIN);
    }

    //checkBalance method
    public double checkBalance(String userID) {
        return userDatabase.get(userID).getAccountBalance();
    }

    //Withdraw Money moethod
    public void withdrawMoney(String userID, double amount) {
        User user = userDatabase.get(userID);
        if (user != null && user.getAccountBalance() >= amount) {
            user.setAccountBalance(user.getAccountBalance() - amount);
            System.out.println("Withdrawal successful. Remaining balance: " + user.getAccountBalance());
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    //deposit Money method
    public void depositMoney(String userID, double amount) {
        User user = userDatabase.get(userID);
        if (user != null) {
            user.setAccountBalance(user.getAccountBalance() + amount);
            System.out.println("Deposit successful. New balance: " + user.getAccountBalance());
        } else {
            System.out.println("User not found.");
        }
    }
}
    

