package com.tus.project.dto;

import javax.persistence.*;

@Entity
@Table(name = "SALARY")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SALARY_ID")
    private Long salaryId;

    @Column(name = "SALARY_AMOUNT")
    private double salaryAmount;
    
    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "TAX_AMOUNT")  // New field
    private double taxAmount;

    @Column(name = "BONUS_AMOUNT")  // New field
    private double bonusAmount;

    public Salary(Long salaryId, double salaryAmount, String currency, double taxAmount, double bonusAmount) {
		super();
		this.salaryId = salaryId;
		this.salaryAmount = salaryAmount;
		this.currency = currency;
		this.taxAmount = taxAmount;
		this.bonusAmount = bonusAmount;
	}

	// Constructors, getters, and setters

    public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(double bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public Salary() {
    }

    public Salary(double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public Long getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
    }

    public double getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    @Override
	public String toString() {
		return "Salary [salaryId=" + salaryId + ", salaryAmount=" + salaryAmount + ", currency=" + currency
				+ ", taxAmount=" + taxAmount + ", bonusAmount=" + bonusAmount + "]";
	}
}
