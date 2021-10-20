package com.rajwork.BootMVCDB;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rajwork.BootMVCDB.controller.EmployeeController;
import com.rajwork.BootMVCDB.model.Employee;
import com.rajwork.BootMVCDB.service.EmployeeService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@SpringBootTest
class BootMvcdbApplicationTests {

	@Test
	void contextLoads() {
	}
	//code for testing
	@InjectMocks
	private EmployeeController employeeController;

	private MockMvc mockMvc;
	@Mock
	private EmployeeService employeeService;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}

	@Test
	public void testCreateSignupFormInvalidUser() throws Exception {
		Employee emp = new Employee();
		emp.setId(5);
		emp.setDepartment("IT");
		emp.setDob(Date.valueOf("1980-04-09"));
		emp.setGender("Male");
		emp.setName("RT");
	
		Employee emp2 = new Employee();
		emp2.setId(6);
		emp2.setDepartment("ITt");
		emp2.setDob(Date.valueOf("1990-04-09"));
		emp2.setGender("Male");
		emp2.setName("RTR");
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(emp);
		list.add(emp2);
		System.out.println("SIZE:"+list.size());
		for(Employee e:list) {
			System.out.println(e.getName()+"ID:"+e.getId());
		}
	
		when(employeeService.get()).thenReturn(list);
		
		
		this.mockMvc.perform(get("/")).andExpect(status().isOk())
		.andExpect(forwardedUrl("employeesList"))
		.andExpect(model().attribute("list", hasItem(
                allOf(
                		hasProperty("name", is("RT")),
                		hasProperty("id", is(5)),
                        hasProperty("department", is("IT"))
                      )
                                                    )))
		.andExpect(model().attribute("list", hasItem(
                allOf(
                		hasProperty("name", is("RTR")),
                		hasProperty("id", is(6)),
                        hasProperty("department", is("ITt"))
                      )
                                                    )));
		
		
		//.andExpect(view.);
		//this.mockMvc.perform(RequestBuilder.class.b
	}
	@Test
	public void finfByIdTesting() throws Exception{
		Employee emp = new Employee();
		emp.setId(7);
		emp.setDepartment("IT");
		emp.setDob(Date.valueOf("1980-04-09"));
		emp.setGender("Male");
		emp.setName("RT");
		when(employeeService.get(7)).thenReturn(emp);
		this.mockMvc.perform(get("/employee/{id}", 7)).andExpect(status().isOk())
		 .andExpect(view().name("employeesAdd"));
		
	
	}
	
}
