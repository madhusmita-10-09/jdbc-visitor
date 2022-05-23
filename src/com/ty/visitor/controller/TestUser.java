package com.ty.visitor.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.visitor.dao.UserDao;
import com.ty.visitor.dto.User;
import com.ty.visitor.dto.Visitor;

public class TestUser {
	public static void main(String[] args) {
		User user= new User();
		
		user.setId(4);
		user.setName("Nitish");
		user.setEmail("nitish@gmail.com");
		user.setPassword("mechanical engineer");
		user.setPhone(984545678);
		user.setRole("developer");
		UserDao dao = new UserDao();
		
		int res=dao.saveUser(user);
		if(res>0)
		{
			System.out.println("Data inserted");
		}
		else
		{
			System.out.println("NO data found");
		}
		//CHECK PASSWORD IS CORRECT OR NOT//
			
	}

}
