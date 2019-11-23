// Austin Marino
// Final Project
// Crowd chatter class

import java.security.SecureRandom;

public class Crowd
{
	// game win message
	private final String MESSAGE1 = "You're killin' it!"; 
	private final String MESSAGE2 = "Wow, Luck or Skill?"; 
	private final String MESSAGE3 = "Nice Roll!"; 
	// game lost message
	private final String MESSAGE4 = "Ouch, That hurt..."; 
	private final String MESSAGE5 = "How much did you just lose?!"; 
	private final String MESSAGE6 = "Please pass the dice!"; 
	// game continue message
	private final String MESSAGE7 = "Don't crap out kid!"; 
	private final String MESSAGE8 = "You have a lot on the line, don't choke!"; 
	private final String MESSAGE9 = "Keep the number's comin'!";
	
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	public Crowd()
	{
	} 
	
	// random winning message
	public void displayWinningMessage()
	{
		int chatterMessage = 1 + randomNumbers.nextInt(4);
		if (chatterMessage == 1)
		{
			System.out.println(MESSAGE1);
		}
		else if (chatterMessage == 2)
		{
			System.out.println(MESSAGE2);
		}
		else if (chatterMessage == 3)
		{
			System.out.println(MESSAGE3);
		}
	}// end displayWinningMessage
	
	// random losing message
	public void displayLosingMessage()
	{
		int chatterMessage = 1 + randomNumbers.nextInt(3);
		if (chatterMessage == 1)
		{
			System.out.println(MESSAGE4);
		}
		else if (chatterMessage == 2)
		{
			System.out.println(MESSAGE5);
		}
		else
		{
			System.out.println(MESSAGE6);
		}
	}// end displayLosingMessage
	
	// random continue message
	public void displayContinueMessage()
	{
		int chatterMessage = 1 + randomNumbers.nextInt(3);
		if (chatterMessage == 1)
		{
			System.out.println(MESSAGE7);
		}
		else if (chatterMessage == 2)
		{
			System.out.println(MESSAGE8);
		}
		else
		{
			System.out.println(MESSAGE9);
		}
	} // end displayContinueMessage
}//class ends