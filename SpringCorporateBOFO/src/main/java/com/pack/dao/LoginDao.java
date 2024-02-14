package com.pack.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pack.model.Admin;
import com.pack.model.Corporate;

@Component
public class LoginDao {

	@Autowired 
	private DataSource dataSource;
	
	public String valid(String id,String password) {
		JdbcTemplate obj = new JdbcTemplate(dataSource);
		String m1="";
		String s1="update Admin set AdminId='"+id+"',AdminPassword='"+password+"' where AdminId='"+id+"' and AdminPassword='"+password+"'";
		int i=obj.update(s1);
		System.out.println(i);
		if(i>=1) {
		m1="admin";
		}
		else {
			String s2="update UserSetup set userID='"+id+"',userPassword='"+password+"' where userID='"+id+"' and UserPassword='"+password+"'";
			int j=obj.update(s2);
			System.out.println(j);
			if(j>=1) {
				m1="user";
			}
		}
		return m1;
		
	}
}
