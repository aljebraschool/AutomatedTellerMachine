/*
 * MyBankDatabase.java
 *Represents the bank account information database
 */
package com.aljebraschool.myatm;





public class MyDatabase {

public MyAccount[] myAccounts;		//array to store accounts 
	
	//no-argument BankDatabase constructor to store account objects
	public MyDatabase()
	{
		myAccounts = new MyAccount[5];		//just two accounts for demonstration
		myAccounts[0] = new MyAccount(30527849, 1992, 1000.0, 12000);
		myAccounts[1] = new MyAccount(94872503, 2117, 1200.0, 5100.0);
		myAccounts[2] = new MyAccount(14237983, 5559, 3500.0, 2500.0);
		myAccounts[3] = new MyAccount(11225437, 2115, 8200.0, 9500.0);
		myAccounts[4] = new MyAccount(98764924, 2020, 2970.0, 5000.0);
		
	}//end no-argument BankDatabase constructor
	
	
	//retrieve account objects stored in the account array for a particular account number 
	private MyAccount getMyAccount (int accountNumber)
	{
		//loop through myAccount array to get the particular account in question
		for(MyAccount currentAccount: myAccounts)
		{
			//return current account if compatible
			if(currentAccount.getMyAccountNumber() == accountNumber)
				return currentAccount;
		}//end for
		return null; 	//if no matching account was found, return null
		
	}//end method getMyAccount
	
	
	//check whether the account and PIN numbers entered by the user match with the stored ones in the database
	public boolean authenticateUser (int userAccNum, int userPin)
	
	{
		//try to verify user's account number
		MyAccount userAccNumber = getMyAccount(userAccNum);
		
		//if account is found then validate the pin and return result
		if(userAccNumber != null)
			return userAccNumber.comparePIN(userPin);
		else
			return false; 	 //account number not found so return false
		
	}//end method authenticateUser
	
	
	//return the total available balance account information
	public double getTotalBalance (int myAccNum)
	{
		return getMyAccount(myAccNum).getTotalBalance();
	}//end method getTotalBalance
	
	//return the real  available balance account information
	public double getRealBalance(int myAccNum)
	{
		return getMyAccount (myAccNum).getRealBalance();
	}//end method getRealBalance
	
	
	//add money to my totalBalance
	public void saveMoney(int myAccNum, double amount)
	{
		getMyAccount(myAccNum).save(amount);
		
	}//end method saveMoney
	
	
	public void withdrawMoney(int myAccNum, double amount)
	{
		getMyAccount(myAccNum).withdraw(amount);
	}//end method withdrawMoney
	
	
	
}//end class MyDatabase
