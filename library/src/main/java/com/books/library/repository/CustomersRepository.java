package com.books.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.library.tables.Customers;
import com.books.library.tables.Employees;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long>{

	public Customers findCustomersByCustomerName(String customerName);
	public Customers findCustomersByCustomerEmail(String customerEmail);
	public Customers findCustomersByCustomerAdharNumber(String customerAdharNumber);
}
