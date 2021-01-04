/*
 *MyBalanceInquiry.java
 *Represents a balance inquiry ATM transaction
 */
package com.aljebraschool.myatm;



public class MyBalInquiry extends MyTransaction{

	//constructor
	public MyBalInquiry (int userAcc, AtmScreen atmScreen, MyDatabase atmDatabase )
	{
		super(userAcc, atmScreen, atmDatabase);
	}//end MyBalInquiry constructor
	
	
	//perform the transaction
	@Override
	public void implement()
	{
		//get reference to bank database and screen to store them in variables
		MyDatabase atmDatabase = getMyDatabase();
		AtmScreen atmScreen = getScreen();
		
		//get the available balance for the account involved
		double availableBal = atmDatabase.getTotalBalance(getMyAccNumber());
		
		//get the total balance for the account involved
		double totalBal = atmDatabase.getRealBalance(getMyAccNumber());
		
		
		//display the balance information on the screen
		 atmScreen.displayMessageLine("\nBalance Information: ");
	     atmScreen.displayMessage(" - Available balance: ");
	     atmScreen.displayDollarAmount(availableBal);
	     atmScreen.displayMessage("\n - Total balance:   ");
	     atmScreen.displayDollarAmount(totalBal);
	     atmScreen.displayMessageLine("");
		
	}//end method execute 
	
	
	
}//end class MyBalInquiry
