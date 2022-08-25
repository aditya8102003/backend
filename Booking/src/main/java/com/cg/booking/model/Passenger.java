package com.cg.booking.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class Passenger {

	@NotNull(message = "firstName should not be empty")
	@Size(min = 2, message = "First name should not be less than 2 characters")
	private String firstName;

	@NotNull(message = "lastName should not be empty")
	@Size(min = 2, message = "Last name should not be less than 2 characters")
	private String lastName;

	@Range(min = 5, max = 120, message = "age must be 5 to 100")
	private Integer age;

	@NotNull(message = "Gender should not be empty")
	@Size(min = 2, message = "Gender name should not be less than 2 characters")
	private String gender;

	@NotNull(message = "Email should not be empty")
	@Email(message = "Invalid E-mail Id")
	private String email;
	
	public Passenger() {
		
	}

	public Passenger(
			@NotNull(message = "firstName should not be empty") @Size(min = 2, message = "First name should not be less than 2 characters") String firstName,
			@NotNull(message = "lastName should not be empty") @Size(min = 2, message = "Last name should not be less than 2 characters") String lastName,
			@Range(min = 5, max = 120, message = "age must be 5 to 100") Integer age,
			@NotNull(message = "Gender should not be empty") @Size(min = 2, message = "Gender name should not be less than 2 characters") String gender,
			@NotNull(message = "Email should not be empty") @Email(message = "Invalid E-mail Id") String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ ", email=" + email + "]";
	}

}
