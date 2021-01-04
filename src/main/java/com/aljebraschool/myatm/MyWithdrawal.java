/*
 * MyWithdrawal.java
 *Represents the withdrawal ATM transaction
 */
package com.aljebraschool.myatm;




public class MyWithdrawal extends MyTransaction{
	
	private int myAmount;		//amount to withdraw
	
	//reference to associated objects
	private AtmKeypad keypad;		//reference to keypad
	private AtmCashDispenser cashDispenser; //reference to cashDispenser
	
	//constant corresponding to menu option to cancel
	private final static int EXIT = 6;
	
	
	//withdrawal constructor
	public MyWithdrawal (int userAcc, AtmScreen atmScreen, MyDatabase 
			atmDatabase, AtmKeypad atmKeypad, AtmCashDispenser atmCashDispenser)
	{
		//initialize superclass variables
		super(userAcc, atmScreen, atmDatabase);
		
		//initialize reference to keypad and cash dispenser
		keypad = atmKeypad;
		cashDispenser = atmCashDispenser;
		
	}//end withdrawal constructor
	
	
	//perform transaction
	@Override
	public void implement()
	{
		boolean cashDispensed = false;	//cash not dispensed yet
		double totalBalance;			//amount available for Withdrawal
		
		//get reference to bank database and screen
		MyDatabase bankDatabase = getMyDatabase();
		AtmScreen screen = getScreen();
		
		//loop until cash is dispensed or the user cancels
		do
		{
			
			//obtain a chosen withdrawal amount from the user
			myAmount = displayAmountMenu();
			
			//check whether user chose a withdrawal amount or canceled
			if(myAmount != EXIT)
			{
				
				//get available balance of account involved
				totalBalance = bankDatabase.getTotalBalance(getMyAccNumber());
				
				//check whether the user has enough money in the account 
				if(myAmount <= totalBalance)
				{
					//check whether the cash dispenser has enough money
					 if(cashDispenser.isEnoughCashAvailable(myAmount)) 
					 {
						 //update the account involved to reflect the Withdrawal
						 bankDatabase.withdrawMoney(getMyAccNumber(), myAmount);
						 cashDispenser.dispenseCash(myAmount);	//dispense cash
						 cashDispensed = true;		//cash was dispensed
						 
						 //instruct user to take cash
						 screen.displayMessageLine("\nCash dispensed " + " please take your cash.");
						 
						 
						 
						 
					 }//end if
					 
					 else
						 //cash dispenser does not have enough of cash to dispense
						 screen.displayMessageLine("\nInsufficient cash available in the ATM. " + "\n\nKindly chose a smaller amount!");;
					
				}//end if
				else		//not enough money available in user's account 
					screen.displayMessageLine("\nInsufficient money in your account." + "\n\nKindly chose a smaller amount!");
				
			}
			
		}while(!cashDispensed);
		
	}//end method implement
	
	
	//display a menu of withdrawal amounts and the option to cancel;
	//return the chosen amount or 0 if the user chooses to cancel
	private int displayAmountMenu()
	{
		int userOption = 0;		//local variable to store return value of the user
		
		AtmScreen screen = getScreen();		//get screen reference
		
		//array of amounts to correspond to menu numbers
		int[] amounts = {0, 20, 40,60,100,200};
		
		//loop while no valid choices has been made
		while(userOption == 0)
		{
			//display the withdrawal menu
			 screen.displayMessageLine("\nWithdrawal Menu:");
		        screen.displayMessageLine("1  - $200");
		        screen.displayMessageLine("2  - $400");
		         screen.displayMessageLine("3  - $600");
		        screen.displayMessageLine("4  - $1100");
		        screen.displayMessageLine("5  - $1200");
		        screen.displayMessageLine("6  - Cancel transaction");
		         screen.displayMessageLine("\nChoose a withdrawal amount: ");
		         
		         int option = keypad.getInput();		//get user input through keypad
		         
		         //determine how to proceed based on the input value
		         switch(option)
		         {
		         case 1: //if the user chose a withdrawal amount
	             case 2: //(i.e., option 1,2,3,4, or 5), return the 
	             case 3: //corresponding amount from amounts array
	             case 4:
	             case 5:
	            	 userOption = amounts[option];		//save user's choice
	            	 break;
	             case EXIT:			//user chose to cancel
	            	 userOption = EXIT;		//save user's choice
	            	 break;
	            	 
	            	 default: 	//the user did not enter a value from 1- 6
	            		 screen.displayMessageLine("\nInvalid selection. Please try again!");
	            	 
		         	
		         }//end switch
			
		}//end while
		
		return userOption;
		
		
		
		
	}//end method displayAmountMenu
	

}//end class Mywithdrawal

