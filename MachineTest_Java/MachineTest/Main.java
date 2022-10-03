package MachineTest;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Customer> detail = new ArrayList<>();

		int choice;
		do {
			// Greetings
			System.out.println("********WELCOME********");
			// Main Menu
			System.out.println("-------Select the choices-------");
			System.out.println("1.Add new customer");
			System.out.println("2.Update customer details");
			System.out.println("3.Delete a customer");
			System.out.println("4.Deposit money into customer account");
			System.out.println("5.Withdraw money from customer account");
			System.out.println("6.Check Balance");
			System.out.println("7.List of all customer in the bank");
			System.out.println("8.Customer details of a specific customer");
			System.out.println("9.Transfer money");
			System.out.println("10.Exit");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				Customer newcustomer = new Customer();
				detail.add(newcustomer);
				break;
			case 2:
				System.out.println("Enter your account no:");
				long account = scanner.nextLong();
				for (Customer e : detail) {
					if (account == e.AccountNo) {
						e.setEmailId();
						e.setMobileNo();
					}
				}
				break;

			case 3:
				System.out.println("Enter account no for deletion:");
				account = scanner.nextLong();
				for (Customer e : detail) {
					if (account == e.AccountNo) {
						detail.remove(e);
						break;
					}
				}
				System.out.println("Account no " + account + " is deleted from record.");
				break;
			case 4:
				System.out.println("Enter your account no:");
				account = scanner.nextInt();
				for (Customer e : detail) {
					if (account == e.AccountNo) {
						e.deposit();
						break;
					}
				}
				break;
			case 5:
				System.out.println("Enter your account no:");
				account = scanner.nextInt();
				System.out.println("Enter the amount to withdraw:");
				float withdrawAmount = scanner.nextFloat();
				if (withdrawAmount > 50000)
					System.out.println("Enter PAN number:");
				String panNo = scanner.next();
				for (Customer e : detail) {
					if (account == e.AccountNo) {
						if (withdrawAmount > e.balance - 1000) {
							System.out.println("Insufficient Fund");
						} else {
							e.balance -= withdrawAmount;
							break;
						}
					}
				}
				break;
			case 6:
				System.out.println("Enter your account no:");
				account = scanner.nextLong();
				boolean value = false;
				for (Customer e : detail) {
					if (account == e.AccountNo) {
						value = true;
						System.out.println("Your account Balance:" + e.balance);
						break;
					}
				}
				if (!value)
					System.out.println("Your Account is not available.");
				break;

			case 7:
				System.out.println(detail);
				break;
			case 8:
				System.out.println("Enter your account no:");
				account = scanner.nextLong();
				boolean val = false;
				for (Customer e : detail) {
					if (account == e.AccountNo) {
						val = true;
						System.out.println(e);
						break;
					}
				}
				if (!val)
					System.out.println("Account number not found.");
				break;
			case 9:
				System.out.println("Enter your account no:");
				account = scanner.nextLong();
				System.out.println("Enter the amount to transfer:");
				float transferAmount = scanner.nextFloat();
				for (Customer e : detail) {
					if (account == e.AccountNo) {
						float amo = e.balance - 1000;
						if (amo >= transferAmount) {
							e.balance -= transferAmount;
							System.out.println("Transferred Amount successfully.");
						} else {
							System.out.println("Fund cannot be transfer.");
						}
					}
				}
				break;
			case 10:
				System.out.println("Thanks!!  Visit Again ");
				System.exit(0);
			default:
				System.out.println("Enter the valid input.");
			}
		} while (true);
	}
}
