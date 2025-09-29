package BankAccountSimulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Account class
class Account {
	private String accountHolder;
	private double balance;
	private List<String> transactions;

	public Account(String accountHolder, double initialBalance) {
		this.accountHolder = accountHolder;
		this.balance = initialBalance;
		this.transactions = new ArrayList<>();
		transactions.add("Account created with balance: " + initialBalance);
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			transactions.add("Deposited: " + amount + " | Balance: " + balance);
			System.out.println("Successfully deposited " + amount);
		} else {
			System.out.println("Deposit amount must be positive!");
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			transactions.add("Withdrew: " + amount + " | Balance: " + balance);
			System.out.println("Successfully withdrew " + amount);
		} else {
			System.out.println("Invalid withdrawal amount or insufficient funds!");
		}
	}

	public double getBalance() {
		return balance;
	}

	public void printTransactions() {
		System.out.println("\nTransaction History:");
		for (String t : transactions) {
			System.out.println(t);
		}
	}

}

public class BankAccountSimulations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter account holder name: ");
		String name = sc.nextLine();

		System.out.print("Enter initial balance: ");
		double initialBalance = sc.nextDouble();

		Account account = new Account(name, initialBalance);

		int choice;
		do {
			System.out.println("\n *** Bank Menu ***");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check Balance");
			System.out.println("4. Transaction History");
			System.out.println("5. Exit");
			System.out.print("Choose an option: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter deposit amount: ");
				double depositAmount = sc.nextDouble();
				account.deposit(depositAmount);
				break;
			case 2:
				System.out.print("Enter withdraw amount: ");
				double withdrawAmount = sc.nextDouble();
				account.withdraw(withdrawAmount);
				break;
			case 3:
				System.out.println("Current Balance: " + account.getBalance());
				break;
			case 4:
				account.printTransactions();
				break;
			case 5:
				System.out.println("Exiting... Thank you!");
				break;
			default:
				System.out.println("Invalid option! Try again.");
			}
		} while (choice != 5);

		sc.close();
	}

}
