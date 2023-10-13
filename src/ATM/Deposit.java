package ATM;


/**
 * The class representing a deposit transaction.
 */
public class Deposit extends Transaction {
    private Keypad keypad;
    private CashDispenser cashDispenser;
    private DepositSlot depositSlot;
    /**
     * Constructor for the Deposit class.
     *
     * @param accountNumber   The account number of the user.
     * @param bankDatabase    The bank database.
     * @param screen          The screen.
     * @param keypad          The keypad.
     * @param cashDispenser   The cash dispenser.
     * @param depositSlot     The deposit slot.
     */
    public Deposit(int accountNumber, BankDatabase bankDatabase, Screen screen, Keypad keypad, CashDispenser cashDispenser, DepositSlot depositSlot) {
        super(accountNumber, bankDatabase, screen);
        this.keypad = keypad;
        this.cashDispenser = cashDispenser;
        this.depositSlot = depositSlot;
    }
    /**
     * Executes the deposit transaction.
     */
    @Override
    public void execute() {
        double amount = promptForDepositAmount();
        if (amount != 0) {
            getScreen().displayMessage("Please insert a deposit envelope containing ");
            getScreen().displayDollarAmount(amount);
            getScreen().displayMessageLine(".");
            boolean envelopeReceived = depositSlot.isEnvelopeReceived();
            if (envelopeReceived) {
                getScreen().displayMessageLine("Your envelope has been received.");
                getScreen().displayMessageLine("NOTE: The money just deposited will not be available until we verify the amount of any enclosed cash and your checks clear.");
                getBankDatabase().credit(getAccountNumber(), amount);
            } else {
                getScreen().displayMessageLine("You did not insert an envelope, so the ATM has canceled your transaction.");
            }
        } else {
            getScreen().displayMessageLine("Canceling transaction...");
        }
    }
    /**
     * Prompts the user to enter a deposit amount and returns the amount.
     *
     * @return The deposit amount entered by the user.
     */
    private double promptForDepositAmount() {
        getScreen().displayMessage("Please enter a deposit amount in CENTS (or 0 to cancel): ");
        int input = keypad.getInput();
        if (input == 0) {
            return 0;
        } else {
            return (double) input / 100;
        }
    }
}
