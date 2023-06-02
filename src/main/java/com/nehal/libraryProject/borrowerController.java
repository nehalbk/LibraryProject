package com.nehal.libraryProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class borrowerController {
	
	@Autowired
	borrowerRepo repo;
	@Autowired
	borrowersService service;
	
	@GetMapping("/borrowers")
	@ResponseBody
	public List<borrowers> getBorrowers() {
		return repo.findAll();
	}
	
	@GetMapping("borrower/{borrowerid}")
	public borrowers getBorrower(@PathVariable("borrowerid") int borrowerid) {
		return repo.findById(borrowerid).orElse(new borrowers(0,"",""));
	}
	
	@PostMapping("/borrower")
	public borrowers addBorrower(borrowers borrower) {
		repo.save(borrower);
		return borrower;
	}
	
	@GetMapping("borrowers/borrowedbooks/{borrowerid}")
	public List<books> getBorrowedbooks(@PathVariable("borrowerid") int borrowerid) {
		return service.borrowedBooks(borrowerid);
	}
	
	@PostMapping("borrowers/borrowbook")
	public ResponseEntity<books> borrowBook(@RequestParam String booktitle,@RequestParam Integer borrowerid) {
		return service.borrowBook(booktitle,borrowerid);
	}
	
	@PostMapping("borrowers/returnbook")
	public ResponseEntity<books> returnbook(@RequestParam Integer bookid) {
		return service.returnBook(bookid); 
		}
}
