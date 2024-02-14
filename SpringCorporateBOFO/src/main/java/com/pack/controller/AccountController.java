package com.pack.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.dao.AccountDao;
import com.pack.model.Account;


@Controller
public class AccountController {
	@Autowired
	AccountDao accountDao;
	
	@RequestMapping("/addAccountForm")
	 public String selectcorp(Model m)  
	 {  
	     return "AccountPage/SelectCorp";  
	 }
	
	@RequestMapping("/AddnewAccount")
	 public String add(@RequestParam("corporateId")int corpid,Model m)  
	 {  
		m.addAttribute("corpid",corpid);
	     m.addAttribute("acc", new  Account());  
	     return "AccountPage/AddAccount";  
	 }
	
	 @RequestMapping(value = "/addAccount", method = RequestMethod.POST) 
	  public String addStudent(Account account) {
		 int res= accountDao.insert(account);
		 if (res>=1)
		  return "AccountPage/AddAccount-success";
		 else
			 return "AccountPage/AddAccount-error";
	   
	  }
	 @RequestMapping("/AccountView")    
	    public String viewAcc(Model m){      
	        return "AccountPage/ViewAccount";    
	    }  
	
	 @RequestMapping("/accountDeleteView")    
	    public String deleteAcc(Model m){      
	        return "AccountPage/CloseAccount";    
	    }  
	 @RequestMapping("/DeleteAccount")    
	    public String delete(@RequestParam("accountnumber") long accountnumber){    
		int res=accountDao.delete(accountnumber); 
			if (res>=1)
				  return "AccountPage/CloseAccount-success";
				 else
					 return "AccountPage/CloseAccount-error";
	         
	    }     

	 @RequestMapping("/viewAccountDetails")    
	    public String userAccdetails(@RequestParam("accountNumber")long num,Model m){   
		 m.addAttribute("accnum",num);
	        return "ViewAccounts";    
	    }  
}
