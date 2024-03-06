package com.hms.entity;

public class TestResult {
	
	private int TestResultId;
	private int AppoinmentId;
	private int PatientId;
	private String TestResult;
	private String Technician;
	private int TestId;
	private String status;
	
	
	public TestResult() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TestResult(int TestResultId, int PatientId, int AppoinmentId, String TestResult, String Technician, int TestId,String status) {
		super();
		this.TestResultId = TestResultId;
		this.AppoinmentId = AppoinmentId;
		this.PatientId = PatientId;
		this.TestResult = TestResult;
		this.Technician = Technician;
		this.TestId = TestId;
		this.status = status;
	
	}


	public TestResult(int PatientId, int AppoinmentId, String TestResult, String Technician, int TestId,String status) {
		super();
		
		this.AppoinmentId = AppoinmentId;
		this.PatientId = PatientId;
		this.TestResult = TestResult;
		this.Technician = Technician;
		this.TestId = TestId;
		this.status = status;
	}


	public int getId() {
		return TestResultId;
	}


	public void setId(int TestResultId) {
		this.TestResultId = TestResultId;
	}


	public int getPatientId() {
		return PatientId;
	}


	public void setAppointmentId(int PatientId) {
		this.PatientId = PatientId;
	}


	public int getAppointmentId() {
		return AppoinmentId;
	}


	public void setPatientId(int AppoinmentId) {
		this.AppoinmentId = AppoinmentId;
	}

	public String getTestResult() {
		return TestResult;
	}


	public void setTestResult(String TestResult) {
		this.TestResult = TestResult;
	}


	public String getTechnician() {
		return Technician;
	}


	public void setTechnician(String Technician) {
		this.Technician = Technician;
	}


	public int getTestId() {
		return TestId;
	}


	public void setTestId(int TestId) {
		this.TestId = TestId;
	}



	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	


}
