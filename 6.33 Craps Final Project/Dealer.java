// Austin Marino
// Final Project
// Dealer Class/ Game Driver

import java.util.Scanner;

public class Dealer
{
	private static int addedFaceValues;
	private static String playAgain;
	private static int playerBalance;
	private static int playerWager;
	private static int bankBalance;
	private static String statusOfGame;
	
	private static Bank bank = new Bank();
	private static Crowd crowd = new Crowd();
	private static Player player = new Player();
	private static Craps craps = new Craps();
	
	public Dealer()
	{
	}
	
	public static void main(String[] args)
	{
		String play = "Y";
		String quit = "N";
		playTable();

		while (getPlayAgain() == play)
		{
			startGame();

			setBankBalance();
			setPlayerBalance();

			do
			{
				player.wagerAmount(); 
				player.wagerConfirm(); 
			}
			while (player.validateWager() != 1);
			player.setPlayerWager(); 
			setPlayerWager();
			
			player.rollDice();
			setAddedFaceValues();
			passAddedFaceValues();
			craps.firstRoll();
			if (craps.displayStatus() == "WON")
			{
				setGameStatus();
				getGameStatus();
				crowd.displayWinningMessage();
				bank.decreaseBankBalance(playerWager);
				player.increaseBalance();
				setBankBalance();
				setPlayerBalance();
			}
			else if (craps.displayStatus() == "LOST")
			{
				setGameStatus();
				getGameStatus();
				crowd.displayLosingMessage();
				bank.increaseBankBalance(playerWager);
				player.decreaseBalance();
				setBankBalance();
				setPlayerBalance();
				
				if (player.checkPlayerBalance() == 1)
				{
					System.out.println();
					getBankBalance();
					System.exit(0);
				}
			}
			if (craps.displayStatus() == "CONTINUE")
			{
				setGameStatus();
			}
			while (craps.displayStatus() == "CONTINUE")
			{
				getGameStatus();
				crowd.displayContinueMessage();
					
				player.rollDice();
				setAddedFaceValues();
				passAddedFaceValues();
				craps.nextRoll();
				setGameStatus();
					
				if (craps.displayStatus() == "WON")
				{
					setGameStatus();
					getGameStatus();
					crowd.displayWinningMessage();
					bank.decreaseBankBalance(playerWager);
					player.increaseBalance();
					setBankBalance();
					setPlayerBalance();
				}
				else if (craps.displayStatus() == "LOST")
				{
					setGameStatus();
					getGameStatus();
					crowd.displayLosingMessage();
					bank.increaseBankBalance(playerWager);
					player.decreaseBalance();
					setBankBalance();
					setPlayerBalance();
					if (player.checkPlayerBalance() == 1)
					{
						System.out.println();
						getBankBalance();
						System.exit(0);
					}
				}
			}
			System.out.println();
			getBankBalance();
			getPlayerBalance();
			

			System.out.println();
			continuePlaying();

			if (getPlayAgain() == "N")
			{
				playAgain = "Y";
			}	
			else if (getPlayAgain() == "Y")
			{
				playAgain = "N";
			}
		}
	}
	
	public static void playTable()
	{
		int choice = 0;
		int decision = 0;

		Scanner input = new Scanner(System.in);
		do
		{
			System.out.print("Enter Craps Table (Y = Sit, N = Walk) ");
			String letter = input.next();
			System.out.println();
			// force user to input specific String value to enter Table
			if (letter.contains("Y") == true && letter.length() < 2)
			{
				choice = 1;
				decision = 1;
			}
			// force user to input specific String value to walk away from table
			else if (letter.contains("N") == true && letter.length() < 2)
			{
				choice = 2;
				decision = 1;
			}
			// deny any numbers on entry to table
			else if (letter.matches("[0-9]+") == true)
			{
				System.out.println("Either sit down, or get out of here!");
				System.out.println("**Prompt is case sensitive** Capital Y = Sit, Capital N = Walk");
			}
			// deny user from entering any lower or upper case letters that are != Y and != N
			else if (letter.matches("[a-zA-Z]+") == true)
			{
				System.out.println("Maybe I was not clear enough the first time");
				System.out.println("**Prompt is case sensitive** Capital Y = Sit, Capital N = Walk");				
			}
			// deny user from entering special characters
			else if (letter.matches("[!@#$%^&*()]+") == true)
			{
				System.out.println("Are you trying to break my game?");
				System.out.println("**Prompt is case sensitive** Capital Y = Sit, Capital N = Walk");
			}
			
		}
		while (decision != 1);
		
		if (choice == 1)
		{
			playAgain = "Y";
		}
		else if (choice ==2)
		{
			playAgain = "N";
		}
	}
	
	public static void startGame()
	{
		System.out.println("Welcome to Austin's Crap House!");
	}
	
	public static String getPlayAgain()
	{
		return playAgain;
	}
	
	public static void setPlayerBalance()
	{
		playerBalance = player.getBalance();	
	}
	
	public static void setPlayerWager()
	{
		playerWager = player.getPlayerWager();
	}
	
	public static int getPlayerWager()
	{
		return playerWager;
	}
	
	public static void setGameStatus()
	{
		statusOfGame = craps.getStatusOfGame();
	}
	
	public static void getGameStatus()
	{
		if (statusOfGame == "WON")
		{
			System.out.printf("The face value is: " + addedFaceValues + " You Win!\n");
		}
		else if (statusOfGame == "LOST")
		{
			System.out.printf("The face value is: " + addedFaceValues + " You Lose!\n");
		}
		else
		{
			System.out.printf("The face value is: " + addedFaceValues + " Roll again!\n");
		}
	}// end getGameStatus

	public static void setBankBalance()
	{
		bankBalance = bank.getBankBalance();
	}
	
	public static void getBankBalance()
	{
		if (bankBalance > 0)
		{
			System.out.printf("Bank Balance: $" + bankBalance);
			System.out.println();
		}
		else if (bankBalance <= 0)
		{
			System.out.printf("You broke the bank. Congrats!");	
			System.out.println();	
		}
	}// end getGameBalance
	
	public static void getPlayerBalance()
	{
		System.out.printf("Player Balance: $" + playerBalance);
		System.out.println();
	}
	
	public static void setAddedFaceValues()
	{
		addedFaceValues = player.getAddedFaceValues();
	}
	
	public static void passAddedFaceValues()
	{
		craps.setAddedFaceValues(addedFaceValues);
	}	
	
	public static void continuePlaying()
	{
		int choice = 0;
		int decision = 0;
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.print("Continue Playing (Y = Play, N = Walk) ");
			String letter = input.next();
			System.out.println();
			if (letter.contains("Y") == true && letter.length() < 2)
			{
				choice = 1;
				decision = 1;
			}
			else if (letter.contains("N") == true && letter.length() < 2)
			{
				System.out.println("Thanks for playing at Austin's Crap House!");
				choice = 2;
				decision = 1;
			}
			else if (letter.matches("[0-9]+") == true)
			{
				System.out.println("Either sit down, or get out of here!");
				System.out.println("**Prompt is case sensitive** Capital Y = Play, Capital N = Walk");
			}
			
			else if (letter.matches("[a-zA-Z]+") == true)
			{
				System.out.println("Maybe I was not clear enough the first time");
				System.out.println("**Prompt is case sensitive** Capital Y = Play, Capital N = Walk");				
			}
			else if (letter.matches("[!@#$%^&*()]+") == true)
			{
				System.out.println("Are you trying to break my game?");
				System.out.println("**Prompt is case sensitive** Capital Y = Play, Capital N = Walk");
			}
			
		}
		while (decision != 1);
		
		if (choice == 1)
		{
			playAgain = "N";
		}
		else if (choice ==2)
		{
			playAgain = "Y";
		}
	}// end continuePlaying
}