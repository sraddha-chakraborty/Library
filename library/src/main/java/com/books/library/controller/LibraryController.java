package com.books.library.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.library.service.LibraryService;
import com.books.library.tables.Authors;
import com.books.library.tables.BookDetailPerCustomer;
import com.books.library.tables.Books;
import com.books.library.tables.Customers;
import com.books.library.tables.Employees;

@RestController
@RequestMapping("/LibaryManagement")
public class LibraryController {

	LibraryService libraryService;

	public LibraryController(LibraryService libraryService) {
		super();
		this.libraryService = libraryService;
	}

	//Book Management
	@PostMapping("/addNewBook")
	public String addNewBook(@RequestBody Books book)
	{
		return libraryService.addNewBook(book);
	}
	
	@PutMapping("/addCopiesOfBook")
	public String addCopiesOfBook(@RequestBody Books book)
	{
		return libraryService.addCopiesOfBook(book);
	}
	
	@GetMapping("/getBookList")
	public List<Books> getBookList()
	{
		return libraryService.getBookList();
	}
	
	@GetMapping("/getBookByName/{bookName}")
	public Object getBookByName(@PathVariable String bookName)
	{
		return libraryService.getBookByName(bookName);
	}
	
	//Author Management
	@GetMapping("/getAuthorList")
	public List<Authors> getAuthorList()
	{
		return libraryService.getAuthorList();
	}
	
	@GetMapping("/getAuthorByName/{authorName}")
	public Object getAuthorByName(@PathVariable String authorName)
	{
		return libraryService.getAuthorByName(authorName);
	}
	
	//Employee Management
	@PostMapping("/addNewEmployee")
	public String addNewEmployee(@RequestBody Employees employee)
	{
		return libraryService.addNewEmployee(employee);
	}
	
	@GetMapping("/getEmployeeList")
	public List<Employees> getEmployeeList()
	{
		return libraryService.getEmployeeList();
	}
	
	@GetMapping("/getEmployeeByName/{employeeName}")
	public Object getEmployeeByName(@PathVariable String employeeName)
	{
		return libraryService.getEmployeeByName(employeeName);
	}
	
	@DeleteMapping("/deleteEmployee/{empId}")
	public String deleteEmployee(@PathVariable Long empId)
	{
		return libraryService.deleteEmployee(empId);
	}
	
	//Customer Management
	@PostMapping("/addNewCustomer")
	public String addNewCustomer(@RequestBody Customers customer)
	{
		return libraryService.addNewCustomer(customer);
	}
		
	@GetMapping("/getCustomerList")
	public List<Customers> getCustomerList()
	{
		return libraryService.getCustomerList();
	}
		
	@GetMapping("/getCustomerDetailByEmail/{customerEmail}")
	public Object getCustomerDetailByEmail(@PathVariable String customerEmail)
	{
		return libraryService.getCustomerDetailByEmail(customerEmail);
	}
	
	@PutMapping("/updateCustomerEmail")
	public String updateCustomerEmail(@RequestBody Customers customer)
	{
		return libraryService.updateCustomerEmail(customer);
	}
	
	//BookDetailPerCustomer Management
	@PostMapping("/addBooksToCustomer")
	public List<BookDetailPerCustomer> addBooksToCustomer(@RequestBody BookDetailPerCustomer bookDetailPerCustomer)
	{
		return libraryService.addBooksToCustomer(bookDetailPerCustomer);
	}
	
	@DeleteMapping("/removeBooksFromCustomer/query")
	public List<BookDetailPerCustomer> removeBooksFromCustomer(@RequestParam Long customerId, @RequestParam Long bookId)
	{
		return libraryService.removeBooksFromCustomer(customerId, bookId);
	}
	
	@GetMapping("/getBookDetailPerCustomer/{customerId}")
	public Object getBookDetailPerCustomer(@PathVariable Long customerId)
	{
		return libraryService.getBookDetailPerCustomer(customerId);
	}
}
