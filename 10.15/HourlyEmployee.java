// Austin Marino
// Program 10.15
// Hourly Employee

public class HourlyEmployee extends Employee
{
    private double hoursWorked;
    private double hoursWage;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hoursWorked, double hoursWage)
    {
    	
        super (firstName, lastName, socialSecurityNumber);

        if (hoursWorked < 0.0 || hoursWorked > 168.0)
            throw new IllegalArgumentException("Hour must be between 0 and 168");

        if (hoursWage <= 0.0)
            throw new IllegalArgumentException("Wage must be greater than 0");
        this.hoursWorked = hoursWorked;
        this.hoursWage = hoursWage;
    }

    public void setHours(double hours)
    {
        if (hoursWorked < 0.0 || hoursWorked > 168.0)
            throw new IllegalArgumentException("Hour must be between 0 and 168");
        this.hoursWorked = hoursWorked;
    }

    public double getHours()
    {
        return hoursWorked;
    }

    public void setWage(double HoursWage)
    {
        if (hoursWage <= 0.0)
            throw new IllegalArgumentException("Wage must be greater than 0");
        this.hoursWage = hoursWage;
    }

    public double getWage()
    {
        return hoursWage;
    }

	@Override
    public double getPaymentAmount()
    {
        if (hoursWorked <= 40)
            return hoursWorked * hoursWage;
        else
            return 40 * getWage() + (getHours() - 40) * (getWage() * 1.5);
    }

	@Override
    public String toString()
    {
        return String.format("%s %s%n%s: %.2f%n%s: $%.2f", "Hourly" ,super.toString(), "Hours Worked", getHours(), "Hourly Rate", getWage());
    }
}