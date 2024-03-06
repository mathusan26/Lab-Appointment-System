package com.hms.pat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hms.entity.Doctor;
import com.hms.entity.Patient_details;
import com.hms.entity.User;

public class PatientDAO {
	private Connection conn;

	public PatientDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean patientRegister(Patient_details user) {

		boolean f = false;

		try {
			// insert user in db
			String sql = "insert into patient_details(patient_name, dateOfBirth,email, phone,gender,age,address,password) values(?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPatientName());
			pstmt.setString(2, user.getDateOfBirth());
			pstmt.setString(3, user.getEmail());
			pstmt.setInt(4, user.getPhone());
			pstmt.setString(5, user.getGender());
			pstmt.setInt(5, user.getAge());
			pstmt.setString(6, user.getAddress());
			pstmt.setString(7, user.getPassword());
			
			pstmt.executeUpdate();

			f = true; // if query execute successfully then f becomes true otherwise false...

		} catch (Exception e) {
			e.printStackTrace();

		}

		return f;
	}
	
	
	// getAllPatient list
		public List<Patient_details> getAllDoctor() {

			Patient_details patient = null;
			List<Patient_details> patientList = new ArrayList<Patient_details>();

			try {

				String sql = "select * from patient_details order by patientId desc";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);

				ResultSet resultSet = pstmt.executeQuery();

				while (resultSet.next()) {
					patient = new Patient_details();

					patient.setId(resultSet.getInt("patientId"));
					patient.setPatientName(resultSet.getString("patient_name"));
					patient.setDateOfBirth(resultSet.getString("dateOfBirth"));
					patient.setGender(resultSet.getString("gender"));
					patient.setAddress(resultSet.getString("specialist"));
					patient.setEmail(resultSet.getString("email"));
					patient.setAge(resultSet.getInt("age"));
					patient.setPhone(resultSet.getInt("phone"));
					patient.setPassword(resultSet.getString("password"));
					
					patientList.add(patient);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return patientList;
		}
		
		
		
		// get patient by id
		public Patient_details getPatientById(int id) {

			Patient_details patient = null;

			try {

				String sql = "select * from Patient_details where patientId=?";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setInt(1, id);

				ResultSet resultSet = pstmt.executeQuery();

				while (resultSet.next()) {
					patient = new Patient_details();

					patient.setId(resultSet.getInt("patientId"));
					patient.setPatientName(resultSet.getString("patient_name"));
					patient.setDateOfBirth(resultSet.getString("dateOfBirth"));
					patient.setGender(resultSet.getString("gender"));
					patient.setAddress(resultSet.getString("specialist"));
					patient.setEmail(resultSet.getString("email"));
					patient.setAge(resultSet.getInt("age"));
					patient.setPhone(resultSet.getInt("phone"));
					patient.setPassword(resultSet.getString("password"));;

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return patient;
		}

		
	
	// update patient detail by id
		public boolean updatePatient(Patient_details patient) {

			boolean f = false;

			try {

				String sql = "update patient_details set patient_name =?, dateOfBirth=?,email=?, phone=?,gender=?,age=?,address=? where patientId=?";

				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, patient.getPatientName());
				pstmt.setString(2, patient.getDateOfBirth());
				pstmt.setString(3, patient.getEmail());
				pstmt.setInt(4, patient.getPhone());
				pstmt.setString(5, patient.getGender());
				pstmt.setInt(5, patient.getAge());
				pstmt.setString(6, patient.getAddress());
				pstmt.setString(7, patient.getPassword());
			
				// need to set id also for update
				pstmt.setInt(9, patient.getId());

				pstmt.executeUpdate();
				// if query updated or all ok than
				f = true;

			} catch (Exception e) {
				e.printStackTrace();
			}

			return f;
		}
		
		
		// delete patient by id
		public boolean deletePatientById(int id) {

			boolean f = false;

			try {

				String sql = "delete from patient_details where patientId=?";
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
