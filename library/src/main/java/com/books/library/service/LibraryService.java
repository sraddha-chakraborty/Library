package com.books.library.service;

import java.util.List;

import com.books.library.tables.Authors;
import com.books.library.tables.BookDetailPerCustomer;
import com.books.library.tables.Books;
import com.books.library.tables.Customers;
import com.books.library.tables.Employees;

public interface LibraryService {

	public String addNewBook(Books book);

	public String addCopiesOfBook(Books book);

	public List<Books> getBookList();

	public Object getBookByName(String name);

	public List<Authors> getAuthorList();

	public Object getAuthorByName(String author);
	
	public String addNewEmployee(Employees employee);

	public List<Employees> getEmployeeList();

	public Object getEmployeeByName(String employeeName);
	
	public String deleteEmployee(Long empId);

	public String addNewCustomer(Customers customer);

	public List<Customers> getCustomerList();

	public Object getCustomerDetailByEmail(String customerEmail);

	public String updateCustomerEmail(Customers customer);

	public List<BookDetailPerCustomer> addBooksToCustomer(BookDetailPerCustomer bookDetailPerCustomer);

	public List<BookDetailPerCustomer> removeBooksFromCustomer(Long customerId, Long bookId);

	public Object getBookDetailPerCustomer(Long customerId);

}
