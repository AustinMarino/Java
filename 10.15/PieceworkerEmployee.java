// Austin Marino
// Program 10.15
// Pieceworker Employee

public class PieceworkerEmployee extends Employee
{                                                
 	private int piecesManufactured;
   	private double pricePerItem;

   	public PieceworkerEmployee(String firstName, String lastName, String socialSecurityNumber, int piecesManufactured, double pricePerItem)
   	{
	  	super(firstName, lastName, socialSecurityNumber);
	     
      	if (piecesManufactured < 0.0) 
      		throw new IllegalArgumentException("Manufactured amount must be >= 0.0");

      	if (pricePerItem <= 0.0)
         	throw new IllegalArgumentException("Price per item must be > 0.0");

      	this.piecesManufactured = piecesManufactured;
      	this.pricePerItem = pricePerItem;
  	}

   	public void setManufacturedAmount(int piecesManufactured)
   	{
   		if (piecesManufactured < 0.0) 
         	throw new IllegalArgumentException("Manufactured amount must be >= 0.0");

        this.piecesManufactured = piecesManufactured;
   	} 
   	
   	public int getPiecesManufactured()
   	{
      	return piecesManufactured;
   	} 

   	public void pricePerItem(double pricePerItem)
   	{
      	if (pricePerItem <= 0.0)
         	throw new IllegalArgumentException("Payment amount must be > 0.0");

      	this.pricePerItem = pricePerItem;
   	} 

   	public double getPricePerItem()
   	{
      	return pricePerItem;
   	}

	@Override
   	public double getPaymentAmount()
   	{
      	return getPricePerItem() * getPiecesManufactured();
   	} 

   	@Override 
   	public String toString()
   	{
      	return String.format("%s %s%n%s: %d%n%s: $%.2f", "Pieceworker", super.toString(), "Manufactured Amount", getPiecesManufactured(), "Price Per Item", getPricePerItem());
   	} 
}