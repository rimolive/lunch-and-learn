package com.redhat.lunchandlearn.bean;

import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.forge.persistence.PersistenceUtil;

import com.redhat.lunchandlearn.entity.Employee;

@Named("employeeBean")
@Stateful
@ConversationScoped
public class EmployeeBean extends PersistenceUtil {
	
	private List<Employee> list = null;
	
	private Employee employee;
	
	@Inject
	private Conversation conversation;
	
	private String employeeNumber;
	
	private String employeeName;
	
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
		conversation.begin();
		Long longId = new Long(id + "");
		employee = findById(Employee.class, longId);
		return "load";
	}
	
	public String prepareCreate() {
		conversation.begin();
		if(employee == null) {
			employee = new Employee();
		}
		return "prepare";
	}
	
	public String create() {
		getEntityManager().joinTransaction();
		getEntityManager().persist(employee);
		conversation.end();
		return "create";
	}
	
	public String merge() {
		getEntityManager().joinTransaction();
		getEntityManager().merge(employee);
		conversation.end();
		return "merge";
	}
	
	public String remove(Integer id) {
		Long longId = new Long(id + "");
		getEntityManager().joinTransaction();
		getEntityManager().remove(findById(Employee.class, longId));
		return "remove";
	}
	
	public String find() {
		list = findByNamedQuery("", employeeName, employeeNumber);
		return "find";
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

}
