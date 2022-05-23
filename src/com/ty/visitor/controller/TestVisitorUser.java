package com.ty.visitor.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.visitor.dao.VisitorDao;
import com.ty.visitor.dto.Visitor;

public class TestVisitorUser {
	public static void main(String[] args) {
		VisitorDao dao = new VisitorDao();
		Visitor visitor = new Visitor();
		List<Visitor> l = new ArrayList<>();
		
		visitor.setAge(23);
		visitor.setDob("1997-03-28");//localdate.now
		visitor.setEmail("sundeep@gmail.com");
		visitor.setGender("m");
		visitor.setId(2);
		visitor.setName("sundeep");
		visitor.setPhone("876543349");
		visitor.setVisitdatetime("2022-07-23");//localdate.now
		dao.saveVisitor(visitor);
		
//		Visitor v = dao.getVisitorById(3);
//		System.out.println(v);
		
//		l= dao.getVisitorByDate("2022-04-29");
//		System.out.println(l);
		
//		l = dao.getVisitorByAgeRange(20, 25);
//		System.out.println(l);
	}

}
