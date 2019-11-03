package com.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Users;
import com.servicesapi.UsersService;

@Controller
@RequestMapping("users")

public class UsersController {
	
	@Autowired
	UsersService userServices;
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ModelAndView getPage(){
		ModelAndView view =new ModelAndView("users");
		return view;
	}
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(Users users){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(userServices.saveOrUpdate(users)){
			map.put("status","200");
			map.put("message","Your record have been saved successfully");
		}
		
		return map;
	}
	/*@RequestMapping(value ="/login" ,method=RequestMethod.GET)
	public String loginPage(Model model){
		model.addAttribute("studentCredential", new Users());
		return "login";
	}*/
	/*// Get All Users
		@RequestMapping(value = "/allUsers", method = RequestMethod.POST)
		public ModelAndView displayAllUser() {
			System.out.println("User Page Requested : All Users");
			ModelAndView mv = new ModelAndView();
			List userList = userServices.getAllUsers();
			mv.addObject("userList", userList);
			mv.setViewName("allUsers");
			return mv;
		}*/
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView getLogin(Users users){
		ModelAndView view =new ModelAndView("users");
		//return view;
		Map<String,Object> map = new HashMap<String,Object>();
	//	
			List<Users> list = userServices.list();
			ModelAndView modelAndView = new ModelAndView("welcome");
			if (list != null){
				map.put("status","200");
					map.put("message","Data found");
				map.put("data", list);
				
				//Users student = getStudentService()
				modelAndView.addObject("student", users);
				return modelAndView;
				}else{
				/*map.put("status","404");
				map.put("message","Data not found");*/
				modelAndView = new ModelAndView("notFound");
			}
	
		return modelAndView;
		
	}
	
	//@RequestMapping(value="/login", method=RequestMethod.POST)
//	public ModelAndView getAll(Users users){
//		Map<String,Object> map = new HashMap<String,Object>();
//	
//			List<Users> list = userServices.list();
//			ModelAndView modelAndView = new ModelAndView("welcome");
//			if (list != null){
//				map.put("status","200");
//				map.put("message","Data found");
//				map.put("data", list);
//				
//				//Users student = getStudentService()
//				modelAndView.addObject("student", users);
//				return modelAndView;
//			}else{
//				/*map.put("status","404");
//				map.put("message","Data not found");*/
//				modelAndView = new ModelAndView("notFound");
//			}
//		
//		return modelAndView;
//	}
	/*@RequestMapping(value ="/loginSuccess" ,method=RequestMethod.POST)
	public ModelAndView loginSuccess(@Valid @ModelAttribute("studentCredential") Users studentCredential,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return new ModelAndView("login");
		}
		ModelAndView modelAndView = new ModelAndView("welcome");
		Student student = getStudentService().validateStudentCredential(studentCredential.getEmail(), studentCredential.getPassword());
		if(student!= null){
			modelAndView.addObject("student", student);
			return modelAndView;
		}else{
			 modelAndView = new ModelAndView("notFound");
		}
		return modelAndView;
	}*/
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> delete(Users users){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(userServices.delete(users)){
			map.put("status","200");
			map.put("message","Your record have been deleted successfully");
		}
		
		return map;
	}
	
	
}
