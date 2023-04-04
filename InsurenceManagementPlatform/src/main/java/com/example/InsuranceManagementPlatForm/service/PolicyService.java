package com.example.InsuranceManagementPlatForm.service;
import java.util.List;

import com.example.InsuranceManagementPlatForm.entity.Policy;

public interface PolicyService {
    public List<Policy> findAll();
    public Policy findById(int theId);
    public void save(Policy thePolicy);
    public void deleteById(int theId);
}
