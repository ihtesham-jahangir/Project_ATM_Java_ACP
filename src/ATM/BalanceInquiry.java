package ATM;


/**
 * The class representing a balance inquiry transaction.
 */
public class BalanceInquiry extends Transaction {
    /**
     * Constructor for the BalanceInquiry class.
     *
     * @param accountNumber The account number of the user.
     * @param bankDatabase  The bank database.
     * @param screen        The screen.
     */
    public BalanceInquiry(int accountNumber, BankDatabase bankDatabase, Screen screen) {
        super(accountNumber, bankDatabase, screen);
    }
    /**
     * Executes the balance inquiry transaction.
     */
    @Override
    public void execute() {
        double availableBalance = getBankDatabase().getAvailableBalance(getAccountNumber());
        double totalBalance = getBankDatabase().getTotalBalance(getAccountNumber());
        getScreen().displayMessageLine("Balance Information:");
        getScreen().displayMessage(" - Available balance: ");
        getScreen().displayDollarAmount(availableBalance);
        getScreen().displayMessage("\n - Total balance:     ");
        getScreen().displayDollarAmount(totalBalance);
        getScreen().displayMessageLine("");
    }
}
