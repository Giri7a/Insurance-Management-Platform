package com.example.InsuranceManagementPlatForm.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InsuranceManagementPlatForm.entity.Client;
import com.example.InsuranceManagementPlatForm.exceptionhandling.GlobalNotFoundException;
import com.example.InsuranceManagementPlatForm.service.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ClientRestController {
	  
	private ClientService clientService;

	public ClientRestController(ClientService theClientService) {
		this.clientService = theClientService;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/clients")
	public List<Client> getAllClients(){
    return clientService.findAll();  
	}
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<Client> getOneClient(@PathVariable int id){
		Client theClient = clientService.findById(id);
		if(theClient == null) {
			throw new GlobalNotFoundException("Client Id : "+id+" not Found ");
		}
		return ResponseEntity.ok(theClient);
	}
	
	@PostMapping("/clients")
	public Client addClient(@Valid @RequestBody Client theClient, BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) {
	            throw new GlobalNotFoundException(bindingResult.getFieldError().getDefaultMessage());
	        }
		theClient.setId(0);
		clientService.save(theClient);
		return theClient;
	}
	
	@PutMapping("/clients/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable int id,@Valid @RequestBody Client theClient,BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
            throw new GlobalNotFoundException(bindingResult.getFieldError().getDefaultMessage());
        }
		Client oldClient = clientService.findById(id);
		oldClient.setName(theClient.getName());
		oldClient.setDob(theClient.getDob());
		oldClient.setAddress(theClient.getAddress());
		oldClient.setContact(theClient.getContact());
		clientService.save(theClient);
		return ResponseEntity.ok(theClient);
	}
	
	@DeleteMapping("/clients/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteClient(@PathVariable int id){
		Client tempClient = clientService.findById(id);
		if(tempClient == null) {
			throw new GlobalNotFoundException("Client Id : "+id+" not Found ");
		}
		clientService.deleteById(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
}
