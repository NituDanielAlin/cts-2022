package ro.ase.csie.cts.g1099.design.paterns.models;
import ro.ase.csie.cts.g1099.design.paterns.models.Constants;
import ro.ase.csie.cts.g1099.design.paterns.customexceptions.NegativeActiveDaysException;
import ro.ase.csie.cts.g1099.design.paterns.customexceptions.NegativeLoanException;
import ro.ase.csie.cts.g1099.design.paterns.customexceptions.NegativeRateException;
import ro.ase.csie.cts.g1099.design.paterns.interfaces.AccountInterface;

public class Account implements AccountInterface {
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
		return loanValue;
	}
	
	public void setLoanValue(double LoanValue) throws NegativeLoanException {
		if(LoanValue<0)
			throw new NegativeLoanException();
		this.loanValue = LoanValue;
	}
	
	public double getRate() {
		return this.rate;
	}
	
	public void setRate(double rate) throws NegativeRateException {
		if(rate<0)
			throw new NegativeRateException();
		this.rate = rate;
	}
	
	public int getDaysActive() {
		return daysActive;
	}

	public void setDaysActive(int daysActive) throws NegativeActiveDaysException {
		if(daysActive<0)
			throw new NegativeActiveDaysException();
		this.daysActive = daysActive;
	}
	
	public String toString() {
		return "Loan: "+ this.loanValue+
				"; rate: "+ this.rate+
				"; days active:"+ this.daysActive+
				"; Type: "+ this.type+ ";";
	}
	
	@Override
	public double getMonthlyRate() {
		return loanValue*rate;
	}


	
	
}