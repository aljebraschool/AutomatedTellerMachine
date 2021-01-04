
//MyATM.java
//Represents an automated teller machine
package com.aljebraschool.myatm;





public class MyAtm {

	private boolean myAuthentication;	//check whether exit
	private int myAccountNumber;		//user account number
	private AtmScreen screen;				//myAtm's screen
	private AtmKeypad keypad;				//myAtm's keypad
	private AtmCashDispenser cashDispenser;				//myAtm's cashDispenser
	private AtmDepositSlot	depositSlot;			//myAtm's deposit slot
	private MyDatabase	bankDatabase;			//my account information database
	
	//using constants to represent main menu options
	private static final int BAl_INQ = 1;	// option for balance inquiry
	private static final int WITHDRAL = 2;	// option for balance withdrawal
	private static final int SAVE = 3;		// option for balance deposit
	private static final int CLOSE = 4;		// option for balance exit
	
	
	//no-argument constructor to initialize class field
	
	public MyAtm()
	{
		myAuthentication = false;	//user is not known initially
		myAccountNumber = 0;		// no account number current added
		screen = new AtmScreen();	// creation of screen object
		keypad = new AtmKeypad();	//creation of keypad object
		cashDispenser = new AtmCashDispenser(); //creation of  cashDispenser object
		depositSlot = new AtmDepositSlot();		//creation of  depositSlot object
		bankDatabase = new MyDatabase();	//creation of  bankDatabase object
		
		
	}//end no-argument constructor
	
	//method to start the ATM
	public void run()
	{
		//method to welcome the user, checks its user identity and perform transaction
		
		while(true)
		{
			//continuously loop if user is not yet authenticated
			while(!myAuthentication)
			{
				screen.displayMessageLine("\nWelcome!!!");
				userAuthentication(); //call userAuthenticate  method to authenticate user
				
			}//end while
			
			doTransactions();	//after authentication then implement transactions
			myAuthentication = false;	//reset before next transaction
			myAccountNumber = 0;		//reset before next transaction
			screen.displayMessageLine("\n Thank You! Goodbye! ");
			
			//loop continuation condition 'true' is not modified in the body of the loop this creates an infinite loop
			
			
		}//end method while
		
}// end method run
	

	//implement method to compare user info with database
	private void userAuthentication()
	{
		screen.displayMessage ("\nPlease input your account number: ");	//request for account number
		int accountNumber = keypad.getInput(); 	//read account from keypad
		screen.displayMessage ("\nPlease enter PIN: "); //request for PIN
		int pin = keypad.getInput();	//read pin from keypad
		
		//send user input to database via its method then store the boolean value in myAuthentication variable
		myAuthentication = bankDatabase.authenticateUser(accountNumber, pin );	//compare the accountNumber and pin with those in the database
		
		//check if authentication is successful
		if(myAuthentication)
		{
			myAccountNumber = accountNumber;	//store current account number in the field myAccountNumber
			
		}//end if
		
		else
			screen.displayMessageLine("Invalid account number or PIN. Please try again!");
	}//end method userAuthentication
	
	
	//execute transaction based on user's choice
	private void doTransactions()
	{
		//store local variable being processed
		MyTransaction currentTransaction = null;
		
		boolean userClosed = false;		 //user has not chosen to close session
		
		//loop while user has not chosen exit option
		while(!userClosed)
		{
			//show main menu and selection
			int menuSelection = displayMenuOption();	//calls method to display main menu options
			
			//choose how to process based on user's choice
			switch(menuSelection)
			{
				//user chooses to perform any of these transactions
			case BAl_INQ:			//if user selects option 1
			case WITHDRAL:			//if user selects option 2
			case SAVE:				//if user selects option 3
			
				//initialize the chosen option as new object of MyTransaction
				currentTransaction = executeTransaction(menuSelection);
				
				currentTransaction.implement();		//implement transaction
				break;
				
			case CLOSE:		//if user made the choice to close session
				screen.displayMessageLine("\nShuttin down...");
				userClosed = true;		//end the ATM session
				break;
				
				default:		//none of the selections were made
					screen.displayMessageLine("\nInvalid selection. Please try again!");
					break;
				}//end switch
			
			
		}//end while
		
}//end method doTransaction


	//method to display and read option selected in the main menu
	private int displayMenuOption()
	{
		
		screen.displayMessageLine("\nMain menu:");
		screen.displayMessageLine("1 - View Account Balance");
		screen.displayMessageLine("2 - Withdraw Money");
		screen.displayMessageLine("3 - Save Money");
		screen.displayMessageLine("4 - Quit\n");
		screen.displayMessageLine("Choose an Option:");
		return keypad.getInput();		//return my choice 
		
		
	}//end method displayMenuOption
	
	//return object of specified Transaction subclass
	private MyTransaction executeTransaction (int option)
	{
		MyTransaction first = null;		//temporary Transaction variable
		
		//determine what type of MyTransaction to create
		switch(option)
		{
		case BAl_INQ:		//create new balanceInquiry transaction
			first = new MyBalInquiry(myAccountNumber, screen, bankDatabase ); //stores the object of class MyBalInquiry in variable first
			break;
		case WITHDRAL:	//create new withdrawal transaction
			first = new MyWithdrawal(myAccountNumber,screen, bankDatabase,keypad, cashDispenser );	//stores the object of class MyWithdrawal in variable first
			break;
		case SAVE:		//create new deposit transaction
			first = new MyDeposit (myAccountNumber, screen, bankDatabase,keypad,depositSlot);		//stores the object of class MyDeposit in variable first
			break;
			
		}//end switch
		
		return first;		//return the newly created object
		
	}//end method executeTransaction
	
	
	
}//end class MyAtm
