package com.cdp.employee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cdp.employee.models.Address;
import com.cdp.employee.models.Department;
import com.cdp.employee.models.GetAddressDetailsResponse;
import com.cdp.employee.models.GetDepartmentDetailsResponse;

@Mapper
public interface EmployeeMapper {
	
	EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);
	@Mappings({
			@Mapping(target="deptNo", source="deptNumber"),
			@Mapping(target="deptName", source="deptName")
	})
	Department map(GetDepartmentDetailsResponse deptDetails);
	
	Address map(GetAddressDetailsResponse addressDetails);
	
}
