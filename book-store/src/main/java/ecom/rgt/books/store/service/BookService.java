package ecom.rgt.books.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ecom.rgt.books.store.dao.PageResponse;
import ecom.rgt.books.store.entity.Books;

@Service
public interface BookService {
	public Books addBook(Books book);
	
	public Books getBook(Integer bId);
	
	public Books updateBook(Integer bId, Books book);
	
	public void deleteBook(Integer bId);
	
	public PageResponse listOfBooks(Integer page, Integer size);
	
	public Books bookByName(String bookName);
	
	public List<Books> activeBooks();
}
