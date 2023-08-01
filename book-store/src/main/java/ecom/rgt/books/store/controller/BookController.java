package ecom.rgt.books.store.controller;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecom.rgt.books.store.dao.PageResponse;
import ecom.rgt.books.store.entity.Books;
import ecom.rgt.books.store.exception.ApiResponse;
import ecom.rgt.books.store.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/book")
	public ResponseEntity<Books> addBook(@RequestBody Books book)
	{
		Books addedBook = bookService.addBook(book);
		return new ResponseEntity<Books>(addedBook, HttpStatus.CREATED);
	}
	
	@GetMapping("/book/{bId}")
	public ResponseEntity<Books> getBook(@PathVariable("bId") Integer bid)
	{
		Books book = bookService.getBook(bid);
		return new ResponseEntity<Books>(book, HttpStatus.FOUND);
	}
	
	@GetMapping("/book")
	public ResponseEntity<PageResponse> getBooks(
			@RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize){
		PageResponse pageResponse = this.bookService.listOfBooks(pageNumber, pageSize);
		return new ResponseEntity<PageResponse>(pageResponse, HttpStatus.FOUND);
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<Books> updateBook(
			@RequestBody Books book,
			@PathVariable("id") Integer id
	){
		Books updateBook = this.bookService.updateBook(id, book);
		return new ResponseEntity<Books>(updateBook, HttpStatus.OK);
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") Integer id){
		this.bookService.deleteBook(id);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully", true), HttpStatus.OK);
	}
	
    @GetMapping("/name/{bookName}")
    public ResponseEntity<Books> getByBookName(@PathVariable("bookName") String bookName){
    	Books bookByName = this.bookService.bookByName(bookName);
    	return new ResponseEntity<Books>(bookByName, HttpStatus.OK);
    }
    
    @GetMapping("/book/active")
    public ResponseEntity<List<Books>> getActiveBooks()
    {
    	List<Books> activeBooks = this.bookService.activeBooks();
    	return new ResponseEntity<List<Books>>(activeBooks, HttpStatus.OK);
    }
}
