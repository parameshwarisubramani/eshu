package com.spring.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.daoImpl.StudDaoImpl;
import com.spring.model.Login;
import com.spring.model.StudPojo;

@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping("/")
	public String A() {
		System.out.println("I'm in Index Page");
		return "index";
	}
	
	@RequestMapping("/Validation")
	public String B(@ModelAttribute ("t") Login l) {
		String user=l.getUsername();
		String pass=l.getPassword();
		if(user.equals("Admin") && pass.equals("124")) {
			System.out.println("I'm in validation");
			return "Admin";
		}
		else {
		return "error";
		}
	}
	@RequestMapping("/RegisterSave")
	public String C(@ModelAttribute ("v") StudPojo s) {
		System.out.println("Saving Process");
		StudDaoImpl q=new StudDaoImpl();
		q.save(s);
		return "Regis";
		
	}
	@RequestMapping("/viewStud")
	public ModelAndView view()
	{
		StudDaoImpl i=new StudDaoImpl();
	List<StudPojo> l=i.viewAll();
	Iterator t=l.iterator();
	while(t.hasNext()) {
		Object o=t.next();
		StudPojo s=(StudPojo)o ;
		
		System.out.println(s.StudAdd) ;
		System.out.println(s.StudMail) ;
		System.out.println(s.StudName) ;
	}
	return new ModelAndView("ViewStud","a",l);
	}

@RequestMapping("/delete/{id}")
public ModelAndView approve(@PathVariable int id) {
	
	StudDaoImpl a = new StudDaoImpl();
	a.delete(id);
	System.out.println("deleted");
	String s="Successfully deleted!";
	return new ModelAndView("ViewStud","b",s);
}
@RequestMapping("/edit/{id}")
public ModelAndView edit(@PathVariable int id) {
	
	StudDaoImpl a = new StudDaoImpl();
	
	System.out.println("deleted");
	String s="Successfully deleted!";
	return new ModelAndView("ViewStud","b",s);
}
@RequestMapping("/viewbyidpage")
public String vvv() {
	System.out.println("I'm in Index Page");
	return "viewbyidpage";
}
@RequestMapping("/viewbyid")
public ModelAndView viewbyid(@ModelAttribute("t") StudPojo s) {
	
	StudDaoImpl a = new StudDaoImpl();
	List<StudPojo> p=a.viewbyid(s);
	System.out.println("viewbyid");
	Iterator i=p.iterator();
	while(i.hasNext()) {
		StudPojo d=(StudPojo)i.next();
		System.out.println(d.getStudAdd());
		System.out.println(d.getStudName());
	}
		return new ModelAndView("ViewbyidStud","a",p);
}



}
