package ATM;


/**
 * The class representing an Account.
 */
public class Account {
    private int accountNumber;
    private int pin;
    private double availableBalance;
    private double totalBalance;
    /**
     * Constructor for the Account class.
     *
     * @param accountNumber    The Account number.
     * @param pin              The PIN.
     * @param availableBalance The available balance.
     * @param totalBalance     The total balance.
     */
    public Account(int accountNumber, int pin, double availableBalance, double totalBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.availableBalance = availableBalance;
        this.totalBalance = totalBalance;
    }
    /**
     * Validates the PIN.
     *
     * @param pin The PIN to validate.
     * @return True if the PIN is valid, false otherwise.
     */
    public boolean validatePIN(int pin) {
        return this.pin == pin;
    }
    /**
     * Retrieves the available balance.
     *
     * @return The available balance.
     */
    public double getAvailableBalance() {
        return availableBalance;
    }
    /**
     * Retrieves the total balance.
     *
     * @return The total balance.
     */
    public double getTotalBalance() {
        return totalBalance;
    }
    /**
     * Debits the Account by the specified amount.
     *
     * @param amount The amount to debit.
     */
    public void debit(double amount) {
        availableBalance -= amount;
        totalBalance -= amount;
    }
    /**
     * Credits the Account by the specified amount.
     *
     * @param amount The amount to credit.
     */
    public void credit(double amount) {
        totalBalance += amount;
    }
}
