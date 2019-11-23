// Austin Marino
// 4.38 Decryption Class

public class Decrypt
{
	// instance variables
	private int encryptedNumber;
	private int decryptedNumber;
	
	// constructor
	public Decrypt()
	{
	}
	
	// method to decrypt
	public void decryptNumber()
	{
		int digit1, digit2, digit3, digit4;
        digit1 = (((encryptedNumber%10)+3)%10);
        digit2 = ((((encryptedNumber/10)%10)+3)%10);
        digit3 = ((((encryptedNumber/100)%10)+3)%10);
        digit4 = (((encryptedNumber/1000)+3)%10);

        decryptedNumber = Integer.parseInt("" + digit2 + digit1 + digit4 + digit3);	
	}// end decryptNumber
	
	// mutator to set encrypted number from encryption class to be decrypted
	public void setEncryptedNumber(int encryptedNumber)
	{
		this.encryptedNumber = encryptedNumber;
	}
	
	// accessor to decrypted number
	public int getDecryptedNumber()
	{
		return decryptedNumber;
	}
}// end decrypt class