package ecom.rgt.books.store.dao;

import java.util.List;

import ecom.rgt.books.store.entity.Books;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageResponse {
	
	private List<Books> listOfBooks;
	
	private Integer PageNumber;
	
	private Integer PageSize;
	
	private boolean isLastPage;
	
	private Long totalElement;
	
	private Integer totalPages;
}
