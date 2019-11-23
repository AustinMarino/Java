// Austin Marino
// Final Project
// Craps Class Pulled from Chapter 6

public class Craps
{
	private enum Status{ CONTINUE, WON, LOST};
	
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;
	private Status gameStatus;
	private String statusOfGame;
	private int addedFaceValues;
	private int playerPoint;
	
	public void setAddedFaceValues(int addedFaceValues)
	{
		 this.addedFaceValues = addedFaceValues;	
	}
	
	public int getAddedFaceValues()
	{
		return addedFaceValues;
	}
	
	public void firstRoll()
	{	
		switch(addedFaceValues)
		{
			case SEVEN: //win with 7 on first roll
			case YO_LEVEN: //win with 11 on first roll
				gameStatus = Status.WON;
				break;
			case SNAKE_EYES: //lose with 2 on first roll
			case TREY: // lose with 3 on frist roll
			case BOX_CARS: // lose with 12 on first roll
				gameStatus = Status.LOST;
				break;
			default: // did not win or lose
				gameStatus = Status.CONTINUE;
				playerPoint = addedFaceValues;
				break;
		}
	}
	
	public void nextRoll()
	{
		if (addedFaceValues == playerPoint)
		{
			gameStatus = Status.WON;
		}
		else if (addedFaceValues == SEVEN)
		{
			gameStatus = Status.LOST;
		}
		else
		{
			gameStatus = Status.CONTINUE;
		}
	}
	
	public int getPlayerPoint()
	{
		return playerPoint;
	}
	
	public String displayStatus()
	{
		if (gameStatus == Status.WON)
		{
			statusOfGame = "WON";
			return statusOfGame;
		}
		else if (gameStatus == Status.LOST)
		{
			statusOfGame = "LOST";
			return statusOfGame;
		}
		else
		{
			statusOfGame = "CONTINUE";
			return statusOfGame;
		}
	}
	
	public String getStatusOfGame()
	{
		return statusOfGame;
	}
}