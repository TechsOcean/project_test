API endpoints : 
	base url : http://localhost:8080
	
----------------------------------------------------------------------------------

post		http://localhost:8080/api/book				//add a book
			request body:
				{
					"bookName": "ruby",
					"authorName": "bharat",
					"available": true
				}

get			http://localhost:8080/api/book/{bId}		//get book by book id
get			http://localhost:8080/api/book				//get list of all books
put			http://localhost:8080/api/book/{bId}		//update an existing book
			request body:
				{
					"bookName": "ruby",
					"authorName": "bharat",
					"available": true
				}
				
delete		http://localhost:8080/api/book/{bId}		//delete a book by book id.
get		http://localhost:8080/api/name/{bookName}	//get a book by bookName.
get		http://localhost:8080/api/book/active		//return the list of active books.
