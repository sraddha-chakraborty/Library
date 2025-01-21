package com.books.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.library.tables.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long>{

	public Books findBooksByBookTitleAndBookAuthor(String bookTitle, String bookAuthor);
	public Books findBooksByBookTitle(String bookTitle);
}
