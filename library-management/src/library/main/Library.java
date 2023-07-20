package library.main;

import java.util.Scanner;

/**
 * 
 * @author Bharat
 *
 */
public class Library{
	
	public static void main(String[] args) {
		String title="";
		String author="";
		String patron="";
		
		LibraryServices services = new LibraryServices();
		
		int choice = -1;
		do {
			System.out.println("1. Add Book");
			System.out.println("2. Add Patron");
			System.out.println("3. Borrow Book");
			System.out.println("4. Return Book");
			System.out.println("5. Exit");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter choice : ");
			choice = sc.nextInt();
			
			switch(choice) {
			//add book
			case 1:
				sc.nextLine();
				System.out.println("Enter Title : ");
				title = sc.nextLine();
				
				System.out.println("Enter author : ");
				author = sc.nextLine();
				
				services.addBook(title, author);
				break;
				
			//add patron
			case 2:
				sc.nextLine();
				System.out.println("Enter patron name : ");
				patron = sc.nextLine();
				services.addPatron(patron);
				break;
				
			//borrow book
			case 3:
				sc.nextLine();
				System.out.println("Enter patron name : ");
				patron = sc.nextLine();
				
				System.out.println("Enter book title : ");
				title = sc.nextLine();
				services.borrowBook(patron, title);
				break;
			
			//return book
			case 4:
				sc.nextLine();
				System.out.println("Enter patron name : ");
				patron = sc.nextLine();
				System.out.println("Enter book title : ");
				title = sc.nextLine();
				services.returnBook(patron, title);
				break;
			
			//exit
			case 5:
				sc.close();
				System.out.println("thanks for visit!!");
				break;
				
			default:
				choice = -1;
			}
		}
		while(choice!=5);
	}

}
