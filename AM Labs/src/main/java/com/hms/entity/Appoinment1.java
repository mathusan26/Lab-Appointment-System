package com.hms.entity;

public class Appoinment1 {
	
	
	private int AppoinmentId;
	private int PatientId;
	private String DateAndTime;
	private int DoctorId;
	private int TestId;
	private String status;
	
	
	public Appoinment1() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Appoinment1(int AppoinmentId, int PatientId, String DateAndTime, int DoctorId, int TestId, String status) {
		super();
		this.AppoinmentId = AppoinmentId;
		this.PatientId = PatientId;
		this.DateAndTime = DateAndTime;
		this.DoctorId = DoctorId;
		this.TestId = TestId;
		this.status = status;
	
	}


	public Appoinment1(int PatientId, String DateAndTime, int DoctorId, int TestId, String status) {
		super();
		
		this.PatientId = PatientId;
		this.DateAndTime = DateAndTime;
		this.DoctorId = DoctorId;
		this.TestId = TestId;
		this.status = status;
	}


	public int getId() {
		return AppoinmentId;
	}


	public void setId(int AppoinmentId) {
		this.AppoinmentId = AppoinmentId;
	}


	public int getPatientId() {
		return PatientId;
	}


	public void setPatientId(int PatientId) {
		this.PatientId = PatientId;
	}


	public String getDateAndTime() {
		return DateAndTime;
	}


	public void setDateAndTime(String DateAndTime) {
		this.DateAndTime = DateAndTime;
	}


	public int getDoctor() {
		return DoctorId;
	}


	public void setDoctor(int DoctorId) {
		this.DoctorId = DoctorId;
	}


	public int getTest() {
		return TestId;
	}


	public void setTest(int TestId) {
		this.TestId = TestId;
	}



	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
