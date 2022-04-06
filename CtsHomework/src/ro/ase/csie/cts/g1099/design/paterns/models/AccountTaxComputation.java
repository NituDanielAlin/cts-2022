package ro.ase.csie.cts.g1099.design.paterns.models;

import ro.ase.csie.cts.g1099.design.paterns.customexceptions.NegativeLoanException;

public class AccountTaxComputation extends Account {

	public AccountTaxComputation(double LoanValue, double Rate, AccountType Type) throws NegativeLoanException {
		super(LoanValue, Rate, Type);
	}
	
	private static double computeTax(Account account) {
		double tax = 0;
		tax = constants.FEE_PERCENTAGE*(account.getLoanValue()*Math.pow(account.getRate(),(account.getDaysActive()/constants.DAYS_OF_YEAR)) - account.getLoanValue());
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
