package com.nehal.libraryProject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public interface booksRepo extends JpaRepository<books, Integer>{
	
	List<books> findByBookid(int bookid);
	long countByBorrowerid(int borrowerid);
	List<books> findAllByBorrowerid(int bookid);
	
	@Transactional
	@Modifying
	@Query("UPDATE books SET borrowerid = :borrowerid WHERE bookid = :bookid")
	Integer updateBooksByBooktitle(int borrowerid, int bookid); 
	
	
	@Query("Select bookid from books WHERE booktitle = :booktitle AND borrowerid IS NULL")
	List<Integer> getFreeBook(String booktitle); 

	@Transactional
	@Modifying
	@Query("update books set borrowerid = null where bookid = :bookid and borrowerid IS not NULL")
	Integer returnBook(int bookid);

}
