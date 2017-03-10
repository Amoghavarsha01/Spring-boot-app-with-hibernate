package com.services;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDAOImpl;
import com.entities.Employee;

@Service
public class ProcessingService {
	@Autowired
	EmployeeDAOImpl employeeDAO;
	
	public void processingMethod(){
		System.out.println("Inside processingMethod!!!!!");
		
		Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<Integer, String>();
		concurrentHashMap.put(10, "Amogh");
		concurrentHashMap.put(20, "Santhosh");
		concurrentHashMap.put(30, "Arun");
		concurrentHashMap.put(40, "Ramesh");
		concurrentHashMap.put(50, "Suresh");
		concurrentHashMap.put(60, "Suresh");
		
		long count = concurrentHashMap
		.entrySet()
		.parallelStream()
		.filter(obj -> obj.getValue().equals("Suresh"))
		.count();
		
		System.out.println(count);
	}
	
	public void getEmployeeDetails(){
		List<Employee> employees = employeeDAO.getAll();
		System.out.println("Employees size-------------->>>> " + employees.size());
		//employees.forEach(System.out::println);
		
	    List<Employee> employeesNamedQuery = employeeDAO.getEmployeeByNameNamedQuery("Amogh");
	    employeesNamedQuery.forEach(employee -> System.out.println(employee.getAge()));
	}
}
