package com.nehal.libraryProject;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class borrowerController {
	
	@Autowired
	borrowerRepo repo;
	@Autowired
	borrowersService service;
	
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("/borrowers")
	@ResponseBody
	public List<borrowers> getBorrowers() {
		return repo.findAll();
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("borrower/{borrowerid}")
	public borrowers getBorrower(@PathVariable("borrowerid") int borrowerid) {
		return repo.findById(borrowerid).orElse(new borrowers(0,"",""));
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping("/borrower")
	public borrowers addBorrower(borrowers borrower) {
		repo.save(borrower);
		return borrower;
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@GetMapping("borrowers/borrowedbooks/{borrowerid}")
	public List<books> getBorrowedbooks(@PathVariable("borrowerid") int borrowerid) {
		return service.borrowedBooks(borrowerid);
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping(value="borrowers/borrowbook", consumes="application/json")
	public ResponseEntity<books> borrowBook(@RequestBody HashMap<String,String>requestData) {
		System.out.println(requestData.get("booktitle")+" "+requestData.get("borrowerid"));
		return service.borrowBook(requestData.get("booktitle"),Integer.parseInt(requestData.get("borrowerid")));
	}
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping(value="borrowers/returnbook")
	public ResponseEntity<books> returnbook(@RequestBody HashMap<String,String>requestData) {
		return service.returnBook(Integer.parseInt(requestData.get("bookid"))); 
		}
}
