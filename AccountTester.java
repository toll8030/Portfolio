import java.util.Scanner;
import java.util.Random;

public class AccountTester {
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		boolean again = true;
		Random gen = new Random();
		int i = 1000+Account.numAccounts;
		Account a1 = null;
		
		do{
			System.out.println("\n***Menu***");
			System.out.println("(A) Set up Account");
			System.out.println("(I) View Account ID");
			System.out.println("(B) View Account Balance");
			System.out.println("(D) Deposit");
			System.out.println("(W) Withdraw");
			System.out.println("(H) View Account Holder");
			System.out.println("(N) Display All Account Info");
			System.out.println("(Q) Quit");
			System.out.println("********");
			System.out.print("What would you like to do?: ");
			String response = kb.next();
			switch(response.toUpperCase()){
			case "A": String fix = kb.nextLine(); System.out.println("Enter the Account Holder: "); String holder = kb.nextLine(); 
				System.out.println("Enter the Account Balance: "); double balance = kb.nextDouble();
				a1 = new Account(i, balance, holder); break;
			case "I": System.out.println("The account ID is: "+a1.getID()); break;
			case "B": System.out.println("The account balance is: $"+a1.getBalance()); break;
			case "D": System.out.println("Enter the amount you want to deposit: "); 
				double deposit = kb.nextDouble(); a1.deposit(deposit); break;
			case "W": System.out.println("Enter the amount you want to withdraw: "); 
				double withdraw = kb.nextDouble(); a1.withdraw(withdraw); break;
			case "H": System.out.println("The account holder is: "+a1.getHolder()); break;
			case "N": System.out.println("The account ID is: "+a1.getID()); 
				System.out.println("The account holder is: "+a1.getHolder()); 
				System.out.println("The account balance is: "+a1.getBalance()); break;
			case "Q": System.out.println("Thank you for banking with us!"); again = false; break;			
			default: System.out.println("");
			}	
		}while(again);
	}
}
