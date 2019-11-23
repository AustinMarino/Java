// Austin Marino
// Program 10.15
/* Employee super class test with array modification
 also with the basePlusCommission employee receiving a 
 10% salaray increase. In this lab, I used the Invoice 
 and Payable class from our text book Chapter 10 Fig. 10.12.
*/

public class TestEmployee
{
	public static void main(String [] args)
	{
   		Payable[] payableObjects = new Payable[7];
		
		payableObjects[0] = new Invoice("01234", "Seat", 2, 375.00);
      	payableObjects[1] = new Invoice("56789", "Tire", 4, 79.95);
		payableObjects[2] = new HourlyEmployee("Drew", "Brown", "333-33-3333",40.0, 27.0);   
		payableObjects[3] = new SalariedEmployee("Tom", "White", "123-12-1234", 900);
		payableObjects[4] = new CommissionEmployee("Bob", "Smith", "222-22-2222", 5000, .1);
		payableObjects[5] = new BasePlusCommissionEmployee("Tony", "Pizzaz", "777-77-7777", 1000, .05, 3000);
		payableObjects[6] = new PieceworkerEmployee("Sally", "Blue", "444-44-4444", 1500, 2.50);
		
		
		for (Payable payableCurrent : payableObjects)
		{
			System.out.println(payableCurrent);
	
			if (payableCurrent instanceof BasePlusCommissionEmployee)
			{
				BasePlusCommissionEmployee payable = (BasePlusCommissionEmployee) payableCurrent ;
				
				// increases basePlusCommission emplyee base salary by 10%
				payable.setBaseSalary(1.10 * payable.getBaseSalary());
				
				System.out.printf("%s $%.2f%n","Salary increased by 10%:", 
				payable.getBaseSalary());
			}
			
			System.out.printf("%s $%.2f%n%n","Payment Due:", payableCurrent.getPaymentAmount());
		}
	}
}
