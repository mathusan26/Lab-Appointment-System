package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hms.entity.Technician;


public class TechnicianDAO {
	
	private Connection conn;

	public TechnicianDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addSTechnician(String tech) {
		
		boolean f = false;
		
		try {
			
			String sql = "insert into technician (technician _name) values(?)";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setString(1, tech);
			
			pstmt.executeUpdate();
			
			f = true;
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return f;
		
	}
	
	public List<Technician> getAllTechnician(){
		
		List<Technician> techList = new ArrayList<Technician>();
		
		Technician technician = null;
		
		try {
			
			String sql = "select * from technician";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			ResultSet resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				
				//create object
				technician = new Technician();
				technician.setId(resultSet.getInt("technicianId"));
				technician.setTechnicianName(resultSet.getString("technician _name"));
				
				
				//now add specialist object into List 
				techList.add(technician);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return techList;
	}
	
	
	// update technician detail by id
	public boolean updateTechnicianName(Technician technician) {

		boolean f = false;

		try {

				String sql = "update technician set technician _name =? where technicianId=?";

				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, technician.getTechnicianName());
					
				// need to set id also for update
				pstmt.setInt(2, technician.getId());

				pstmt.executeUpdate();
				// if query updated or all ok than
				f = true;

			} catch (Exception e) {
					e.printStackTrace();
			}

		return f;
	}
				
				
	// delete technician by id
	public boolean deleteTechnicianById(int id) {

		boolean f = false;

		try {

				String sql = "delete from technician where technicianId=?";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setInt(1, id);

				pstmt.executeUpdate();

				f = true;

			} catch (Exception e) {
					e.printStackTrace();
			}

		return f;
	}

	


}
