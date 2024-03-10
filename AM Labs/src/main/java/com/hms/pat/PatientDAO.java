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
			pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getGender());
			pstmt.setInt(6, user.getAge());
			pstmt.setString(7, user.getAddress());
			pstmt.setString(8, user.getPassword());
			
			pstmt.executeUpdate();

			f = true; // if query execute successfully then f becomes true otherwise false...

		} catch (Exception e) {
			e.printStackTrace();

		}

		return f;
	}
	
	
	// getAllPatient list
		public List<Patient_details> getAllPatient() {

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
					patient.setAddress(resultSet.getString("Address"));
					patient.setEmail(resultSet.getString("email"));
					patient.setAge(resultSet.getInt("age"));
					patient.setPhone(resultSet.getString("phone"));
					patient.setPassword(resultSet.getString("password"));
					patient.setPatientReferenceNo(resultSet.getString("referenceNo"));
					
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
					patient.setAddress(resultSet.getString("Address"));
					patient.setEmail(resultSet.getString("email"));
					patient.setAge(resultSet.getInt("age"));
					patient.setPhone(resultSet.getString("phone"));
					patient.setPassword(resultSet.getString("password"));
					patient.setPatientReferenceNo(resultSet.getString("referenceNo"));

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return patient;
		}

		// get patient by id
		public List<Patient_details> getPatientByEmail(String email) {

			Patient_details patient = null;
			List<Patient_details> patientList = new ArrayList<Patient_details>();

			try {

				String sql = "select * from Patient_details where email=?";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, email);

				ResultSet resultSet = pstmt.executeQuery();

				while (resultSet.next()) {
					patient = new Patient_details();

					patient.setId(resultSet.getInt("patientId"));
					patient.setPatientName(resultSet.getString("patient_name"));
					patient.setDateOfBirth(resultSet.getString("dateOfBirth"));
					patient.setGender(resultSet.getString("gender"));
					patient.setAddress(resultSet.getString("Address"));
					patient.setEmail(resultSet.getString("email"));
					patient.setAge(resultSet.getInt("age"));
					patient.setPhone(resultSet.getString("phone"));
					patient.setPassword(resultSet.getString("password"));
					patient.setPatientReferenceNo(resultSet.getString("referenceNo"));
					patientList.add(patient);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return patientList;
		}
		
	
	// update patient detail by id
		public boolean updatePatient(Patient_details patient) {

			boolean f = false;

			try {

				String sql = "update patient_details set patient_name =?, dateOfBirth=?,email=?, phone=?,gender=?,age=?,address=?,password=? where patientId=?";

				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, patient.getPatientName());
				pstmt.setString(2, patient.getDateOfBirth());
				pstmt.setString(3, patient.getEmail());
				pstmt.setString(4, patient.getPhone());
				pstmt.setString(5, patient.getGender());
				pstmt.setInt(6, patient.getAge());
				pstmt.setString(7, patient.getAddress());
				pstmt.setString(8, patient.getPassword());
			
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
		
		public Patient_details loginPatient(String email, String password) {

			Patient_details user = null;

			try {
				String sql = "select * from patient_details where email=? and password=?";

				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, email);
				pstmt.setString(2, password);

				ResultSet resultSet = pstmt.executeQuery();
				while (resultSet.next()) {
					// if any row available, then fetch the data of that row...

					// create new user object
					user = new Patient_details();

					// fetch data one by one from db table and set it/bind it to user's objects.
					// e.g fetch id and set to user object
					// user.setId(resultSet.getInt(1));or below line both are same
					// (1) means db table colm index number 1 which is id
					// getString() takes both column indexNumber or columnLabel name...
					user.setId(resultSet.getInt("patientId"));
					user.setPatientName(resultSet.getString("patient_name"));
					user.setEmail(resultSet.getString("email"));
					user.setPassword(resultSet.getString("password"));
					
					

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return user;

		}
		
		//check old password
		public boolean checkOldPassword(int userId, String oldPassword) {

			boolean f = false;

			try {

				String sql = "select * from patient_details where patientId=? and password=?";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setInt(1, userId);
				pstmt.setString(2, oldPassword);

				ResultSet resultSet = pstmt.executeQuery();
				//System.out.println(resultSet);
				while (resultSet.next()) {
					f = true;
				}
			

			} catch (Exception e) {
				e.printStackTrace();
			}

			return f;
		}

		//change password
		public boolean changePassword(int userId, String newPassword) {

			boolean f = false;

			try {

				String sql = "update patient_details set password=? where patientId=?";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, newPassword);
				pstmt.setInt(2, userId);

				pstmt.executeUpdate();

				f = true;

			} catch (Exception e) {
				e.printStackTrace();
			}

			return f;
		}
		
		//change updatePatientReference
		public boolean updatePatientReference(int userId, String uniqueReference) {

			boolean f = false;

			try {

				String sql = "update patient_details set referenceNo=? where patientId=?";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, uniqueReference);
				pstmt.setInt(2, userId);

				pstmt.executeUpdate();

				f = true;

			} catch (Exception e) {
				e.printStackTrace();
			}

			return f;
		}
		
		
		
		// get patient by id
		public Patient_details LastCreatedPatient() {

			Patient_details patient = null;

			try {

				String sql = "select * from Patient_details order by patientId desc LIMIT 1";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);
			

				ResultSet resultSet = pstmt.executeQuery();

				while (resultSet.next()) {
					patient = new Patient_details();

					patient.setId(resultSet.getInt("patientId"));
					patient.setPatientName(resultSet.getString("patient_name"));
					patient.setDateOfBirth(resultSet.getString("dateOfBirth"));
					patient.setGender(resultSet.getString("gender"));
					patient.setAddress(resultSet.getString("Address"));
					patient.setEmail(resultSet.getString("email"));
					patient.setAge(resultSet.getInt("age"));
					patient.setPhone(resultSet.getString("phone"));
					patient.setPassword(resultSet.getString("password"));
					patient.setPatientReferenceNo(resultSet.getString("referenceNo"));

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return patient;
		}

}
