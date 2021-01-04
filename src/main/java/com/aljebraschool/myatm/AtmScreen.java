/*
 *Screen.java
 *Represents the screen of the ATM
 */
package com.aljebraschool.myatm;




public class AtmScreen {

	//shows a message while keeping cursor on the same line
	public void displayMessage (String message)
	{
		System.out.print(message);
		
	}//end method displayMessage
	
	
	//shows a message while taking the cursor to the next line
	public void displayMessageLine(String message)
	{
		System.out.println(message);
		
	}//end method displayMessageLine
	
	
	//displays a dollar amount 
	public void displayDollarAmount (double amount)
	{
		System.out.printf("$%, .2f ", amount);
		
	}//end method displayDollarAmount
	
	
}//end class Screen

