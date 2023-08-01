package ecom.rgt.books.store.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ecom.rgt.books.store.dao.PageResponse;
import ecom.rgt.books.store.entity.Books;
import ecom.rgt.books.store.exception.ResourceNotFoundException;
import ecom.rgt.books.store.repository.BookRepository;
import ecom.rgt.books.store.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public Books addBook(Books book) {
		Books savedBook = bookRepo.save(book);
		return savedBook;
	}

	@Override
	public Books getBook(Integer id) {
		Books foundBook = this.bookRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("BookService", "getBooks", id));
		return foundBook;
	}

	@Override
	public Books updateBook(Integer bId, Books book) {
		Books foundBook = this.bookRepo.findById(bId).orElseThrow(() -> new ResourceNotFoundException("BookService", "updateBook", bId));
		if(book.getAuthorName() != null) foundBook.setAuthorName(book.getAuthorName());
		if(book.getBookName() != null) foundBook.setBookName(book.getBookName());
		foundBook.setAvailable(book.isAvailable());
		Books updatedBook = this.bookRepo.save(foundBook);
		return updatedBook;
	}

	@Override
	public void deleteBook(Integer bId) {
		Books foundUser = this.bookRepo.findById(bId).orElseThrow(() -> new ResourceNotFoundException("BookService", "deleteUser", bId));
		this.bookRepo.delete(foundUser);
	}

	@Override
	public PageResponse listOfBooks(Integer page, Integer size) {
		
		PageRequest pageable = PageRequest.of(page, size);
		Page<Books> bookpage = this.bookRepo.findAll(pageable);
		List<Books> content = bookpage.getContent();
		
		PageResponse bookPagination = new PageResponse();
		bookPagination.setBooks(content);
		bookPagination.setPageNumber(bookpage.getNumber());
		bookPagination.setPageSize(bookpage.getSize());
		bookPagination.setTotalElement(bookpage.getTotalElements());
		bookPagination.setTotalPages(bookpage.getTotalPages());
		bookPagination.setLastPage(bookpage.isLast());
		
		
		return bookPagination;
	}

	@Override
	public Books bookByName(String bookName) {
		Books findByBookName = this.bookRepo.findByBookName(bookName);
		return findByBookName;
	}

	@Override
	public List<Books> activeBooks() {
		List<Books> allBooks = this.bookRepo.findAll();
		List<Books> activeBooks = new ArrayList<>();
		for(Books book : allBooks)
		{
			if(book.isAvailable() == true) activeBooks.add(book);
		}
		return activeBooks;
	}
	
	

}
