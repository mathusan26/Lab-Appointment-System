package com.hms.entity;

public class Technician {
	
	private int technicianId;
	private String technicianName;
	private int testFieldId;
	private int age;
	private String address;
	private int phone;
	
	public Technician() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Technician(int technicianId, String technicianName) {
		super();
		this.technicianId = technicianId;
		this.technicianName = technicianName;
	}
	public Technician( String technicianName) {
		super();
		
		this.technicianName = technicianName;
	}
	public Technician( String technicianName,int testFieldId,String address,int phone,int age) {
		super();
		
		this.technicianName = technicianName;
		this.testFieldId =testFieldId;
		this.address = address;
		this.phone = phone;
		this.age=age;
	}
	
	public Technician( int technicianId,String technicianName,int testFieldId,String address,int phone,int age) {
		super();
		this.technicianId =technicianId;
		this.technicianName = technicianName;
		this.testFieldId =testFieldId;
		this.address = address;
		this.phone = phone;
		this.age=age;
	}

	public int getId() {
		return technicianId;
	}

	public void setId(int technicianId) {
		this.technicianId = technicianId;
	}

	public String getTechnicianName() {
		return technicianName;
	}

	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
	}
	public int getTestFieldId() {
		return testFieldId;
	}

	public void setTestFieldId(int testFieldId) {
		this.testFieldId = testFieldId;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
