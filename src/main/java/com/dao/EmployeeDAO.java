package com.dao;

import java.util.List;

import com.entities.Employee;

public interface EmployeeDAO {
	void save(Employee employee);
	void delete(Employee employee);
	public List<Employee> getAll();
	public Employee getByName(String name);
	public Employee getById(int id);
	public void update(Employee employee);
	public List<Employee> getEmployeeByNameNamedQuery(String name);
}
