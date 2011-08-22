package com.redhat.lunchandlearn.bean;

import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.jboss.forge.persistence.PersistenceUtil;

import com.redhat.lunchandlearn.entity.Employee;

@Named("employeeBean")
@Stateful
@RequestScoped
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
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String load(Integer id) {
		Long longId = new Long(id + "");
		employee = findById(Employee.class, longId);
		return "load";
	}
	
	public String create() {
		getEntityManager().joinTransaction();
		getEntityManager().persist(employee);
		return "create";
	}
	
	public String merge() {
		getEntityManager().joinTransaction();
		getEntityManager().merge(employee);
		return "merge";
	}
	
	public String remove(Integer id) {
		Long longId = new Long(id + "");
		getEntityManager().joinTransaction();
		getEntityManager().remove(findById(Employee.class, longId));
		return "remove";
	}

}
