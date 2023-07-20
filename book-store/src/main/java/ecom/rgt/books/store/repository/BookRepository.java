package ecom.rgt.books.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ecom.rgt.books.store.entity.Books;

public interface BookRepository extends JpaRepository<Books, Integer>{
	public Books findById(Long id);
	
	public Books findByBookName(String bookName);
}
