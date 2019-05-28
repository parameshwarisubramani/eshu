package com.spring.dao;

import java.util.List;


import com.spring.model.StudPojo;

public interface Studdao {
	public boolean save(StudPojo s) ;
	public List<StudPojo> viewAll();
	public void delete(int id);
	public List<StudPojo> viewbyid(StudPojo emp);
}
