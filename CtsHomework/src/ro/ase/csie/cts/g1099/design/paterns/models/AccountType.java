package ro.ase.csie.cts.g1099.design.paterns.models;

public enum AccountType {
	STANDARD(0),BUDGET(0),PREMIUM(1),SUPER_PREMIUM(1); 
	
	private int TaxType;

	private AccountType(int taxType) {
		TaxType = taxType;
	}
		
	public int getTaxType() {
		return this.TaxType;
	}
	
}
