package hibernatetest;

import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Employee em;
	ManageEmployee man;
	Department dp;
	//Department dp;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		man=new ManageEmployee();
		dp.setDepartmentId(man.selectDepartment(dp.getDept_name()));
		System.out.print(dp.getDept_name()+":"+dp.getDepartmentId());
//		g.setDept_name("aa");
		man.addDepartment(dp);
		em.setDepartment(dp);
		man.addEmployee(em);
		return SUCCESS;
	}
	public Department getDp() {
		return dp;
	}
	public void setDp(Department dp) {
		this.dp = dp;
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if(em.getSalary()<15000){
			addFieldError("em.salary", "Salary must more than 15000 lower bound");
		}
	//	System.out.print(dp.getDepart());
		if(dp.getDept_name().equals("")||dp.getDept_name().equals(null)){
			addFieldError("dp.dept_name", "depart must choose");
		}
	}

	public Employee getEm() {
		return em;
	}
	public void setEm(Employee em) {
		this.em = em;
	}
}
