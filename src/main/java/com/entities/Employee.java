package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamedQueries
(
	{ 
		@NamedQuery
		(
			name = "findEmployeeByName", 
			query = "from Employee e where e.name = :name"
		)
	}
)	

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "age")
	private int age;

	public Employee() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
