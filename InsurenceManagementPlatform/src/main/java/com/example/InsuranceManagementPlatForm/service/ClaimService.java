package com.example.InsuranceManagementPlatForm.service;

import java.util.List;

import com.example.InsuranceManagementPlatForm.entity.Claim;

public interface ClaimService {
     public List<Claim> findAll();
     public Claim findById(int theId);
     public void save(Claim theClaim);
     public void deleteById(int theId);
}
