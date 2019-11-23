// Austin Marino
// 4.38 Driver Class

import java.util.Scanner;

public class Driver
{
	// instance variables
	private static int initialNumber;
	private static int initialNumberCheck1;
	private static int initialNumberCheck2;
	private static int encryptedNumber;
	private static int decryptedNumber;
	private static Encrypt encryption = new Encrypt();
	private static Decrypt decryption = new Decrypt();
	
	public static void main (String [] args)
	{
		// do while loop that executes entire driver method
		do
		{
			userInput();
			confirmInput();
		}
		while(validateInitialNumber() != 1);
		setInitialNumber(initialNumberCheck1);
		passInitialNumber();
		startNumberEncryption();
		setEncryptedNumber();
		System.out.printf("The encrypted number is %04d\n", getEncryptedNumber());
		System.out.println();
		passEncryptedNumber();
		startNumberDecryption();
		setDecryptedNumber();
		System.out.printf("The decrypted number is %04d\n", getDecryptedNumber());
	}// end main
	
	// take in user input
	public static void userInput()
	{
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.println("Please enter a 4 digit number ranging from 0000-9999: ");
			while(!input.hasNextInt())
			{
				// terminates program if user input anything else except for numbers
				System.out.print("Invalid input! Program Terminating \n");
				System.out.print("Next time, please enter 4 digits \n");
				System.exit(0);
				
			}// end while
			System.out.println();
			initialNumberCheck1 = input.nextInt();
		}// end do while
		while (initialNumberCheck1 < 0000 || initialNumberCheck1 > 9999);
	}// end userInput1
	
	// two step confirmation method
	public static void confirmInput()
	{
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.println("Can you please confirm your 4 digit number: ");
			while(!input.hasNextInt())
			{
				// terminates program if user input anything else except for numbers
				System.out.println("Invalid input! Program Terminating \n");
				System.out.print("Next time, please enter 4 digits \n");
				System.exit(0);
			}// end while
			System.out.println();
			initialNumberCheck2 = input.nextInt();
		}// end do while
		while(initialNumberCheck2 < 0000 || initialNumberCheck2 > 9999);
	}// end confirmInput
	
	// validating if numbers match, if they do not match prompt user with incorrect confirmation
	public static int validateInitialNumber()
	{
		if(initialNumberCheck1 == initialNumberCheck2)
		{
			return 1;
		}
		
		if(initialNumberCheck1 != initialNumberCheck2)
		{
			System.out.println("Your 4 digit number does not match. Please try again!");
		}
		return 0;
	}// end validateInitialNumber
	
	// setting initialNumber
	public static void setInitialNumber(int initialNumberCheck1)
	{
		initialNumber = initialNumberCheck1;
	}
	
	// passing number to encryption
	public static void passInitialNumber()
	{
		encryption.setInitialNumber(initialNumber);
	}
	
	// executes encryption method
	public static void startNumberEncryption()
	{
		encryption.encryptNumber();
	}
	
	// takes number from encryption method and stores it in memory
	public static void setEncryptedNumber()
	{
		encryptedNumber = encryption.getEncryptedNumber();
	}
	
	// accessor method for encrypted number
	public static int getEncryptedNumber()
	{
		return encryptedNumber;
	}
	
	// pass encrypted number to decryption class
	public static void passEncryptedNumber()
	{
		decryption.setEncryptedNumber(encryptedNumber);
	}
	
	// starts decryption process on encrypted number
	public static void startNumberDecryption()
	{
		decryption.decryptNumber();
	}
	
	// sets decrypted value and stores it
	public static void setDecryptedNumber()
	{
		decryptedNumber = decryption.getDecryptedNumber();
	}
	
	// accessor to decrypted number
	public static int getDecryptedNumber()
	{
		return decryptedNumber;
	}
}// end driver class