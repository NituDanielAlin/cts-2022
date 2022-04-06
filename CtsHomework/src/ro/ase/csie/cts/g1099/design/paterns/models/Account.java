package ro.ase.csie.cts.g1099.design.paterns.models;
import ro.ase.csie.cts.g1099.design.paterns.models.Constants;
import ro.ase.csie.cts.g1099.design.paterns.customexceptions.NegativeLoanException;

public class Account {
	private double	loanValue,rate;	
	private int	daysActive;
	static Constants constants;
	AccountType type;
	
	public Account(double LoanValue, double Rate, AccountType Type) throws NegativeLoanException {
		if(LoanValue<0)
			throw new NegativeLoanException();
		this.loanValue = LoanValue;
		this.rate = Rate;
		this.type = Type;
	}
	
	public double getLoanValue() {
		System.out.println("The loan value is " + this.type);
		return loanValue;
	}
	
	public double getRate() {
		System.out.println("The rate is "+rate);
		return this.rate;
	}
	
	public double getMonthlyRate() {
		return loanValue*rate;
	}
	
	public void setLoanValue(double LoanValue) throws NegativeLoanException {
		if(LoanValue<0)
			throw new NegativeLoanException();
		this.loanValue = LoanValue;
	}
	
	public String toString() {
		return "Loan: "+ this.loanValue+
				"; rate: "+ this.rate+
				"; days active:"+ this.daysActive+
				"; Type: "+ this.type+ ";";
	}
	
	private static double computeTax(Account account) {
		double tax = 0;
		tax = constants.FEE_PERCENTAGE*(account.loanValue*Math.pow(account.rate,(account.daysActive/constants.DAYS_OF_YEAR)) - account.loanValue);
		return tax;
	}
	
	public static double calculateTotalTax(Account[] accounts)
	{
		double totalFee=0.0;
		Account	account;
		for	(int i=0; i<accounts.length; i++){
			account=accounts[i];
			if(account.type.getTaxType() == 1)	
				totalFee+= computeTax(account);
		}
		return	totalFee;
	}


	
	
}