
public class Account {

	public static int ID = 1000;
	public static double balance = 0;
	public static String holder = null;
	public static int numAccounts = 0;
	
	public Account(int ID, double balance, String holder){
		this.ID = ID;
		numAccounts++;
		
		boolean not = true;
		while(not){
			if(holder.length()>=5){
				this.holder = holder;
				not = false;
			}else{
				System.out.print("Error. Please enter a name with 5 "+
								"or more characters. "+holder.length());
				
				break;
			}
		}
		
		boolean tooBig = true;
		while(tooBig){
			if(balance<10000){
				this.balance = balance;
				tooBig = false;
			}else{
				System.out.print("Error. Please enter a balance "+
								"less than $10,000.");
				break;
			}
		}
	}
	
	public int getID(){
		return ID;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void deposit(double amount){
		boolean negative = true;
		while(negative){
			if(amount>=0){
				if(amount<10000){
					balance += amount;
					negative = false;
				}else{
					System.out.print("Error. Please enter a deposit "+
									"less than $10,000.");
					break;
				}
			}else{
				System.out.print("Error. Please enter a positive number.");
				break;
			}
		}
	}
	
	public void withdraw(double amount){
		boolean negative = true;
		while(negative){
			if(amount>=0){
				if(amount<=balance){
					balance -= amount;
					negative = false;
				}else{
					System.out.print("Error. You do not have enough money in "+
									"your account. \nPlease enter an amount "+
									"less than $"+balance);
					break;
				}
			}else{
				System.out.print("Error. Please enter a positive number.");
				break;
			}
		}
	}
	
	public String getHolder(){
		return holder;
	}
	
	public void displayInfo(){
		System.out.print("Account ID: "+ID+
						"/nAccount Holder: "+holder+
						"/nBalance: $"+balance);
	}
	
}
