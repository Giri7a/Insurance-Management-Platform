package com.example.InsuranceManagementPlatForm.dao;

import com.example.InsuranceManagementPlatForm.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Integer>{

}
