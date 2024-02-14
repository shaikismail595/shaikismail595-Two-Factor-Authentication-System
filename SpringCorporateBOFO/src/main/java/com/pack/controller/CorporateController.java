package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.dao.CorporateDao;
import com.pack.model.Corporate;

@Controller
public class CorporateController {
@Autowired
CorporateDao corporateDao;
@RequestMapping("/HomePage")
public String home(Model m)  
{  
    return "Home";  
}

public String add(Model m)  
{  
    m.addAttribute("cor", new  Corporate());  
    return "CorporatePage/AddCorporate";  
}

@RequestMapping(value = "/addCorporate", method = RequestMethod.POST) 
public String addStudent(Corporate corporate) {
	 int res= corporateDao.insert(corporate);
	 if (res>=1)
	  return "CorporatePage/addCorporate-success";
	 else
		 return "CorporatePage/addCorporate-error";
 
}

@RequestMapping("/viewCorporateList")    
public String viewusr(Model m){      
    return "CorporatePage/viewCorporate";    
} 

@RequestMapping("/modifyViewList")    
public String modifyusr(Model m){    
    return "CorporatePage/Modifyview";    
} 
@RequestMapping("/modifyCorp")  
public String edit( @RequestParam("corporateid") String corporateid, Model m){    
	 
Corporate cor=corporateDao.getCorById(corporateid);
m.addAttribute("editCorForm",cor);
	 
	System.out.println("corporateid "+corporateid);
	 
    return "CorporatePage/ModifyCorporate";    
} 

@RequestMapping("/editCorporate")
public String modify(Corporate corporate)
{
	int res=corporateDao.modify(corporate);
	if (res>=1)
		  return "CorporatePage/Modify_success";
		 else
			 return "CorporatePage/Modify_error";
	  			 
}


@RequestMapping("/deleteViewList")    
public String deleteusr(Model m){      
    return "CorporatePage/deleteview";    
} 
@RequestMapping("/deleteCorporate")  
public String delete( @RequestParam("corporateid") int corporateid){    
	int res=corporateDao.delete(corporateid); 
	if (res>=1)
		  return "CorporatePage/Delete_success";
		 else
			 return "CorporatePage/deleteview";
     
} 
}
