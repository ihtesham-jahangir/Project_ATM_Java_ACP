package ATM;


import java.util.HashMap;
import java.util.Map;
/**
 * The class representing the bank database.
 */
public class BankDatabase {
    private Map<Integer, Account> accounts;
    /**
     * Constructor for the BankDatabase class.
     */
    public BankDatabase() {
        accounts = new HashMap<>();
        accounts.put(12345, new Account(12345, 12345, 1000.0, 1200.0));
        accounts.put(98765, new Account(98765, 56789, 200.0, 200.0));
    }
    /**
     * Retrieves the account with the specified account number.
     *
     * @param accountNumber The account number.
     * @return The account with the specified account number.
     */
    private Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }
    /**
     * Authenticates the user with the specified account number and PIN.
     *
     * @param accountNumber The account number.
     * @param pin           The PIN.
     * @return True if the authentication is successful, false otherwise.
     */
    public boolean authenticateUser(int accountNumber, int pin) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            return account.validatePIN(pin);
        }
        return false;
    }
    /**
     * Retrieves the available balance of the account with the specified account number.
     *
     * @param accountNumber The account number.
     * @return The available balance of the account.
     */
    public double getAvailableBalance(int accountNumber) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            return account.getAvailableBalance();
        }
        return 0;
    }
    /**
     * Retrieves the total balance of the account with the specified account number.
     *
     * @param accountNumber The account number.
     * @return The total balance of the account.
     */
    public double getTotalBalance(int accountNumber) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            return account.getTotalBalance();
        }
        return 0;
    }
    /**
     * Debits the account with the specified account number by the specified amount.
     *
     * @param accountNumber The account number.
     * @param amount        The amount to debit.
     */
    public void debit(int accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.debit(amount);
        }
    }
    /**
     * Credits the account with the specified account number by the specified amount.
     *
     * @param accountNumber The account number.
     * @param amount        The amount to credit.
     */
    public void credit(int accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.credit(amount);
        }
    }
}
