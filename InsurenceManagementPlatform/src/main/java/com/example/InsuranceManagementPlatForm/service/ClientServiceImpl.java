package com.example.InsuranceManagementPlatForm.service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.InsuranceManagementPlatForm.dao.ClientRepository;
import com.example.InsuranceManagementPlatForm.entity.Client;

@Service
public class ClientServiceImpl implements ClientService{

	private ClientRepository clientRepository;

	public ClientServiceImpl(ClientRepository theClientRepository) {
		this.clientRepository = theClientRepository;
	}
	
	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client findById(int theId) {
		Optional<Client> result = clientRepository.findById(theId);
		Client theClient = null;
		if(result.isPresent()) {
			theClient = result.get();
		}
		return theClient;
	}

	@Override
	public ResponseEntity<Client> save(Client theClient) {
		Client newClient = clientRepository.save(theClient);
		return ResponseEntity.ok(newClient);
	}

	@Override
	public ResponseEntity<Map<String,Boolean>> deleteById(int theId) {
		clientRepository.deleteById(theId);
		return ResponseEntity.ok(null);
	}

}
