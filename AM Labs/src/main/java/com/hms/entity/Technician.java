package com.hms.entity;

public class Technician {
	
	private int technicianId;
	private String technicianName;
	
	public Technician() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Technician(int technicianId, String technicianName) {
		super();
		this.technicianId = technicianId;
		this.technicianName = technicianName;
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

}
