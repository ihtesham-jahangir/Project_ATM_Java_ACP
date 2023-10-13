# ATM System User Manual

## Introduction

The ATM System is an advanced Java program that simulates the functionality of an Automated Teller Machine (ATM). It allows users to perform various banking transactions such as balance inquiry, withdrawal, and deposit. The system is designed to adhere to the principles of Polymorphism, Inheritance, Encapsulation, and Abstraction, and incorporates an intelligent online email notification system.

## Installation

To run the ATM System, you need to have Java Development Kit (JDK) installed on your machine. You can download the latest version of JDK from the official Oracle website: [https://www.oracle.com/java/technologies/javase-jdk11-downloads.html](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

Once you have installed JDK, you can proceed with the following steps:

1. Download the ATM System code files from the provided source.

2. Extract the downloaded files to a directory of your choice.

3. Open a command prompt or terminal and navigate to the directory where you extracted the files.

4. Compile the Java code files by running the following command:
   ```
   javac *.java
   ```

5. Once the compilation is successful, you can run the ATM System by executing the following command:
   ```
   java ATM
   ```

## Usage

Upon running the ATM System, you will be presented with a command line interface. Follow the on-screen instructions to interact with the system.

1. Enter your account number: Provide your account number using the numeric keypad.

2. Enter your PIN: Enter your PIN using the numeric keypad.

3. Main Menu: Once authenticated, you will be presented with the main menu options. Use the numeric keypad to select an option:

   - Option 1: View my balance
   - Option 2: Withdraw cash
   - Option 3: Deposit funds
   - Option 4: Exit

4. Balance Inquiry: If you choose option 1, the system will display your available balance and total balance.

5. Withdrawal: If you choose option 2, the system will prompt you to select a withdrawal amount from the provided menu. Enter the corresponding number and follow the instructions to complete the transaction. If the withdrawal is successful, the system will dispense the cash and send an email notification.

6. Deposit: If you choose option 3, the system will prompt you to enter a deposit amount in cents. Follow the instructions to complete the transaction. If the deposit is successful, the system will send an email notification.

7. Exit: If you choose option 4, the system will exit gracefully.

## Error Handling

The ATM System incorporates robust error handling to handle various scenarios:

- Invalid account number or PIN: If the provided account number or PIN is incorrect, the system will display an authentication failure message and prompt you to try again.

- Insufficient funds: If you attempt to withdraw more money than your available balance, the system will display an insufficient funds message.

- Insufficient cash in the ATM: If the ATM does not have enough cash to dispense the requested amount, the system will display an insufficient cash message.

- Canceling transaction: If you choose to cancel a transaction, the system will display a canceling transaction message and return to the main menu.

## Design Patterns

The ATM System incorporates design patterns to ensure scalability and code clarity:

- Factory Method: The `ATM` class acts as a factory for creating different types of transactions (`BalanceInquiry`, `Withdrawal`, `Deposit`). This allows for easy extensibility and flexibility in adding new transaction types.

- Template Method: The `Transaction` class defines a template method `execute()` that is overridden by each specific transaction class. This allows for consistent execution flow across different transaction types.

## Email Notification System

The ATM System integrates an intelligent online email notification system. The system sends email notifications during withdrawal processing or application access. The email notification functionality is implemented in the `EmailNotificationSystem` class.

## Conclusion

The ATM System provides a comprehensive and advanced Java program for simulating an ATM. It incorporates various features such as balance inquiry, withdrawal, deposit, error handling, design patterns, and an email notification system. By following the installation and usage instructions provided in this manual, you can effectively use the ATM System to perform banking transactions.