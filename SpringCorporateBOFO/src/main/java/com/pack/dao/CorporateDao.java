package com.pack.dao;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.pack.model.Corporate;

@Component
public class CorporateDao {

	@Autowired 
	private DataSource dataSource;
	
	public int insert(Corporate c) {
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		int i=insert.update("insert into Corporate(CorporateId,CorporateName,Address,PhoneNumber,DeleteStatus) values(?,?,?,?,?)",
				c.getCorporateId(),c.getCorporateName(),c.getAddress(),c.getPhoneNumber(),c.getDeleteStatus());
		return i;
	}
	
	public List<Corporate> viewAll()
	{
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		String sql="select * from Corporate";
		List<Corporate> corporate=insert.query(sql,new BeanPropertyRowMapper<Corporate>(Corporate.class));
		return corporate;
	}
	
	public Corporate getCorById(String corporateid){    
		JdbcTemplate obj = new JdbcTemplate(dataSource);
	    String sql="select * from Corporate where CorporateId=?";    
	    Corporate cor= obj.queryForObject(sql, new BeanPropertyRowMapper<Corporate>(Corporate.class),new Object[]{corporateid});  
	    return cor;
	     
	} 
	public int modify(Corporate c)
	{
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		int i=	insert.update("update Corporate set Address=' "+c.getAddress()+" ',PhoneNumber=' "+c.getPhoneNumber()+" ' where CorporateId="+c.getCorporateId());
		    return i;	
	}
	public int delete(int id) {
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		int i=insert.update("update Corporate set DeleteStatus=1 where CorporateId='"+id+"'");
		return i;
	}
	
}
