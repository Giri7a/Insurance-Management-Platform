package com.example.InsuranceManagementPlatForm.dao;

import com.example.InsuranceManagementPlatForm.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Integer>{

}
