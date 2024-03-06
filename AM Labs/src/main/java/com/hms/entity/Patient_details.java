package com.hms.entity;

public class Patient_details {
	
	
	private int patientId;
	private String patient_name;
	private String dateOfBirth;
	private String email;
	private int phone;
	private String gender;
	private int age;
	private String address;
	private String password;


	
	public Patient_details() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Patient_details(String patient_name, String dateOfBirth, String email, int phone, String gender,
			int age, String address,String password) {
		super();
		this.patient_name = patient_name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.password =password;
		
	}
	
	
	


	public Patient_details(int patientId, String patient_name, String dateOfBirth, String email, int phone, String gender,
			int age, String address,String password) {
		super();
		this.patientId = patientId;
		this.patient_name = patient_name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.password =password;
		
	}


	


	public int getId() {
		return patientId;
	}


	public void setId(int patientId) {
		this.patientId = patientId;
	}


	public String getPatientName() {
		return patient_name;
	}


	public void setPatientName(String patient_name) {
		this.patient_name = patient_name;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}



}
