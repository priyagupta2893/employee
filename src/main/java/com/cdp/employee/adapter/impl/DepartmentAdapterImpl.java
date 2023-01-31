package com.cdp.employee.adapter.impl;

import java.net.URI;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cdp.employee.adapter.DepartmentAdapter;
import com.cdp.employee.models.GetDepartmentDetailsRequest;
import com.cdp.employee.models.GetDepartmentDetailsResponse;

@Service
public class DepartmentAdapterImpl implements DepartmentAdapter{

	@Override
	public GetDepartmentDetailsResponse getDepartmentDetails(int empId) {
		GetDepartmentDetailsRequest request = new GetDepartmentDetailsRequest();
		request.setEmpId(empId);
		RestTemplate template = new RestTemplate();
		try {
			RequestEntity<GetDepartmentDetailsRequest> departmentRequest = RequestEntity
					.post(new URI("http://localhost:8081/dept/departmentDetails"))
					.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).body(request);
			
			ResponseEntity<GetDepartmentDetailsResponse> deptResponse = template.exchange
					("http://localhost:8081/dept/departmentDetails", HttpMethod.POST, departmentRequest, GetDepartmentDetailsResponse.class);
			
			GetDepartmentDetailsResponse response = deptResponse.getBody();
			if (response != null ) {
				return response;
			}
		} catch(Exception e) {
			return null;
		}
		return null;
		
	}

}
