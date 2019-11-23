// Austin Marino
// Final Project
// Bank Class

public class Bank
{
	// setting bank/house value to 50,000
	private int bankBalance = 50000;
	
	//constructor
	public Bank()
	{
	}
	
	// incriments bankBalance if player loses
	public void increaseBankBalance(int playerWage)
	{
		bankBalance += playerWage;
	}
	
	// de-incriments bankBalance if player wins
	public void decreaseBankBalance(int playerWage)
	{
		bankBalance -= playerWage;
	}
	
	// accessor for bankBalance
	public int getBankBalance()
	{
		return bankBalance;
	}
}