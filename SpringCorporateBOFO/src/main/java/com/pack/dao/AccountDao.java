package com.pack.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import com.pack.model.Account;

@Component
public class AccountDao {
	@Autowired 
	private DataSource dataSource;
	
	public int insert(Account a)
	{
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		int i=insert.update("insert into Account(CorporateId,AccountNumber,AccountName,Currency,Branch,AvBalance,Status) values(?,?,?,?,?,?,?)",a.getCorporateId(),a.getAccountNumber(),a.getAccountName(),a.getCurrency(),a.getBranch(),a.getAvBalance(),a.getStatus());
		return i;
	}
	
	public List<Account> viewAll()
	{
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		String sql="select * from account";
		List<Account> accounts=insert.query(sql,new BeanPropertyRowMapper<Account>(Account.class));
		return accounts;
	}
	
	public int delete(long accountnumber) {
	   	 String value="Closed";	
		JdbcTemplate insert = new JdbcTemplate(dataSource);
		int i=insert.update("update Account set Status='"+value+"' where AccountNumber='"+accountnumber+"'");
		return i;
		 
	} 	

}
