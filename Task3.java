package codesoft;

import java.util.Scanner;

class Account {
	private double balance;

	public Account(double initialBalance) {
		this.balance = initialBalance;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public boolean withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
			return true;
		} else {
			return false;
		}
	}
}

public class Task3 {
	private Account account;

	public Task3(Account account) {
		this.account = account;
	}

	public void displayMenu() {

		System.out.println("\n1.Deposit\n2.Withdraw\n3.Check balance\n4.Exit");

	}

	public void withdraw(double amount) {
		boolean success = account.withdraw(amount);
		if (success) {
			System.out.println("Withdraw successful.Remaining balance:" + account.getBalance());

		} else {
			System.out.println("Insufficient balance");
		}
	}

	public void deposit(double amount) {
		account.deposit(amount);
		System.out.println("Deposit successfully. New Balance=" + account.getBalance());
	}

	public void checkBalance() {
		System.out.println("Current Balance=" + account.getBalance());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account ac = new Account(1000);
		Task3 t = new Task3(ac);
		System.out.println("****Welcome User****");
		while (true) {
			t.displayMenu();
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {

				System.out.println("Enter amount to deposit");
				double amount = sc.nextDouble();

				t.deposit(amount);

				break;
			}
			case 2: {

				System.out.println("Enter amount to withdraw");
				double amount = sc.nextDouble();

				t.withdraw(amount);

				break;
			}
			case 3: {

				t.checkBalance();

				break;
			}
			case 4:
			{
				System.exit(0);
				break;
			}

			default: {
				System.out.println("wrong choice");
			}
			}
		}
	}
}