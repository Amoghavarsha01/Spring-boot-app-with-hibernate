package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entities.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO{
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void save(Employee employee) {
    getSession().save(employee);
    return;
  }
  
  public void delete(Employee employee) {
    getSession().delete(employee);
    return;
  }
  
  @SuppressWarnings("unchecked")
  public List<Employee> getAll() {
    return getSession().createQuery("from Employee").list();
  }
  
  public Employee getByName(String name) {
    return (Employee) getSession().createQuery(
        "from Employee where name = :name")
        .setParameter("name", name)
        .uniqueResult();
  }

  public Employee getById(int id) {
    return (Employee) getSession().get(Employee.class, id);
  }

  public void update(Employee employee) {
    getSession().update(employee);
    return;
  }
  
  public List<Employee> getEmployeeByNameNamedQuery(String name) {
	  Query query = getSession().getNamedQuery("findEmployeeByName");  
	  query.setString("name", name);  
	          
	  List<Employee> employees= query.list();  
	  return employees;
	  
  }

} // class UserDao