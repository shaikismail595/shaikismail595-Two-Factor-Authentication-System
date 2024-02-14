package com.pack.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pack.model.UserSetup;

@Component
public class UserDao {

	@Autowired 
	private DataSource dataSource;
	
	public int insert(UserSetup u)
	{
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		int i=insert.update("insert into UserSetup(CorporateId,UserID,UserPassword,Department,Address,PhoneNumber,DeleteStatus,NewUser) values(?,?,?,?,?,?,?,?)"
				,u.getCorporateId(),u.getUserId(),u.getUserPassword(),u.getDepartment(),u.getAddress(),u.getPhoneNumber(),u.getDeleteStatus(),u.getNewUser());
		return i;
	}
	
	public List<UserSetup> viewAll()
	{
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		String sql="select * from UserSetup where DeleteStatus=0";
		List<UserSetup> users=insert.query(sql,new BeanPropertyRowMapper<UserSetup>(UserSetup.class));
		return users;
	}
	public UserSetup getUsrById(String userid){    
		JdbcTemplate obj = new JdbcTemplate(dataSource);
	    String sql="select * from UserSetup where UserID=?";    
	    UserSetup usr= obj.queryForObject(sql, new BeanPropertyRowMapper<UserSetup>(UserSetup.class),new Object[]{userid});  
	    return usr;
	  
	    
	} 

	public int  modify(UserSetup u,String usrid) {
		   	 	
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		int i=insert.update("update UserSetup set Department='"+u.getDepartment()+"',Address='"+u.getAddress()+"',PhoneNumber='"+u.getPhoneNumber()+"' where UserID='"+usrid+"'");
	    return i;	
			} 
	public int delete(String userid) {
	   	 	
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		int i=insert.update("update UserSetup set DeleteStatus=1 where UserID='"+userid+"'");
		return i;
		 
	} 

}
