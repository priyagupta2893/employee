package com.cdp.employee.adapter.impl;

import java.net.URI;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cdp.employee.adapter.AddressAdapter;
import com.cdp.employee.models.GetAddressDetailsRequest;
import com.cdp.employee.models.GetAddressDetailsResponse;

@Service
public class AddressAdapterImpl implements AddressAdapter {

	@Override
	public GetAddressDetailsResponse getAddressDetails(int empId) {
		 GetAddressDetailsRequest request = new GetAddressDetailsRequest();
		request.setEmpId(empId);
		RestTemplate template = new RestTemplate();
		try {
			RequestEntity<GetAddressDetailsRequest> request2 = RequestEntity
					.post(new URI("http://localhost:8082/address/addressDetails"))
					.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).body(request);
			
			ResponseEntity<GetAddressDetailsResponse> response2 = template.exchange
					("http://localhost:8082/address/addressDetails", HttpMethod.POST, request2, GetAddressDetailsResponse.class);
			
			GetAddressDetailsResponse response = response2.getBody();
			if (response != null ) {
				return response;
			}
		} catch(Exception e) {
			return null;
		}
		return null;
		
	}

}
