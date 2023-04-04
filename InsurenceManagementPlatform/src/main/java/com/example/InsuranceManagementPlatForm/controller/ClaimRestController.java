package com.example.InsuranceManagementPlatForm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.InsuranceManagementPlatForm.exceptionhandling.GlobalNotFoundException;
import com.example.InsuranceManagementPlatForm.service.ClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InsuranceManagementPlatForm.entity.Claim;

@RestController
@RequestMapping("/api")
public class ClaimRestController {
	
	private ClaimService claimService;

	public ClaimRestController(ClaimService theClaimService) {
		this.claimService = theClaimService;
	}
	
	@GetMapping("/claims")
	public List<Claim> getAllClaims(){
		return claimService.findAll();
	}
	
	@GetMapping("/claims/{id}")
	public ResponseEntity<Claim> getSingleClaim(@PathVariable int id) {
		Claim theClaim = claimService.findById(id);
		if(theClaim == null) {
			throw new GlobalNotFoundException("Claim id Not Found");
		}
		return ResponseEntity.ok(theClaim);
	}
	
	@PostMapping("/claims")
	public Claim addClaim(@RequestBody Claim theClaim) {
		theClaim.setId(0);
		claimService.save(theClaim);
		return theClaim;
	}
	
	@PutMapping("/claims/{id}")
	public ResponseEntity<Claim> updateClaim(@PathVariable int id, @RequestBody Claim theClaim){
		Claim oldClaim = claimService.findById(id);
		oldClaim.setClaimNumber(theClaim.getClaimNumber());
		oldClaim.setDescription(theClaim.getDescription());
		oldClaim.setClaimDate(theClaim.getClaimDate());
		oldClaim.setClaimStatus(theClaim.getClaimStatus());
		claimService.save(theClaim);
		return ResponseEntity.ok(theClaim);
	}
	
	
	@DeleteMapping("/claims/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteClaim(@PathVariable int id){
		Claim tempClaim = claimService.findById(id);
		if(tempClaim == null) {
			throw new GlobalNotFoundException("Claim Id Not Found");
		}
		claimService.deleteById(id);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
