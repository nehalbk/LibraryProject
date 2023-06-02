package com.nehal.libraryProject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
public interface borrowerRepo extends JpaRepository<borrowers,Integer>{

	List<borrowers> findAllByBorrowerid(int bookid);

}
