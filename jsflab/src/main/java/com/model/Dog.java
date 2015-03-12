package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Dog implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @TableGenerator(name="TABLE_GEN", table="SEQUENCE_TABLE", pkColumnName="SEQ_NAME",
     	valueColumnName="SEQ_COUNT", pkColumnValue="DOG_SEQ")
	 @GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_GEN")
	 private int id;
	 private int age;
	 private String name;
	 private int weight;

	 @ManyToMany(mappedBy="dogs")
	 private List<Person> persons;

	 // get and set
	 

	 @Override
	 public int hashCode() {
	  return id;
	 }

	 public int getId() {
		return id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	 public boolean equals(Object obj) {
	  if (obj instanceof Dog) {
	   Dog dog = (Dog) obj;
	   return dog.getId() == id;
	  }

	  return false;
	 }

	 @Override
	 public String toString() {
	  return name;
	 }
}
