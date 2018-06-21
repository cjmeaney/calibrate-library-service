package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Library;
import com.revature.beans.Status;
import com.revature.service.AccountService;
import com.revature.service.LibraryService;

@RestController
public class LibraryController {

	

	@Autowired
	AccountService accountService;

	@Autowired
	LibraryService libraryservice;

	// Testing to find the name of the service
	@GetMapping(path = "/findservice")
	public String helloWorld() {
		return "Hello from Library";
	}

	// Get Library By library Id
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Library> getpublic(@PathVariable int id) {
		return new ResponseEntity<Library>(libraryservice.getLibrariesById(id), HttpStatus.OK);
	}

	
	
	@GetMapping(path = "/status/{statusreport}")
	public ResponseEntity<List<Library>> getReportLibrary(@PathVariable String statusreport) {
		return new ResponseEntity<>(libraryservice.getLibraryStatusReport(statusreport), HttpStatus.OK);

	}
		
	@GetMapping(path = "/status/pending")
	public ResponseEntity<List<Library>> getpendLibrary() {
		return new ResponseEntity<>(libraryservice.getLibraryPend(Status.PENDING), HttpStatus.OK);
	}
	
	@GetMapping(path = "/status/private")
	public ResponseEntity<List<Library>> getPrivateLibrary() {
		return new ResponseEntity<>(libraryservice.getLibraryPend(Status.PRIVATE), HttpStatus.OK);
	}
	
	@GetMapping(path = "/status/public")
	public ResponseEntity<List<Library>> getPublicLibrary() {
		return new ResponseEntity<>(libraryservice.getLibraryPend(Status.PUBLIC), HttpStatus.OK);
	}

	
	// Get the list of Library by the accountId
	@GetMapping("/byaccountId/{accountId}")
	public ResponseEntity<List<Library>> getLibraryByAccountId(@PathVariable int accountId) {
		return new ResponseEntity<>(libraryservice.getLibrariesByAccountID(accountId), HttpStatus.OK);
	}

	@PostMapping("/new/{libraryName}/accountId/{accountId}")
	public ResponseEntity<Library> createLibrary(@PathVariable String libraryName, int accoundId) {

		// Verify Account

		return null;
	}

	// @GetMapping("/delete/{id}")

	// @GetMapping("/id/{id}/status/{status}")

}
