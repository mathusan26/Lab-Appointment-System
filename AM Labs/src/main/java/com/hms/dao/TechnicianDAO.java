package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hms.entity.Technician;
import com.hms.entity.Test;


public class TechnicianDAO {
	
	private Connection conn;

	public TechnicianDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addSTechnician(Technician tech) {
		
		boolean f = false;
		
		try {
			
			
			String sql = "insert into technician (technician_name,testFieldId, address, phone, age) values(?,?,?,?,?)";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setString(1, tech.getTechnicianName());
			pstmt.setInt(2, tech.getTestFieldId());
			pstmt.setString(3, tech.getAddress());
			pstmt.setInt(4, tech.getPhone());
			pstmt.setInt(5, tech.getAge());
			
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
				technician.setTechnicianName(resultSet.getString("technician_name"));
				technician.setTestFieldId(resultSet.getInt("testFieldId"));
				technician.setAddress(resultSet.getString("address"));
				technician.setAge(resultSet.getInt("age"));
				technician.setPhone(resultSet.getInt("phone"));
				
				
				//now add specialist object into List 
				techList.add(technician);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return techList;
	}
	
	
	public Technician getTechnicianById(int id) {

		Technician technician = null;

		try {

			String sql = "select * from technician where technicianId=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				technician = new Technician();

				technician.setId(resultSet.getInt("technicianId"));
				technician.setTechnicianName(resultSet.getString("technician_name"));
				technician.setTestFieldId(resultSet.getInt("testFieldId"));
				technician.setAddress(resultSet.getString("address"));
				technician.setAge(resultSet.getInt("age"));
				technician.setPhone(resultSet.getInt("phone"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return technician;
	}

	
	// update technician detail by id
	public boolean updateTechnicianName(Technician technician) {

		boolean f = false;

		try {

				String sql = "update technician set technician_name =? ,testFieldId=?, address=?, phone=?, age=? where technicianId=?";

				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, technician.getTechnicianName());
				pstmt.setInt(2, technician.getTestFieldId());
				pstmt.setString(3, technician.getAddress());
				pstmt.setInt(4, technician.getPhone());
				pstmt.setInt(5, technician.getAge());
					
				// need to set id also for update
				pstmt.setInt(6, technician.getId());

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
