package com.books.library.tables;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class BookDetailPerCustomer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long bdcId;
	public Long customerId;
	public Long bookId;
	public LocalDate bookCheckoutDate;
	public Integer borrowTimeLimitationInDays;
	@Transient
	public Integer actualBorrowTimeInDays;
	
	public BookDetailPerCustomer(Long customerId, Long bookId, LocalDate bookCheckoutDate,
			Integer borrowTimeLimitationInDays) {
		super();
		this.customerId = customerId;
		this.bookId = bookId;
		this.bookCheckoutDate = bookCheckoutDate;
		this.borrowTimeLimitationInDays = borrowTimeLimitationInDays;
	}

	public BookDetailPerCustomer() {
		super();
	}

	public Long getBdcId() {
		return bdcId;
	}

	public void setBdcId(Long bdcId) {
		this.bdcId = bdcId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public LocalDate getBookCheckoutDate() {
		return bookCheckoutDate;
	}

	public void setBookCheckoutDate(LocalDate bookCheckoutDate) {
		this.bookCheckoutDate = bookCheckoutDate;
	}

	public Integer getBorrowTimeLimitationInDays() {
		return borrowTimeLimitationInDays;
	}

	public void setBorrowTimeLimitationInDays(Integer borrowTimeLimitationInDays) {
		this.borrowTimeLimitationInDays = borrowTimeLimitationInDays;
	}

	public Integer getActualBorrowTimeInDays() {
		return Period.between(this.bookCheckoutDate, LocalDate.now()).getDays();
	}

	public void setActualBorrowTimeInDays(Integer actualBorrowTimeInDays) {
		this.actualBorrowTimeInDays = actualBorrowTimeInDays;
	}

	@Override
	public String toString() {
		return "BookDetailPerCustomer [customerId=" + customerId + ", bookId=" + bookId + ", bookCheckoutDate="
				+ bookCheckoutDate + ", borrowTimeLimitationInDays=" + borrowTimeLimitationInDays
				+ ", actualBorrowTimeInDays=" + actualBorrowTimeInDays + "]";
	}
	
}
