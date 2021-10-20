package com.rajwork.BootMVCDB.dao;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.rajwork.BootMVCDB.model.*;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO1 {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		/*Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> list = query.getResultList();
		return list;*/
		//
		
		Query query = currentSession.createQuery("select gender,name from Employee where gender = :gender");
		query.setParameter("gender", "female");
		List list = query.list();
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			Object[] row = (Object[]) itr.next();
			System.out.println("gender::"+row[0]);
			System.out.println("name::"+row[1]);
		}
		
	//	list.get(1);
		//,name fro
		
		return currentSession.createQuery("from Employee")
				.list();
	}

	@Override
	public Employee get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class, id);
		return employeeObj;
	}

	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employeeObj = currentSession.get(Employee.class, id);
		currentSession.delete(employeeObj);
	}

}