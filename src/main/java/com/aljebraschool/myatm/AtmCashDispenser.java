/*
 *  Building up pieces of ATM class.
 * Represents the CashDispenser of the ATM
 */
package com.aljebraschool.myatm;



public class AtmCashDispenser {

	// the default initial number of bills in the cash dispenser
	private final static int COUNT = 500;	//initial numbers of $20 bills in the dispenser
	private int billNumber;		//number of bills remaining at any time
	
	//no-argument CashDispenser constructor set billNumber to default numbers of bills
	public AtmCashDispenser()
	{
		billNumber = COUNT;		//set billNumber attribute to defaul count 
		
	}//end CashDispenser constructor
	
	
	//try dispensing specified amount of cash
	public void dispenseCash (int amount)
	{
		int billsNeeded = amount / 20; 	//number of $20 bills needed for the transaction
		billNumber -= billsNeeded;		//update the number of bills
		
		
	}//end method dispenseCash
	
	
	//confirm if cash dispenser can dispense desired amount
	public boolean isEnoughCashAvailable (int amount)
	{
		int billsNeeded = amount/20;	//number of $20 bills needed for the transaction
		
		if(billNumber >= billsNeeded)
			return true;	//enough bills available
		
		else
			return false;		//not enough bills available
		
	}//end class AtmCashDispenser
	
	
	
	
}
