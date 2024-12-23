package com.books.library.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long customerId;
	public String customerName;
	public String customerEmail;
	public String customerAdharNumber;
	
	

	public Customers(String customerName, String customerEmail, String customerAdharNumber) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerAdharNumber = customerAdharNumber;
	}

	public Customers() {
		super();
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAdharNumber() {
		return customerAdharNumber;
	}

	public void setCustomerAdharNumber(String customerAdharNumber) {
		this.customerAdharNumber = customerAdharNumber;
	}

	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerAdharNumber=" + customerAdharNumber + "]";
	}

}
