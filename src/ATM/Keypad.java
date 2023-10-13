package ATM;


import java.util.Scanner;
/**
 * The class representing the keypad.
 */
public class Keypad {
    private Scanner scanner;
    /**
     * Constructor for the Keypad class.
     */
    public Keypad() {
        scanner = new Scanner(System.in);
    }
    /**
     * Retrieves the user's input.
     *
     * @return The user's input.
     */
    public int getInput() {
        return scanner.nextInt();
    }
}
