package com.books.library.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Authors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long authorId;
	public String authorName;
	
	public Authors(String authorName) {
		super();
		this.authorName = authorName;
	}

	public Authors() {
		super();
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "Authors [authorId=" + authorId + ", authorName=" + authorName + "]";
	}
	
}
