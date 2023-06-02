package com.nehal.libraryProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class booksController {
	
	@Autowired
	booksRepo repo;
	
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping(value="/books",produces = { "application/json" })
	@ResponseBody
	public List<books> getBooks(){
		return repo.findAll();
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("/books/{bookid}")
	@ResponseBody
	public books getBook(@PathVariable int bookid){
		return repo.findById(bookid).orElse(new books(bookid,"Book not found","Book not found",(Integer)null,(Integer)null));
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping(value="/book", consumes= { "application/json",	"application/x-www-form-urlencoded" })
	@ResponseBody
	public ResponseEntity<books> addBook(@RequestBody books book){
		System.out.println(book);
		if(repo.findById(book.getbookid()).orElse(null)==null) {
			repo.save(book);
			return new ResponseEntity<books>(book, HttpStatus.OK);
		}
		else return new ResponseEntity<books>(book,HttpStatus.CONFLICT);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@DeleteMapping("/book/{bookid}")
	public ResponseEntity deletebook(@PathVariable int bookid){
		
		if(repo.findById(bookid).orElse(null)==null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		else {
			repo.deleteById(bookid);
			return new ResponseEntity( HttpStatus.OK);
		}
		
	}
	
	@PutMapping("/book")
	@ResponseBody
	public ResponseEntity<String> modifyBook(books book){
		if(repo.findById(book.getbookid()).orElse(null)!=null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book doesn't exist!");
		}
		else {
			repo.save(book);
			return ResponseEntity.status(HttpStatus.OK).body("Book modified");
		}
	}
}
