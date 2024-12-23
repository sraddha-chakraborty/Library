package com.books.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.books.library.repository.AuthorsRepository;
import com.books.library.repository.BookDetailPerCustomerRepository;
import com.books.library.repository.BooksRepository;
import com.books.library.repository.CustomersRepository;
import com.books.library.repository.EmployeesRepository;
import com.books.library.tables.Authors;
import com.books.library.tables.BookDetailPerCustomer;
import com.books.library.tables.Books;
import com.books.library.tables.Customers;
import com.books.library.tables.Employees;

import jakarta.transaction.Transactional;

@Service
public class LibraryServiceImpl implements LibraryService{

	BooksRepository booksRepo;
	AuthorsRepository authorRepo;
	EmployeesRepository employeeRepo;
	CustomersRepository customerRepo;
	BookDetailPerCustomerRepository bookDetailPerCustomerRepo;
	
	public LibraryServiceImpl(BooksRepository booksRepo, AuthorsRepository authorRepo, EmployeesRepository employeeRepo,
			CustomersRepository customerRepo, BookDetailPerCustomerRepository bookDetailPerCustomerRepo) {
		super();
		this.booksRepo = booksRepo;
		this.authorRepo = authorRepo;
		this.employeeRepo = employeeRepo;
		this.customerRepo = customerRepo;
		this.bookDetailPerCustomerRepo = bookDetailPerCustomerRepo;
	}

	@Override
	public String addNewBook(Books book) {
		if (booksRepo.findBooksByBookTitle(book.getBookTitle()) != null)
		{
			throw new IllegalStateException("Book is already present in database!");
		}
		else
		{
			booksRepo.save(book);
			
			if (authorRepo.findAuthorsByAuthorName(book.getBookAuthor()) == null)
			{
				authorRepo.save(new Authors(book.getBookAuthor()));
			}
		}
		
		return "New Book added to database successfully!";
	}

	@Override
	@Transactional
	public String addCopiesOfBook(Books book) {
		if (booksRepo.findBooksByBookTitle(book.getBookTitle()) != null)
		{
			Books getBook = booksRepo.findBooksByBookTitle(book.getBookTitle());
			Integer existingBookCount = getBook.getBookCount();
			getBook.setBookCount(existingBookCount+book.getBookCount());
		}
		else
		{
			throw new IllegalStateException("Book not found in database! Please add it as a new book!");
		}
		
		return "Book copy added to database successfully! Current Book count for "+booksRepo.findBooksByBookTitle(book.getBookTitle()).getBookTitle()+" is: "+booksRepo.findBooksByBookTitle(book.getBookTitle()).getBookCount();
	
//If u want to update the counter of a book by searching for the book based on id. U need to add the "bookId" to the payload json as well.

//		if (booksRepo.findById(book.getBookId()) != null && !booksRepo.findById(book.getBookId()).isEmpty())
//		{
//			Books getBook = booksRepo.findById(book.getBookId()).get();
//			Integer existingBookCount = getBook.getBookCount();
//			getBook.setBookCount(existingBookCount+book.getBookCount());
//		}
//		else
//		{
//			throw new IllegalStateException("Book not found in database! Please add it as a new book!");
//		}
//		
//		return "Book copy added to database successfully! Current Book count for "+booksRepo.findById(book.getBookId()).get().getBookTitle()+" is: "+booksRepo.findById(book.getBookId()).get().getBookCount();
	}

	@Override
	public List<Books> getBookList() {
		
		return booksRepo.findAll();
	}

	@Override
	public Object getBookByName(String name) {
		
		return ((booksRepo.findBooksByBookTitle(name) != null) ? booksRepo.findBooksByBookTitle(name) : "Book Name not found in database!");
	}

	@Override
	public List<Authors> getAuthorList() {
		
		return authorRepo.findAll();
	}

	@Override
	public Object getAuthorByName(String author) {
		
		return ((authorRepo.findAuthorsByAuthorName(author) != null) ? authorRepo.findAuthorsByAuthorName(author) : "Author not found in database!");
	}

	@Override
	public String addNewEmployee(Employees employee) {
		
		if (employeeRepo.findEmployeesByEmpName(employee.getEmpName()) != null)
		{
			throw new IllegalStateException("Employee is already present in database!");
		}
		else
		{
			employeeRepo.save(employee);
		}
		
		return "New Employee added to database successfully! Welcome "+employee.getEmpName();
	}

	@Override
	public List<Employees> getEmployeeList() {
		
		return employeeRepo.findAll();
	}

	@Override
	public Object getEmployeeByName(String employeeName) {
		
		return ((employeeRepo.findEmployeesByEmpName(employeeName)!= null) ? employeeRepo.findEmployeesByEmpName(employeeName) : "Employee not found in database");
	}

	@Override
	public String deleteEmployee(Long empId) {
		
		if ((employeeRepo.findById(empId)!= null))
		{
			employeeRepo.deleteById(empId);
			return "Employee record deleted from database";
		}
		else
		{
			throw new IllegalStateException("Employee record not found in database");
		}
	}

	@Override
	public String addNewCustomer(Customers customer) {
		
		if (customerRepo.findCustomersByCustomerAdharNumber(customer.getCustomerAdharNumber()) != null)
		{
			throw new IllegalStateException("Customer is already present in database!");
		}
		else
		{
			customerRepo.save(customer);
		}
		
		return "New Customer added to database successfully! Welcome "+customer.getCustomerName();
	}

	@Override
	public List<Customers> getCustomerList() {
		
		return customerRepo.findAll();
	}

	@Override
	public Object getCustomerDetailByEmail(String customerEmail) {
		
		return ((customerRepo.findCustomersByCustomerEmail(customerEmail)!= null) ? customerRepo.findCustomersByCustomerEmail(customerEmail) : "Customer not found in database");
	}

	@Override
	@Transactional
	public String updateCustomerEmail(Customers customer) {
		
		if (customerRepo.findCustomersByCustomerAdharNumber(customer.getCustomerAdharNumber()) != null)
		{
			Customers existingCustomer = customerRepo.findCustomersByCustomerAdharNumber(customer.getCustomerAdharNumber());
			existingCustomer.setCustomerEmail(customer.getCustomerEmail());
		}
		else
		{
			throw new IllegalStateException("Customer not present in database! Please add new customer!");
		}
		return "Customer email updated successfully!";
	}

	@Override
	public List<BookDetailPerCustomer> addBooksToCustomer(BookDetailPerCustomer bookDetailPerCustomer) {
		
		bookDetailPerCustomerRepo.save(bookDetailPerCustomer);
		if(booksRepo.findById(bookDetailPerCustomer.getBookId()) != null)
		{
			Optional<Books> bookDetail = booksRepo.findById(bookDetailPerCustomer.getBookId());
			Integer bookCount = bookDetail.get().getBookCount() - 1;
			bookDetail.get().setBookCount(bookCount);
			booksRepo.save(bookDetail.get());
		}
		return bookDetailPerCustomerRepo.findBookDetailPerCustomerByCustomerId(bookDetailPerCustomer.getCustomerId());
	}

	@Override
	@Transactional
	public List<BookDetailPerCustomer> removeBooksFromCustomer(Long customerId, Long bookId) {
		
		if (bookDetailPerCustomerRepo.findBookDetailPerCustomerByCustomerId(customerId) != null)
		{
			List<BookDetailPerCustomer> bookDetailPerCustomer = bookDetailPerCustomerRepo.findBookDetailPerCustomerByCustomerId(customerId);
			
			for (BookDetailPerCustomer bookDetail : bookDetailPerCustomer)
			{
				if (bookDetail.getBookId().toString().trim().equalsIgnoreCase(bookId.toString().trim()))
				{
					bookDetailPerCustomerRepo.deleteBookDetailPerCustomerByCustomerIdAndBookId(customerId, bookId);
					break;
				}
			}
		}
		
		if(booksRepo.findById(bookId) != null)
		{
			Optional<Books> bookDetail = booksRepo.findById(bookId);
			Integer bookCount = bookDetail.get().getBookCount() + 1;
			bookDetail.get().setBookCount(bookCount);
		}
		
		return bookDetailPerCustomerRepo.findBookDetailPerCustomerByCustomerId(customerId);
	}

	@Override
	public Object getBookDetailPerCustomer(Long customerId) {
		return bookDetailPerCustomerRepo.findBookDetailPerCustomerByCustomerId(customerId);
	}

}
