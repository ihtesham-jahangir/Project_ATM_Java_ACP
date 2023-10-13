package ATM;


/**
 * The class representing a withdrawal transaction.
 */
public class Withdrawal extends Transaction {
    private Keypad keypad;
    private CashDispenser cashDispenser;
    /**
     * Constructor for the Withdrawal class.
     *
     * @param accountNumber   The account number of the user.
     * @param bankDatabase    The bank database.
     * @param screen          The screen.
     * @param keypad          The keypad.
     * @param cashDispenser   The cash dispenser.
     */
    public Withdrawal(int accountNumber, BankDatabase bankDatabase, Screen screen, Keypad keypad, CashDispenser cashDispenser) {
        super(accountNumber, bankDatabase, screen);
        this.keypad = keypad;
        this.cashDispenser = cashDispenser;
    }
    /**
     * Executes the withdrawal transaction.
     */
    @Override
    public void execute() {
        boolean cashDispensed = false;
        double amount = displayMenuOfAmounts();
        if (amount != 0) {
            if (getBankDatabase().getAvailableBalance(getAccountNumber()) >= amount) {
                if (cashDispenser.isSufficientCashAvailable(amount)) {
                    getBankDatabase().debit(getAccountNumber(), amount);
                    cashDispenser.dispenseCash(amount);
                    cashDispensed = true;
                    getScreen().displayMessageLine("Please take your cash from the cash dispenser.");
                          } else {
                    getScreen().displayMessageLine("Insufficient cash available in the ATM.");
                }
            } else {
                getScreen().displayMessageLine("Insufficient funds in your account.");
            }
        } else {
            getScreen().displayMessageLine("Canceling transaction...");
        }
        if (!cashDispensed) {
            getScreen().displayMessageLine("Transaction failed.");
        }
    }
    /**
     * Displays the menu of withdrawal amounts and returns the user's selection.
     *
     * @return The user's selection.
     */
    private double displayMenuOfAmounts() {
        int[] amounts = {20, 40, 60, 100, 200};
        boolean validSelection = false;
        int choice = 0;
        while (!validSelection) {
            getScreen().displayMessageLine("Withdrawal Menu:");
            for (int i = 0; i < amounts.length; i++) {
                getScreen().displayMessageLine((i + 1) + " - $" + amounts[i]);
            }
            getScreen().displayMessageLine((amounts.length + 1) + " - Cancel transaction");
            getScreen().displayMessage("Choose a withdrawal amount: ");
            choice = keypad.getInput();
            if (choice >= 1 && choice <= amounts.length) {
                validSelection = true;
            } else if (choice == amounts.length + 1) {
                return 0;
            } else {
                getScreen().displayMessageLine("Invalid selection. Please try again.");
            }
        }
        return amounts[choice - 1];
    }
}
