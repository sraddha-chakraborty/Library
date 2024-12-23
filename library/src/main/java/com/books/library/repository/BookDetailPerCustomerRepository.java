package com.books.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.library.tables.BookDetailPerCustomer;

@Repository
public interface BookDetailPerCustomerRepository extends JpaRepository<BookDetailPerCustomer, Long>{

	public List<BookDetailPerCustomer> findBookDetailPerCustomerByCustomerId(Long customerId);
	public void deleteBookDetailPerCustomerByCustomerIdAndBookId(Long customerId, Long bookId);
}
