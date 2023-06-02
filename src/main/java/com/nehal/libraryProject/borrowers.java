package com.nehal.libraryProject;



import jakarta.persistence.*;


@Entity
public class borrowers {
	@Id
	private int borrowerid;
	private String borrowername;
	private String borrowerclass;
	
	public borrowers() {}
	
	public borrowers(int borrowerid, String borrowername, String borrowerclass) {
		super();
		this.borrowerid = borrowerid;
		this.borrowername = borrowername;
		this.borrowerclass = borrowerclass;
	}
	public int getborrowerid() {
		return borrowerid;
	}
	public void setborrowerid(int borrowerid) {
		this.borrowerid = borrowerid;
	}
	public String getborrowername() {
		return borrowername;
	}
	public void setborrowername(String borrowername) {
		this.borrowername = borrowername;
	}
	public String getborrowerclass() {
		return borrowerclass;
	}
	public void setborrowerclass(String borrowerclass) {
		this.borrowerclass = borrowerclass;
	}

	@Override
	public String toString() {
		return "borrowers [borrowerid=" + borrowerid + ", borrowername=" + borrowername + ", borrowerclass="
				+ borrowerclass + "]";
	}
	
	
	
}
