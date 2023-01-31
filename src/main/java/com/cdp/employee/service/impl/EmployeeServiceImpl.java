package com.cdp.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdp.employee.adapter.AddressAdapter;
import com.cdp.employee.adapter.DepartmentAdapter;
import com.cdp.employee.mapper.EmployeeMapper;
import com.cdp.employee.models.EmployeeDetails;
import com.cdp.employee.models.GetAddressDetailsResponse;
import com.cdp.employee.models.GetDepartmentDetailsResponse;
import com.cdp.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	DepartmentAdapter deptAdapter;
	@Autowired
	AddressAdapter addressAdapter;

	@Override
	public EmployeeDetails getEmployeeDetails(int empId) {
		EmployeeDetails employee = new EmployeeDetails();
		GetDepartmentDetailsResponse deptDetails = deptAdapter.getDepartmentDetails(empId);
		GetAddressDetailsResponse addressDetails = addressAdapter.getAddressDetails(empId);
		employee.setEmpId(empId);
		employee.setDeptartment(EmployeeMapper.mapper.map(deptDetails));
		employee.setAddressDetails(EmployeeMapper.mapper.map(addressDetails));
		return employee;
	}

}
