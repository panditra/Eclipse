package com.rajwork.BootMVCDB.service;
import java.util.List;

import com.rajwork.BootMVCDB.model.*;

public interface EmployeeService {
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
}