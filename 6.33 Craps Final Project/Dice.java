// Austin Marino
// Final Project
// Dice Class

public class Dice
{
	private int addedFaceValues;

	private static Die die1 = new Die();
	private static Die die2 = new Die();
	
	public void rollDice()
	{
		die1.rollDie();
		die2.rollDie();
	}
	
	// adding two random die values to create a sum of die
	public void addFaceValues()
	{
		int sumOfDie = die1.getFaceValue() + die2.getFaceValue();
		setAddedFaceValues(sumOfDie);
	}
	
	// set addedFaceValues to be passed
	public void setAddedFaceValues(int sumOfDie)
	{
		addedFaceValues = sumOfDie;
	}
	
	// accessor method for addedFaceValues
	public int getAddedFaceValues()
	{
		return addedFaceValues;
	}

}