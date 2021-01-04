/*
 * Building up pieces of ATM class.
 * Represents the keypad of the ATM
 */

package com.aljebraschool.myatm;




import java.util.Scanner;	//program uses Scanner to get input from user


public class AtmKeypad {

private Scanner input;	//create object of class Scanner to read data from user

//no-argument constructor to initialize Scanner object
public AtmKeypad()
{
	input = new Scanner(System.in);
}//end no-argument keypad constructor


//return an integer value entered by the user
public int getInput()
{
	return input.nextInt();	//assuming user enters only integers
}//end method getInput
	
	
}//end class keypad
