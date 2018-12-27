package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.*;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface TestRepository extends CrudRepository<Task_definition, Integer> {
	@Value("${DATABASE_NAME}")
	String DatabaseName = "";

	public List<Task_definition> findAllBy(Pageable pageable);
		
	@Query(value ="SELECT COUNT(*) AS rowcount FROM TestDatabase.task_definition",nativeQuery=true)
    int getUsersCount();
    
	@Transactional
	@Modifying
    @Query(value ="TRUNCATE TABLE TestDatabase.Task_definition_mirror;",nativeQuery=true)
    void truncate_Task_definition();
	
	@Transactional
	@Modifying
    @Query(value ="INSERT INTO TestDatabase.Task_definition_mirror (ID, Name, Description) SELECT ID, Name, Description FROM TestDatabase.Task_definition",nativeQuery=true)
    void syncTables_Task_definition();



}