package com.example.demo.service;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.example.demo.models.*;
import com.example.demo.models.StatusModel;
import com.example.demo.repository.TestRepository;

@Service
@EnableTransactionManagement
public class TestService {


	@Autowired
    private TestRepository testRepository;
	
	@Autowired
    private Sync sync;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public String DB_CLASS_NAME;
	public String DB_URL;
	public String DB_USER;
	public String DB_PASS;

	Connection conn= null;
	Statement stmt = null;
	@Autowired
	public TestService() {
		super();


	}
	
	public long getCount(){
		return testRepository.count();
	}
	
	@Scheduled(fixedRate = 10000)//, initialDelay = 10000
	public void syncTables(){
		sync.syncTables();
		System.out.println("*************************");
	}
	

	public List<Task_definition> getAllByPage(Optional<String> limit, Optional<String> offset) throws Exception{
		int Limit = Integer.parseInt(limit.get());
		int Offset = Integer.parseInt(offset.get());
		Pageable pageable = new PageRequest(Offset,Limit);
		String name="test";
		return testRepository.findAllBy(pageable);

	}
	
	public List<Task_definition> post(Task_definition info) throws Exception
	{


		StatusModel Status = new StatusModel("Fail");
		if(testRepository.findOne(info.getID()) == null)
			{

			Status.setStatus("Success");
			testRepository.save(info);
			}

		HashMap<String,Object> Recordlist = new HashMap<String,Object>();
		Recordlist.put("data ",testRepository.findOne(info.getID()));
		Recordlist.put("status ",Status.getStatus());
		Task_definition NewAddedRecord = testRepository.findOne(info.getID());
		List<Task_definition> RecordList = new ArrayList<Task_definition>();
		RecordList.add(NewAddedRecord);
		return RecordList;

	}
	
	public List<Task_definition> put(Task_definition info, int id) throws Exception
	{


		StatusModel Status = new StatusModel("Fail");
		if(testRepository.findOne(info.getID()) != null)
			{
			Task_definition record = info;
			record.setID(id);
			Status.setStatus("Success");
			testRepository.save(info);
			}

		HashMap<String,Object> recordlist = new HashMap<String,Object>();
		recordlist.put("data ",testRepository.findOne(info.getID()));
		recordlist.put("status ",Status.getStatus());
		Task_definition NewAddedRecord = testRepository.findOne(info.getID());
		List<Task_definition> RecordList = new ArrayList<Task_definition>();
		RecordList.add(NewAddedRecord);
		return RecordList;

	}
	
	public String deleteRecord(int id) throws Exception
	{
		StatusModel Status = new StatusModel("Success");
		String message = "Record deleted successfully";
		if(testRepository.findOne(id) == null) {Status.setStatus("Fail");message = "Failed to delete the record";}
		else
		{
			testRepository.delete(id);
		}
		
		return message;

	}
	
	@Bean
	public PlatformTransactionManager transactionManager()
	{
	return new JpaTransactionManager(entityManagerFactory);
	}
	
}
