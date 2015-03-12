package com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Person.findUserByIdWithDogs", query = "select p from Person p left join fetch p.dogs where p.id = :personId")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_USER_BY_ID_WITH_DOGS = "Person.findUserByIdWithDogs";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PERSON_SEQ")
	@SequenceGenerator(name="PERSON_SEQ", sequenceName="PERSON_SEQ", allocationSize=100)
	private int id;
	private int age;
	private String name;
	private String email;
	private String phone;
	private Date date1;
	private String date1Konverted;
	private Date date2;
	
	@JoinTable( name = "PERSON_DOG",
		joinColumns = {
			@JoinColumn ( name = "ID", referencedColumnName = "DOGS_ID")
		}
	)
	@ManyToMany
	private List<Dog> dogs;

	// get and set

	@Override
	public int hashCode() {
		return id;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Date getDate1() {
		return date1;
	}


	public void setDate1(Date date1) {
		this.date1 = date1;
	}


	public String getDate1Konverted() {
		return date1Konverted;
	}


	public void setDate1Konverted(String date1Konverted) {
		this.date1Konverted = date1Konverted;
	}


	public Date getDate2() {
		return date2;
	}


	public void setDate2(Date date2) {
		this.date2 = date2;
	}


	public int getId() {
		return id;
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

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person person = (Person) obj;
			return person.getId() == id;
		}

		return false;
	}
}
