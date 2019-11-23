// Austin Marino
// Final Project
// Die Class

import java.security.SecureRandom;

public class Die
{
	private int faceValue;
	
	private static final SecureRandom randomNumbers = new SecureRandom();
		
	public Die()
	{
	}
	
	// randomly generates a number 1-6
	public void rollDie()
	{
		int die = 1 + randomNumbers.nextInt(6);
		setFaceValue(die);
	}
	
	// set each die face value
	public void setFaceValue(int die)
	{
		faceValue = die;
	}
	 // accessor for die value
	public int getFaceValue()
	{
		return faceValue;
	}
}//class ends