package ro.ase.csie.cts.g1099.design.paterns.models;

public class Account {
	private double	loanValue,rate;	
	private int	daysActive,accountType;
	public static final int	STANDARD=0,BUDGET=1,PREMIUM=2,SUPER_PREMIUM=3;
	
	public Account(double LoanValue, double Rate, int AccountType) throws Exception {
		if(LoanValue<0)
			throw new Exception();
		else
		{
			loanValue = LoanValue;
		}
		this.rate = Rate;
		this.accountType = AccountType;
	}
	
	public double getLoanValue() {
		System.out.println("The loan value is " + this.accountType);
		return loanValue;
	}
	
	public double getRate() {
		System.out.println("The rate is "+rate);
		return this.rate;
	}
	
	public double getMonthlyRate() {
		return loanValue*rate;
	}
	
	public void setValue(double LoanValue) throws Exception {
		if(LoanValue<0)
			throw new Exception();
		else
		{
			loanValue = LoanValue;
		}
	}
	
	public String toString() {
		return "Loan: "+ this.loanValue+
				"; rate: "+ this.rate+
				"; days active:"+ this.daysActive+
				"; Type: "+ this.accountType+";";
	}
	
	public static double calculate(Account[] accounts)
	{
		double totalFee=0.0;
		Account	account;
		int temp = 365;
		for	(int	i=0;i<accounts.length;i++){
			account=accounts[i];
			if(account.accountType==Account.PREMIUM||account.accountType==Account.SUPER_PREMIUM)	
				totalFee+=.0125	*(account.loanValue*Math.pow(account.rate,(account.daysActive/365)) - account.loanValue);
		}
		return	totalFee;
	}


	
	
}