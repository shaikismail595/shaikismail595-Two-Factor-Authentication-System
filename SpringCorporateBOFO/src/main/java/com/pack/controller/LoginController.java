package com.pack.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.dao.LoginDao;
import com.pack.model.Admin;
import com.pack.model.Corporate;
import com.pack.model.UserSetup;

@Controller
public class LoginController {
	@Autowired
	LoginDao logindao;
	@RequestMapping(value="/admin", method = RequestMethod.POST) 
	public String addStudent(@RequestParam("adminId")String id,@RequestParam("adminPassword")String pass,Model m) {
		
		System.out.println(id+" "+pass);
		String res="";
		   res=res+logindao.valid(id,pass); 
		  System.out.println(res);
		  m.addAttribute("userid", id);
		 if(res.equals("user"))
			 return "FrontOfficeHomepage";
		 else if(res.equals("admin"))
			return "Home";
		 else
			return "LoginError";
	
}
	@RequestMapping("/logout")
    public String logoutDo(Model m)
    {
        return "index";
    }

}