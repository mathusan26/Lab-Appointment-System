package com.hms.entity;

import java.io.InputStream;

public class TestResult {
	
	private int TestResultId;
	private int AppoinmentId;
	private int PatientId;
	private InputStream TestResult;
	private int TechnicianId;
	private int TestId;
	private int statusId;
	
	
	public TestResult() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TestResult(int TestResultId, int PatientId, int AppoinmentId, InputStream TestResult, int TechnicianId, int TestId,int statusId) {
		super();
		this.TestResultId = TestResultId;
		this.AppoinmentId = AppoinmentId;
		this.PatientId = PatientId;
		this.TestResult = TestResult;
		this.TechnicianId = TechnicianId;
		this.TestId = TestId;
		this.statusId = statusId;
	
	}


	public TestResult(int PatientId, int AppoinmentId, InputStream TestResult, int TechnicianId, int TestId,int statusId) {
		super();
		
		this.AppoinmentId = AppoinmentId;
		this.PatientId = PatientId;
		this.TestResult = TestResult;
		this.TechnicianId = TechnicianId;
		this.TestId = TestId;
		this.statusId = statusId;
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

	public InputStream getTestResult() {
		return TestResult;
	}


	public void setTestResult(InputStream TestResult) {
		this.TestResult = TestResult;
	}


	public int getTechnician() {
		return TechnicianId;
	}


	public void setTechnician(int TechnicianId) {
		this.TechnicianId = TechnicianId;
	}


	public int getTestId() {
		return TestId;
	}


	public void setTestId(int TestId) {
		this.TestId = TestId;
	}



	public int getStatus() {
		return statusId;
	}


	public void setStatus(int statusId) {
		this.statusId = statusId;
	}
	
	
	@Override
	public String toString() {
		return "TestResult [TestResultId=" + TestResultId + ", AppoinmentId=" + AppoinmentId + ", PatientId=" + PatientId + ", TestResult=" + TestResult + 
				", TechnicianId=" + TechnicianId + ", TestId=" + TestId  + ", statusId=" + statusId +"]";
	}


}
