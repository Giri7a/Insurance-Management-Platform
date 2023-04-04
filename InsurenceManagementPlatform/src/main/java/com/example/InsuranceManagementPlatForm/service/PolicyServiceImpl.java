package com.example.InsuranceManagementPlatForm.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.InsuranceManagementPlatForm.dao.PolicyRepository;
import com.example.InsuranceManagementPlatForm.entity.Policy;

@Service
public class PolicyServiceImpl implements PolicyService{
	
	@Autowired
	private PolicyRepository policyRepository;
	
	
	public PolicyServiceImpl(PolicyRepository thePolicyRepository) {
		this.policyRepository = thePolicyRepository;
	}

	@Override
	public List<Policy> findAll() {
		return policyRepository.findAll();
	}

	@Override
	public Policy findById(int theId) {
		Optional<Policy> result = policyRepository.findById(theId);
		
		Policy thePolicy = null;
		if(result.isPresent()) {
			thePolicy = result.get();
		}
		return thePolicy;
	}

	@Override
	public void save(Policy thePolicy) {
		policyRepository.save(thePolicy); 
	}

	@Override
	public void deleteById(int theId) {
		policyRepository.deleteById(theId);	
	}

}
