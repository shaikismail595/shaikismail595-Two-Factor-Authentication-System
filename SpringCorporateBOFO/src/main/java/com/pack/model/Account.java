package com.pack.model;

public class Account {

	int CorporateId;
	long AccountNumber;
	String AccountName;
	String Currency;
	String Branch;
	double AvBalance;
	String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCorporateId() {
		return CorporateId;
	}
	public void setCorporateId(int corporateId) {
		CorporateId = corporateId;
	}
	public long getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(long accNumber) {
		AccountNumber = accNumber;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accName) {
		AccountName = accName;
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public double getAvBalance() {
		return AvBalance;
	}
	public void setAvBalance(double avBalance) {
		AvBalance = avBalance;
	}
	
	
}
