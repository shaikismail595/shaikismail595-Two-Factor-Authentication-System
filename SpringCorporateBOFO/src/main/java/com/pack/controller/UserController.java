package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.dao.UserDao;
import com.pack.model.UserSetup;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;
	@RequestMapping("/addUserForm")
	 public String selectCorp(Model m)  
	 {  
	     return "UserPage/SelectCorporate";  
	 }
	@RequestMapping("/AddnewUser")
	 public String add(@RequestParam("corporateId")int corpid,Model m)  
	 {  
		m.addAttribute("corpid",corpid);
	     m.addAttribute("usr", new  UserSetup());  
	     return "UserPage/AddUser";  
	 }
	

	 @RequestMapping(value = "/addUser", method = RequestMethod.POST) 
	  public String addStudent(UserSetup users) {
		 int res= userDao.insert(users);
		 if (res>=1)
		  return "UserPage/AddUser-success";
		 else
			 return "UserPage/AddUser-error";
	  }
	 @RequestMapping("/viewUserForm")    
	    public String viewusr(Model m){    
	        return "UserPage/ViewUser";    
	    }  
	 @RequestMapping("/ModifyView")    
	    public String modifyView(Model m){      
	        return "UserPage/UserModifyView";    
	    }  
	 @RequestMapping("/modifyUsr")  
	    public String edit( @RequestParam("userid") String userid, Model m){    
		 UserSetup usr=userDao.getUsrById(userid);
		m.addAttribute("editUsrForm",usr); 
			System.out.println("userid "+userid);	 
	        return "UserPage/ModifyUser";    
	    } 
	 @RequestMapping("/EditUser")
		public String modify(@RequestParam("usrid") String usrid,UserSetup users)
		{
		 System.out.println("userid "+usrid);
			int res=userDao.modify(users,usrid);
			if (res>=1)
				  return "UserPage/ModifyUser-success";
				 else
					 return "UserPage/ModifyUser-error";
			  			 
		}
	 @RequestMapping("/DeleteView")    
	    public String deleteView(Model m){     
	        return "UserPage/DeleteUser";    
	    }
	 @RequestMapping("/deleteUsr")    
	    public String delete( @RequestParam("userid") String userid){    
		int res=userDao.delete(userid); 
			if (res>=1)
				  return "UserPage/Deleteuser-success";
				 else
					 return "UserPage/DeletUser-error";
	         
	    }     
}
