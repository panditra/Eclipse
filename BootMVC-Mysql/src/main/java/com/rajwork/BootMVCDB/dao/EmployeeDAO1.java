package com.rajwork.BootMVCDB.dao;
import java.util.List;
import com.rajwork.BootMVCDB.model.*;
 
public interface EmployeeDAO1 {
	
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
}