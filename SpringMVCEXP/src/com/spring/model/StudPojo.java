package com.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudPojo {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	public String StudName;
	public String StudAdd;
	public String StudMail;
	public String getStudName() {
		return StudName;
	}
	public void setStudName(String studName) {
		StudName = studName;
	}
	public String getStudAdd() {
		return StudAdd;
	}
	public void setStudAdd(String studAdd) {
		StudAdd = studAdd;
	}
	public String getStudMail() {
		return StudMail;
	}
	public void setStudMail(String studMail) {
		StudMail = studMail;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public StudPojo(int id, String studName, String studAdd, String studMail) {
		super();
		this.id = id;
		StudName = studName;
		StudAdd = studAdd;
		StudMail = studMail;
	}
	public StudPojo() {
		super();
	}
	

}
