package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_definition")
public class Task_definition{
	public Task_definition(Integer ID, String name, String description) {
		super();
		this.id = ID;
		Name = name;
		Description = description;
	}
	
	public Task_definition() {
		super();
		
	}

	@Id
	@Column(name="ID")
	Integer id;
	@Column(name="Name")
	String Name;	
	@Column(name="Description")
	String Description;

	public Integer getID() {
		return id;
	}

	public void setID(Integer ID) {
		this.id = ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	

}

