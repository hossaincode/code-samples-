package com.mycrud.pagination.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;


// @ annotation for spring hibernate 
public class Parts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int  ID;
	@NotNull
	private String PRODUCT_NAME;
	
	@NotNull
	private String PRODUCR_DESCIPTION;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past @NotNull
	private Date DATE_ENTERED;
	
	@Email @NotEmpty
	private String email;
	@NotNull
	private String COUNTRY_MANUFACTUR;
	
	
	
	@NotNull
	private  String SUBJECTS;
	
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public String getPRODUCR_DESCIPTION() {
		return PRODUCR_DESCIPTION;
	}

	public void setPRODUCR_DESCIPTION(String pRODUCR_DESCIPTION) {
		PRODUCR_DESCIPTION = pRODUCR_DESCIPTION;
	}

	public  Date getDATE_ENTERED() {
		return DATE_ENTERED;
	}

	public void setDATE_ENTERED(Date dATE_ENTERED) {
		DATE_ENTERED = dATE_ENTERED;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCOUNTRY_MANUFACTUR() {
		return COUNTRY_MANUFACTUR;
	}

	public void setCOUNTRY_MANUFACTUR(String cOUNTRY_MANUFACTUR) {
		COUNTRY_MANUFACTUR = cOUNTRY_MANUFACTUR;
	}

	

	public String getSUBJECTS() {
		return SUBJECTS;
	}

	public void setSUBJECTS(String sUBJECTS) {
		SUBJECTS = sUBJECTS;
	}

	

}
