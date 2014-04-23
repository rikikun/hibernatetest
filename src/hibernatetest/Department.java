package hibernatetest;

import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Department {
	   private int departmentId=0;
	   private String dept_name; 
	   private Set<Employee> employees;
	   public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}


	   

}
