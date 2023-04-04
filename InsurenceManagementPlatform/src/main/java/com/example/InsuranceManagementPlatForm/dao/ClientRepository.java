package com.example.InsuranceManagementPlatForm.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.InsuranceManagementPlatForm.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
