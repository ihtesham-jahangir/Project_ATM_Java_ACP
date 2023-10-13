package ATM;

/**
 * The class representing the cash dispenser.
 */
public class CashDispenser {
    private static final int INITIAL_COUNT = 500;
    private int count;
    /**
     * Constructor for the CashDispenser class.
     */
    public CashDispenser() {
        count = INITIAL_COUNT;
    }
    /**
     * Checks if there is sufficient cash available.
     *
     * @param amount The amount to check.
     * @return True if there is sufficient cash available, false otherwise.
     */
    public boolean isSufficientCashAvailable(double amount) {
        int requiredBills = (int) (amount / 20);
        return count >= requiredBills;
    }
    /**
     * Dispenses cash.
     *
     * @param amount The amount to dispense.
     */
    public void dispenseCash(double amount) {
        int billsToDispense = (int) (amount / 20);
        count -= billsToDispense;
    }
}
