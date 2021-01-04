/*
 *  Building up pieces of ATM class.
 * Represents a bank Account 
 */
package com.aljebraschool.myatm;





public class MyAccount {

	private int myAccountNumber;	//account number
	private int myPin;				//my pin associated with this account number
	private double totalBalance;	//Balance that can be dispensed
	private double realBalance;		//Balance available + unconfirmed deposit
	
	//MyAccount constructor to initialize attributes
	public MyAccount (int myAccNum, int myPinNum, double myTotalBal, double myRealBal)
	{
		myAccountNumber = myAccNum;	
		myPin = myPinNum;
		totalBalance = myTotalBal;
		realBalance = myRealBal;
		
	}//end MyAccount constructor
	
	
	//check whether by comparing the PIN entered by the user with the available pin of the account
	public boolean comparePIN (int userPIN)
	{
		if(userPIN == myPin)
			return true;
		else
			return false;
	}//end method comparePIN
	
	//return totalBalance
	public double getTotalBalance()
	{
		return totalBalance;
		
	}//end getTotalBalance
	
	//return the real balance
	public double getRealBalance()
	{
		return realBalance;
	}//end method getRealBalance
	
	
	//credit method to add money to real balance
	public void save(double amount)
	{
		realBalance += amount;
	}//end method save
	
	
	//debit method to remove money from your account
	public void withdraw(double amount)
	
	{
		totalBalance -= amount;		//subtract the withdrawn amount 
		realBalance -= amount;		//subtract the withdrawn amount 
		
	}
	
	
	//method to return account number to its clients method for comparison of different account numbers
	public int getMyAccountNumber()
	{
		return myAccountNumber;
	}//end method getMyAccountNumber
	
	
}//end class MyAccount
