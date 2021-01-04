/*
 * MyTransaction.java
 *Abstract superclass Transaction represents an ATM transaction
 */
package com.aljebraschool.myatm;



public abstract class MyTransaction {

	private int accNumber;	//indicates account number
	private AtmScreen myScreen;	// to acess the screen
	private MyDatabase myDatabase;	//bank database
	
	
	//Transaction construction invoked by subclasses using super()
	public MyTransaction (int userAcc, AtmScreen atmScreen, MyDatabase atmDatabase)
	{
		accNumber = userAcc;
		myScreen = atmScreen;
		myDatabase = atmDatabase;
	}//end MyTransaction constructor
	
	//return account number
	public int getMyAccNumber()
	{
		return accNumber;
	}//end method getMyAccNumber
	
	//return reference to screen
	public AtmScreen getScreen()
	{
		return myScreen;
	}//end method getScreen
	
	
	//return reference to bank database
	public MyDatabase getMyDatabase()
	{
		return myDatabase;
	}//end method getMyDatabase
	
	
	//perform the transaction (overridden by each subclass)
	abstract public void implement();	
	
	
}//end class MyTransaction
