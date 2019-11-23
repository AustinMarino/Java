// Austin Marino
// Final Project
// Player Class

import java.util.Scanner;

public class Player
{
	private int playerBalance = 2000;
	private int wager;
	private int wagerConfirm;
	private int playerWager;
	private String playAgain;
	
	private Dice dice = new Dice();
	
	public Player()
	{
	}
	
	// access player total balance
	public int getBalance()
	{
		return playerBalance;
	}
	
	// takes input from user and assigns to wager
	public void wagerAmount()
	{
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.println("Player's Balance: $" + playerBalance);
			System.out.printf("What's your bet kid? (Wage $1-$%d): $", playerBalance);
			while (!input.hasNextInt())
			{
				System.out.println();
				System.out.printf("Quit trying to scam out! Put your money on the table or get out! (Wage 1-%d): ", playerBalance);
				input.next();
			}
			System.out.println();
			wager = input.nextInt();	
		}
		while (wager < 1 || wager > playerBalance);
	} // end wagerAmount
	
	// confirm and validate wager amount is identical
	public void wagerConfirm()
	{
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.printf("Confirm your wager of $" + wager + " by entering the same number: $");
			while (!input.hasNextInt())
			{
				System.out.println();
				System.out.printf("Stop trying to break my Game!\nConfirm your previous wage of $" + wager + " by entering the same amount: $" );
				input.next();
			}
			System.out.println();
			wagerConfirm = input.nextInt();	
		}
		while (wagerConfirm < 1 || wagerConfirm > playerBalance);
	} // end wagerConfirm
	
	// compares two numbers from user input
	public int validateWager()
	{
		if (wager == wagerConfirm)
		{
			System.out.printf("***Valid Wager***\nPlayer's bet is $" + wager);
			System.out.println();
			return 1;
		}
		System.out.printf("***Invalid Wager Match***\nNext time, your wager needs to be the same. First Wager: $" + wager + " Second Wager $" + wagerConfirm);
		System.out.println();
		return 0;		
	} // end validateWager 
	
	public void setPlayerWager()
	{
		playerWager = wager;
	} // end setPlayerWager

	public int getPlayerWager()
	{
		return playerWager;
	} // end getPlayerWager
	
	// accessor to dice class where the two die values are stored. Pulls values back
	public void rollDice()
	{
		dice.rollDice();
		dice.addFaceValues();
	}
	
	// if player wins, balance will be incrimented by wager amount
	public void increaseBalance()
	{
		playerBalance += playerWager;
	}
	
	// if player loses, balance will be de-incrimented by wager amount
	public void decreaseBalance()
	{
		playerBalance -= playerWager;
	}
	
	// checks if player has enough funds to wager
	public int checkPlayerBalance()
	{
		if (playerBalance <= 0)
		{
			System.out.println("***Invalid Funds***\nPlease visit the closest ATM to play again");
			System.out.printf("Player Balance: $" + playerBalance);
			return 1;
		}
		return 0;
	}
	
	// accessor for dice class to get face values
	public int getAddedFaceValues()
	{
		return dice.getAddedFaceValues();
	}
}