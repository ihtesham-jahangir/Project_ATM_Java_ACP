package ATM;


/**
 * The main class representing the ATM system.
 */
public class ATM {
    private BankDatabase bankDatabase;
    private CashDispenser cashDispenser;
    private Keypad keypad;
    private Screen screen;
    /**
     * Constructor for the ATM class.
     */
    public ATM() {
        bankDatabase = new BankDatabase();
        cashDispenser = new CashDispenser();
        keypad = new Keypad();
        screen = new Screen();
    }
    /**
     * Starts the ATM system.
     */
    public void start() {
        while (true) {
            screen.displayMessageLine("Welcome to the ATM!");
            screen.displayMessageLine("Please enter your account number:");
            int accountNumber = keypad.getInput();
            screen.displayMessageLine("Please enter your PIN:");
            int pin = keypad.getInput();
            if (bankDatabase.authenticateUser(accountNumber, pin)) {
                performTransactions(accountNumber);
            } else {
                screen.displayMessageLine("Authentication failed. Please try again.");
            }
        }
    }
    /**
     * Performs transactions for the authenticated user.
     *
     * @param accountNumber The account number of the authenticated user.
     */
    private void performTransactions(int accountNumber) {
        Transaction currentTransaction = null;
        boolean userExited = false;
        while (!userExited) {
            int mainMenuSelection = displayMainMenu();
            switch (mainMenuSelection) {
                case 1:
                    currentTransaction = new BalanceInquiry(accountNumber, bankDatabase, screen);
                    currentTransaction.execute();
                    break;
                case 2:
                    currentTransaction = new Withdrawal(accountNumber, bankDatabase, screen, keypad, cashDispenser);
                    currentTransaction.execute();
                    break;
                case 3:
                    currentTransaction = new Deposit(accountNumber, bankDatabase, screen, keypad, cashDispenser, new DepositSlot());
                    currentTransaction.execute();
                    break;
                case 4:
                    userExited = true;
                    screen.displayMessageLine("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    screen.displayMessageLine("Invalid selection. Please try again.");
                    break;
            }
        }
    }
    /**
     * Displays the main menu and returns the user's selection.
     *
     * @return The user's selection.
     */
    private int displayMainMenu() {
        screen.displayMessageLine("Main Menu:");
        screen.displayMessageLine("1 - View my balance");
        screen.displayMessageLine("2 - Withdraw cash");
        screen.displayMessageLine("3 - Deposit funds");
        screen.displayMessageLine("4 - Exit");
        screen.displayMessage("Enter a choice: ");
        return keypad.getInput();
    }
    /**
     * The entry point of the ATM system.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
