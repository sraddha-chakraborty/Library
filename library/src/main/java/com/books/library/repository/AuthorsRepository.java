package com.books.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.library.tables.Authors;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long>{

	public Authors findAuthorsByAuthorName(String authorName);
}
