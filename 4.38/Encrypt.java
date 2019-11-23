// Austin Marino
// 4.38 Encrption Class

public class Encrypt
{
	// instance variables
	private int initialNumber;
	private int encryptedNumber;
	
	// constructor	
	public Encrypt()
	{
	}
	
	// sets initialNumber from driver class to the encryption class
	public void setInitialNumber(int initialNumber)
	{
		this.initialNumber = initialNumber;
	}
	
	// encryption method
	public void encryptNumber()
	{		
		int digit1, digit2, digit3, digit4;
        digit1 = (((initialNumber%10)+7)%10);
        digit2 = ((((initialNumber/10)%10)+7)%10);
        digit3 = ((((initialNumber/100)%10)+7)%10);
        digit4 = (((initialNumber/1000)+7)%10);

        encryptedNumber = Integer.parseInt("" + digit2 + digit1 + digit4 + digit3);	
	}// end encryptNumber
	
	// accessor to encryptedNumber
	public int getEncryptedNumber()
	{
		return encryptedNumber;
	}
	
}// end encrypt class