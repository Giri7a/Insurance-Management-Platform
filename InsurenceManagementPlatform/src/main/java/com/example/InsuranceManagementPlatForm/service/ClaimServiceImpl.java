package com.example.InsuranceManagementPlatForm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.InsuranceManagementPlatForm.dao.ClaimRepository;
import com.example.InsuranceManagementPlatForm.entity.Claim;

@Service
public class ClaimServiceImpl implements ClaimService{
	
	private ClaimRepository claimRepository;

	
	public ClaimServiceImpl(ClaimRepository theClaimRepository) {
		this.claimRepository = theClaimRepository;
	}

	@Override
	public List<Claim> findAll() {
		return claimRepository.findAll();
	}

	@Override
	public Claim findById(int theId) {
		Optional<Claim> result = claimRepository.findById(theId);
		Claim theClaim = null;
		if(result.isPresent()) {
			theClaim = result.get();
		}
		return theClaim;
	}

	@Override
	public void save(Claim theClaim) {
		claimRepository.save(theClaim);
	}

	@Override
	public void deleteById(int theId) {
		claimRepository.deleteById(theId);
	}

}
