package com.javabean;
import java.io.Serializable;

@SuppressWarnings("serial")
public class ClaimBean implements Serializable {
	private String claimantName;
	private String claimType;
	private double claimAmount;
	
	public String getClaimantName() {
		return claimantName;
	}
	public void setClaimantName(String claimantName) {
		this.claimantName = claimantName;
	}
	public String getClaimType() {
		return claimType;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	public double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	

}
