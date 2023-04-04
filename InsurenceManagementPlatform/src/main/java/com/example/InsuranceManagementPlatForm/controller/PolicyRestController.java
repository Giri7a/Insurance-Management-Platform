package com.example.InsuranceManagementPlatForm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InsuranceManagementPlatForm.entity.Policy;
import com.example.InsuranceManagementPlatForm.exceptionhandling.GlobalNotFoundException;
import com.example.InsuranceManagementPlatForm.service.PolicyService;

@RestController
@RequestMapping("/api")
public class PolicyRestController {
	
	private PolicyService policyService;

	public PolicyRestController(PolicyService thePolicyService) {
		this.policyService = thePolicyService;
	}
	
	@GetMapping("/policies")
	public List<Policy> getAllPolicies(){
		return policyService.findAll();
	}
	
	@GetMapping("/policies/{id}")
	public ResponseEntity<Policy> getSinglePolicy(@PathVariable int id){
		Policy thePolicy = policyService.findById(id);
		if(thePolicy == null) {
			throw new GlobalNotFoundException("policy Id : " + id + " not Found ");
		}
		return ResponseEntity.ok(thePolicy);
	}
	
	@PostMapping("/policies")
	public Policy addPolicy(@RequestBody Policy thePolicy) {
		thePolicy.setId(0);
		policyService.save(thePolicy);
		return thePolicy;
	}
	
	@PutMapping("/policies/{id}")
	public ResponseEntity<Policy> updatePolicy(@PathVariable int id, @RequestBody Policy thePolicy){
		Policy oldPolicy = policyService.findById(id);
		oldPolicy.setPolicyNumber(thePolicy.getPolicyNumber());
		oldPolicy.setType(thePolicy.getType());
		oldPolicy.setCoverageAmount(thePolicy.getCoverageAmount());
		oldPolicy.setPremium(thePolicy.getPremium());
		oldPolicy.setStartDate(thePolicy.getStartDate());
		oldPolicy.setEndDate(thePolicy.getEndDate());
		policyService.save(thePolicy);
		return ResponseEntity.ok(thePolicy);
	}
	
	@DeleteMapping("/policies/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePolicy(@PathVariable int id){
		Policy tempPolicy = policyService.findById(id);
		if(tempPolicy == null) {
			throw new GlobalNotFoundException ("Policy Id : "+id+" not Found ");
		}
		policyService.deleteById(id);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}    
}
