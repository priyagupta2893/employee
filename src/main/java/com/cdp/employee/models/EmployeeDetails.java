package com.cdp.employee.models;

public class EmployeeDetails {

	private int empId;
	private Address addressDetails;
	private Department deptartment;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Address getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(Address addressDetails) {
		this.addressDetails = addressDetails;
	}

	public Department getDeptartment() {
		return deptartment;
	}

	public void setDeptartment(Department deptartment) {
		this.deptartment = deptartment;
	}

}
