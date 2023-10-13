package ATM;

/**
 * The class representing the screen.
 */
public class Screen {
    /**
     * Displays a message on the screen.
     *
     * @param message The message to display.
     */
    public void displayMessage(String message) {
        System.out.print(message);
    }
    /**
     * Displays a message on the screen followed by a new line.
     *
     * @param message The message to display.
     */
    public void displayMessageLine(String message) {
        System.out.println(message);
    }
    /**
     * Displays a dollar amount on the screen.
     *
     * @param amount The dollar amount to display.
     */
    public void displayDollarAmount(double amount) {
        System.out.printf("$%,.2f", amount);
    }
}
