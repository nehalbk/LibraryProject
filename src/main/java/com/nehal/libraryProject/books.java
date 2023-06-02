package com.nehal.libraryProject;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class books {
	@Id
	private Integer bookid;
	private String  booktitle;
	private String bookauthor;
	private Integer bookprice;
	private Integer borrowerid ;
	
	public books() {
	}

	public books(Integer bookid, String booktitle, String bookauthor, Integer bookprice, Integer borrowerid) {
		super();
		this.bookid = bookid;
		this.booktitle = booktitle;
		this.bookauthor = bookauthor;
		this.bookprice = bookprice;
		this.borrowerid = borrowerid;
	}

	public Integer getbookid() {
		return bookid;
	}

	public void setbookid(Integer bookid) {
		this.bookid = bookid;
	}

	public String getbooktitle() {
		return booktitle;
	}

	public void setbooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getbookauthor() {
		return bookauthor;
	}

	public void setbookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public Integer getbookprice() {
		return bookprice;
	}

	public void setbookprice(Integer bookprice) {
		this.bookprice = bookprice;
	}

	public Integer getborrowerid() {
		return borrowerid;
	}

	public void setborrowerid(Integer borrowerid) {
		this.borrowerid = borrowerid;
	}

	@Override
	public String toString() {
		return "books [bookid=" + bookid + ", booktitle=" + booktitle + ", bookauthor=" + bookauthor
				+ ", bookprice=" + bookprice + ", borrowerid=" + borrowerid + "]";
	}
	
	
	
}
