package com.hms.entity;

public class Appointment {
	
		
		private int AppoinmentId;
		private int PatientId;
		private String DateAndTime;
		private String Doctor;
		private int TestId;
		private int statusId;
		private double price;
		
		
		public Appointment() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Appointment(int AppoinmentId, int PatientId, String DateAndTime, String Doctor, int TestId, int statusId) {
			super();
			this.AppoinmentId = AppoinmentId;
			this.PatientId = PatientId;
			this.DateAndTime = DateAndTime;
			this.Doctor = Doctor;
			this.TestId = TestId;
			this.statusId = statusId;
		
		}
		
		public Appointment( int PatientId, String DateAndTime, String Doctor, int TestId, int statusId, double price) {
			super();
		
			this.PatientId = PatientId;
			this.DateAndTime = DateAndTime;
			this.Doctor = Doctor;
			this.TestId = TestId;
			this.statusId = statusId;
			this.price = price;
		
		}
		public Appointment(int AppoinmentId) {
			super();
			this.AppoinmentId = AppoinmentId;
			
		
		}
		public Appointment(int AppoinmentId,double price) {
			super();
			this.AppoinmentId = AppoinmentId;
			this.price = price;
			
		
		}
		public Appointment( String DateAndTime, int statusId,int AppoinmentId) {
			super();
			this.AppoinmentId = AppoinmentId;
			this.DateAndTime = DateAndTime;
			this.statusId = statusId;
		
		}


		public Appointment(int PatientId, String DateAndTime, String Doctor, int TestId, int statusId) {
			super();
			
			this.PatientId = PatientId;
			this.DateAndTime = DateAndTime;
			this.Doctor = Doctor;
			this.TestId = TestId;
			this.statusId = statusId;
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


		public String getDoctor() {
			return Doctor;
		}


		public void setDoctor(String Doctor) {
			this.Doctor = Doctor;
		}


		public int getTest() {
			return TestId;
		}


		public void setTest(int TestId) {
			this.TestId = TestId;
		}
		
		public double getPrice() {
			return price;
		}


		public void setPrice(double price) {
			this.price = price;
		}



		public int getStatus() {
			return statusId;
		}


		public void setStatus(int statusId) {
			this.statusId = statusId;
		}
		
		
		

	}


