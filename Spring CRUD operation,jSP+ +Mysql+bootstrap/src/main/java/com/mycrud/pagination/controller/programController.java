package com.mycrud.pagination.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycrud.pagination.DAO.PartsDAO;
import com.mycrud.pagination.model.Parts;

@Controller

public class programController {
	
	
	@Autowired
	private PartsDAO partsdao;
	
	

    @RequestMapping( value="/insert", method=RequestMethod.GET)
    public  String  newRegistration(ModelMap model) {
    	
    	Parts parts= new Parts();
    	model.addAttribute("parts",parts);
    	return "enter";
    	
    	
    }
    @RequestMapping(value="/listallparts", method=RequestMethod.GET)
    public ModelAndView getall(){
    	
    	
    	List<Parts> allparts= partsdao.getAllParts();
    	return new ModelAndView("allparts", "listall", allparts);       // (viewname, modelname, modelobject)//
    	
    }
    
    @RequestMapping(value= "/save" , method=RequestMethod.POST)
    public String   save(@Valid Parts parts, BindingResult result, ModelMap Model, RedirectAttributes redirectAttributes) {
    	
    	
    	if(result.hasErrors()) {
    		return "enter";
    	}
    	else {
    		partsdao.save(parts);
    		return "redirect:/listallparts";
    		
    	}
    	
    }
    @RequestMapping(value="/edit/{id}",method= RequestMethod.GET)
    public String editRecord(@PathVariable int id,ModelMap model) 
    {
    	Parts parts=partsdao.getpartsbyID(id);
    	model.addAttribute("parts2",parts);
    	return "editpart";
    	
    	
    }
    @RequestMapping(value= "/edit/{id}" , method=RequestMethod.POST)
    public String   editsave(@Valid Parts parts,@PathVariable int id, BindingResult result, ModelMap Model, RedirectAttributes redirectAttributes) {
    	
    	
    	if(result.hasErrors()) {
    		return "editpart";
    	}
    	else {
    		partsdao.Update(parts,id);
    		return "redirect:/listallparts";
    		
    	}
    	
    }
    
    @RequestMapping(value="/deletepart/{id}", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id) 
    {
    	partsdao.delete(id);
    	return new ModelAndView("redirect:/listallparts");
    	
    	
    } 
    @RequestMapping(value ="/deleteparts/All",method= RequestMethod.GET)
    public ModelAndView delete() 
    {
    	partsdao.deleteAll();
    	return new ModelAndView("redirect:/listallparts");
    	
    	
    } 
    
	

}
