package ATM;

/**
 * The abstract class representing a transaction.
 */
public abstract class Transaction {
    private int accountNumber;
    private BankDatabase bankDatabase;
    private Screen screen;

    /**
     * Constructor for the Transaction class.
     *
     * @param accountNumber The account number of the user.
     * @param bankDatabase  The bank database.
     * @param screen        The screen.
     */
    public Transaction(int accountNumber, BankDatabase bankDatabase, Screen screen) {
        this.accountNumber = accountNumber;
        this.bankDatabase = bankDatabase;
        this.screen = screen;
    
    }
    /**
     * Retrieves the account number.
     *
     * @return The account number.
     */
    protected int getAccountNumber() {
        return accountNumber;
    }
    /**
     * Retrieves the bank database.
     *
     * @return The bank database.
     */
    protected BankDatabase getBankDatabase() {
        return bankDatabase;
    }
    /**
     * Retrieves the screen.
     *
     * @return The screen.
     */
    protected Screen getScreen() {
        return screen;
    }
    /**
     * Retrieves the email notification system.
     *
     * @return The email notification system.
     */
  
    /**
     * Executes the transaction.
     */
    public abstract void execute();
}
