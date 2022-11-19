package aop.ex01;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagerImpl implements EmployeeManager {

	public EmployeeVO getEmployeeById(Integer employeeId) {
		System.out.println("Method getEmployeeById() called");
	    return new EmployeeVO();
	}

	public List<EmployeeVO> getAllEmployee() {
		System.out.println("Method getAllEmployee() called");
	    return new ArrayList<EmployeeVO>();
	}

	public void createEmployee(EmployeeVO employee) {
		System.out.println("Method createEmployee() called");
//		throw new NullPointerException("Error while creating employee");
	}

	public void deleteEmployee(Integer employeeId) {
		System.out.println("Method deleteEmployee() called");
	}

	public void updateEmployee(EmployeeVO employee) {
		System.out.println("Method updateEmployee() called");
	}
}
