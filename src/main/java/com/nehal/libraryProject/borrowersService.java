package com.nehal.libraryProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.*;

@Service
public class borrowersService {
	
	@Autowired
	 borrowerRepo borrowerRepo;
	@Autowired
	 booksRepo booksRepo;
	
	public ResponseEntity<books> borrowBook(String booktitle,Integer borrowerid) {
		System.out.println(booktitle+" "+borrowerid);
		System.out.println(booksRepo.countByBorrowerid(borrowerid));
		if(booksRepo.countByBorrowerid(borrowerid)>2) {
//			return "You have reached book limit! Please return a book first!";
			return new ResponseEntity("Maximum books borrowed! Please return a book first",HttpStatus.UNAUTHORIZED);
			}
		else {
			try {
				List<Integer> freeBookid=booksRepo.getFreeBook(booktitle);
				System.out.println(freeBookid+" "+booktitle);
				if(freeBookid.size()>0) {
					booksRepo.updateBooksByBooktitle(borrowerid, freeBookid.get(0));
					return new ResponseEntity("Book Borrowed Successfully",HttpStatus.OK);}
				else
					return new ResponseEntity("Book not available",HttpStatus.NOT_FOUND);
			}
			catch(Exception e) {
				System.out.println(e);
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
		}
		
	}
	
	public ResponseEntity<books> returnBook(Integer bookid) {
		try {
			Integer updated=booksRepo.returnBook(bookid);
			if(updated>0)
			return new ResponseEntity("Book returned",HttpStatus.OK);
			else
				return new ResponseEntity("Invalid book Id",HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity("Error returning book",HttpStatus.BAD_REQUEST);
		}
	}
	
	public List<books> borrowedBooks(int borrowerid) {
		List<books> borrowedBooks = booksRepo.findAllByBorrowerid(borrowerid);
		return borrowedBooks;
	}

}
