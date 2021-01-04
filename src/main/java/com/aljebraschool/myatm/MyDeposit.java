/*MyDeposit.java
 * represents a deposit transaction
 * 
*/
package com.aljebraschool.myatm;




public class MyDeposit extends MyTransaction{

	private double myAmount;		//amount to deposit
	private AtmKeypad keypad;		//reference to keypad
	private AtmDepositSlot depositSlot;	//reference to deposit slot
	private final static int EXIT = 0;	//constant for cancel option
	
	//deposit constructor
	public MyDeposit (int userAcc, AtmScreen atmScreen, MyDatabase atmDatabase, AtmKeypad atmKeypad, AtmDepositSlot atmDepositSlot )
	{
		
		//initialize superclass variables
		super(userAcc, atmScreen, atmDatabase);
		
	//initialize reference to keypad and deposit slot
		keypad = atmKeypad;
		depositSlot = atmDepositSlot;
	}//end MyDeposit constructor
	
	
	//perform transaction
	@Override
	public void implement()
	{
		MyDatabase atmDatabase = getMyDatabase();	//get reference
		AtmScreen atmScreen = getScreen();			//get reference
		
		myAmount = requestForDepositAmount();	//get deposit amount from user
		
		//check whether user entered a deposit amount or canceled
		
		if(myAmount != EXIT)
		{
			//request deposit envelop containing specified amount
			atmScreen.displayMessage("\nPlease insert a deposit envelop containing ");
			atmScreen.displayDollarAmount(myAmount);
			atmScreen.displayMessageLine(" ");
			
			//receive deposit envelop
			boolean receivedEnvelop = depositSlot.isEnvelopInserted();
			
			//check whether deposit envelop was received
			if(receivedEnvelop)
			{
				atmScreen.displayMessageLine("\nYour envelope has been " + " received. \nNOTE: The money just deposited will not " + 
	                    "be available until we verify the amount of any" + "enclosed cash and your checks clear. ");
				
				//credit account to reflect the deposit
				atmDatabase.saveMoney(getMyAccNumber(), myAmount);
				
			}//end if
			else		//deposit envelope not received
			{
				atmScreen.displayMessageLine("\nYou did not insert an" + "envelope, so the ATM has canceled your transaction.");
			
				
				
			}//end else
		}//end if
		
		else		//user canceled instead of entering amount
		{
			atmScreen.displayMessageLine("\nCanceling transaction...");
		}//end else
	}//end method implement
	
	
	//prompt user to enter a deposit amount in cents
	private double requestForDepositAmount()
	{
		AtmScreen screen = getScreen();		//get screnn reference
		
		//display the prompt
		screen.displayMessage("\nPlease enter a deposit amount in " + "CENTS (or 0 to cancel): ");
		int input = keypad.getInput();		//receive input of deposit amount
		
		
		//check whether the user canceled or entered a valid amount
		if(input == EXIT )
			return EXIT;
		else
		{
			return (double) input /100;	//return dollar amount
			
		}//end else
		
	}//end method requestForDepositAmount
	
	
}//end class Deposit
