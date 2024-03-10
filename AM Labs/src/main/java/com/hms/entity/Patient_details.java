package com.hms.entity;

public class Patient_details {
	
	
	private int patientId;
	private String patientName;
	private String dateOfBirth;
	private String email;
	private String phone;
	private String gender;
	private int age;
	private String address;
	private String password;
	private String referenceNo;


	
	public Patient_details() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Patient_details(String patientName, String dateOfBirth, String email, String phone, String gender,
			int age, String address,String password) {
		super();
		this.patientName = patientName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.password =password;
		
	}
	
	
	


	public Patient_details(int patientId, String patientName, String dateOfBirth, String email, String phone, String gender,
			int age, String address,String password) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.password =password;
		
	}


	public Patient_details(String patientName, String email, String password) {
		super();
		this.patientName = patientName;
		this.email = email;
		this.password = password;
	}



	public int getId() {
		return patientId;
	}


	public void setId(int patientId) {
		this.patientId = patientId;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
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
	
	public String getPatientReferenceNo() {
		return referenceNo;
	}


	public void setPatientReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	@Override
	public String toString() {
		return "Patient_details [patientId=" + patientId + ", patientName=" + patientName + ", email=" + email + ", password=" + password + "]";
	}

}
