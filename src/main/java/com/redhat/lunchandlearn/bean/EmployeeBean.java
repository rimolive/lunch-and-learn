package com.redhat.lunchandlearn.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;

import org.jboss.forge.persistence.PersistenceUtil;

import com.redhat.lunchandlearn.entity.Employee;

@Named("employeeBean")
@Stateless
public class EmployeeBean extends PersistenceUtil {
	
	private List<Employee> list = null;
	
	private Employee employee = new Employee();
	
	private long id = 0;

	public List<Employee> getList() {
		list = findAll(Employee.class);
		return list;
	}

	public void setList(List<Employee> list) {
		this.list = list;
	}
	
	public String create() {
		return "create";
	}
	
	public String merge() {
		return "merge";
	}
	
	public String remove() {
		return "remove";
	}

}
