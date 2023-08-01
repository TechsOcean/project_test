package library.main;

/**
 * @author Bharat
 *
 */
public class LibraryServices {
	private int MAX_BOOKS = 100;  	//represent the no. of books that can be added.
	private int MAX_PATRONS = 10; 	//represent the no. of patrons that can be added.
	
	/*
	 * books[0]		books[1]	  books[2]
	 * title		author		  borrower name/null;
	 * 
	 */
	private String[][] books = new String[MAX_BOOKS][3];
	private String[] patrons = new String[MAX_PATRONS];
	
	private int bookCount = 0;			//keep track of no. of books.
	private int patronCount = 0;		//keep track of no. of patrons.
	
	
	//utility function to display : [book title], [author name], [book borrowed by]/null
	public void displayBooks()
	{
		for(int i=0;i<bookCount;i++)
		{
			System.out.println(books[i][0]+", "+books[i][1]+", "+books[i][2]);
		}
	}
	
	//utility function, return the index on which the book with given title exist in the array, if not found return -1;
	private int bookFindByTitle(String bookTitle)
	{
		for(int i=0;i<bookCount;i++)
		{
			if(books[i][0].equals(bookTitle)) 
			{
				return i;
			}
		}
		return -1;
	}
	
	//utility function, return true is given patron exist, else false;
	private boolean patronExist(String patron)
	{
		boolean isPatronExist = false;
		for(int i=0;i<patronCount;i++)
		{
			if(patrons[i].equals(patron))
			{
				isPatronExist = true;
				return isPatronExist;
			}
		}
		return isPatronExist;
	}
	
	
	public void addBook(String title, String author)
	{
		if(bookCount<MAX_BOOKS) {
			books[bookCount][0] = title;
			books[bookCount][1] = author;
			books[bookCount][2] = null;
			bookCount++;
			System.out.println("Book with Title: "+title+", author: "+author+" added successfully!");
		}
		else {
			System.out.println("can't add this book, shelves are full");
		}
	}
	
	public void addPatron(String name)
	{
		if(patronCount<MAX_PATRONS){
			patrons[patronCount++] = name;
			System.out.println("patron added successfully!");
		}
		else {
			System.out.println("can't add patron, max patron limit reach!!");
		}
	}
	
	public void borrowBook(String patron, String bookTitle)
	{
		if(!patronExist(patron))
		{
				System.out.println("Patron not exist..");
				return;
		}
		
		int bookIdx = bookFindByTitle(bookTitle);
		if(bookIdx < 0)
		{
			System.out.println("Book not found with title : \""+bookTitle+"\"");
			return;
		}
		else {
			if(books[bookIdx][2] == null)
			{
				books[bookIdx][2] = patron;
				System.out.println("book borrowed successfully!!");
				return;
			}
			else {
				System.out.println("book already borrowed by someone.");
				return;
			}
		}
	}
	
	public void returnBook(String patron, String bookTitle)
	{
		if(!patronExist(patron))
		{
			System.out.println("patron not exist!!");
			return;
		}
		
		int bookIdx = bookFindByTitle(bookTitle);
		if(bookIdx<0)
		{
			System.out.println("Book not found with title : \""+bookTitle+"\"");
			return;
		}
		else {
			if(books[bookIdx][2].equals(patron))
			{
				books[bookIdx][2] = null;
				System.out.println("book returned successfully!!");
				return;
			}
			else {
				System.out.println("Book with title \""+bookTitle+"\" is not borrowed by \""+patron+"\"");
			}
		}
	}
}
