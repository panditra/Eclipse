package com.rajwork.BootMVCDB.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rajwork.BootMVCDB.model.Employee;
import com.rajwork.BootMVCDB.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
	    //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    dateFormat.setLenient(false);
	    webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
//	@RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
	@RequestMapping(value = "/")
	public ModelAndView get() {
		ModelAndView mav = new ModelAndView("employeesList");
		List<Employee> list = employeeService.get();
	//	java.util.Iterator<Employee> itr = list.iterator();
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			Employee e = (Employee) itr.next();
			//System.out.println(e.getDepartment());
			System.out.println(e.getDepartment());
		}
		for(Employee e:list) {
			System.out.println(e.getName());
			}
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/openEmployeeView")
	public ModelAndView openEmployeeAddView() {
		ModelAndView mav = new ModelAndView("employeesAdd");
		mav.addObject("employee", new Employee());
		return mav;
	}
	
	@RequestMapping("/save")
	/*
	 * public ModelAndView save( @ModelAttribute("employee") @Valid Employee
	 * employee,BindingResult bindingResult) { if (bindingResult.hasErrors()) {
	 * ModelAndView mav = new ModelAndView("employeesAdd");
	 * mav.addObject("employee", new Employee()); return mav; } ModelAndView mav =
	 * new ModelAndView("employeesList"); employeeService.save(employee);
	 * List<Employee> list = employeeService.get(); mav.addObject("list", list);
	 * return mav; }
	 */
	public String save( @ModelAttribute("employee") @Valid Employee employeeobj,BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			/*
			 * ModelAndView mav = new ModelAndView("employeesAdd");
			 * mav.addObject("employee", new Employee());
			 */
			return "employeesAdd";
	      }
		ModelAndView mav = new ModelAndView("employeesList");
		employeeService.save(employeeobj);
		List<Employee> list = employeeService.get();
		mav.addObject("list", list);
		
		  model.addAttribute("name", employeeobj.getName());
	      model.addAttribute("gender", employeeobj.getGender());
	      model.addAttribute("id", employeeobj.getId());
	      model.addAttribute("department", employeeobj.getDepartment());
	      model.addAttribute("dob", employeeobj.getDob());
	      

		return "employeesList";
	}
	
	@RequestMapping("/employee/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("employeesAdd");
		Employee employeeObj = employeeService.get(id);
		if(employeeObj == null) {
			throw new RuntimeException("Employee not found"+id);
		}
		mav.addObject("employee", employeeObj);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("employeesList");
		employeeService.delete(id);
		List<Employee> list = employeeService.get();
		mav.addObject("list", list);
		return mav;
	}
}