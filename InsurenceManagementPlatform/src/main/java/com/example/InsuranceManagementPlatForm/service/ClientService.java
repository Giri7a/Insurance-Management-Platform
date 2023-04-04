package com.example.InsuranceManagementPlatForm.service;

import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import com.example.InsuranceManagementPlatForm.entity.Client;

public interface ClientService {
     public List<Client> findAll();
     public Client findById(int theId);
     public ResponseEntity<Client> save(Client theClient);
     public ResponseEntity<Map<String,Boolean>> deleteById(int theId);
}
