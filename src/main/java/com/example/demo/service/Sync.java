package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.TestRepository;
@Service
public class Sync {
	@Autowired
    private TestRepository testRepository;
	
	@Transactional
	public void syncTables(){
		testRepository.truncate_Task_definition();
		testRepository.syncTables_Task_definition();
		System.out.println("*************************");
	}
}
