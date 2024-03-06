package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hms.entity.Appoinment1;

public class Appointment1DAO {

	private Connection conn;

	public Appointment1DAO(Connection conn) {
		super();
		this.conn = conn;
	}

	//for create appointment
	public boolean addAppointment(Appoinment1 appointment) {

		boolean f = false;

		try {

			String sql = "insert into appointment(patientId, DateAndTime, DoctorId, TestId, status) values(?,?,?,?,?)";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			pstmt.setInt(1, appointment.getPatientId());
			pstmt.setString(2, appointment.getDateAndTime());
			pstmt.setInt(3, appointment.getDoctor());
			pstmt.setInt(4, appointment.getTest());
			pstmt.setString(11, appointment.getStatus());

			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	// get list of appointment for logged in specific user 
	//show appointment list for specific user panel
	public List<Appoinment1> getAllAppointmentByLoginUser(int patientId) {
		List<Appoinment1> appList = new ArrayList<Appoinment1>();

		Appoinment1 appointment = null;

		try {

			String sql = "select * from appointment where patientId=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			pstmt.setInt(1, patientId);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {

				appointment = new Appoinment1();

				appointment.setId(resultSet.getInt(1));// appoint id
				appointment.setPatientId(resultSet.getInt(2));// userId
				appointment.setDoctor(resultSet.getInt(3));
				appointment.setTest(resultSet.getInt(4));
				appointment.setDateAndTime(resultSet.getString(5));
				appointment.setStatus(resultSet.getString(12));
				appList.add(appointment);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return appList;

	}

	// get appointment list of patient for specific doctor
	//show list of appointment in specific doctor panel 
	public List<Appoinment1> getAllAppointmentByLoginDoctor(int doctorId) {
		List<Appoinment1> appList = new ArrayList<Appoinment1>();

		Appoinment1 appointment = null;

		try {

			String sql = "select * from appointment where Doctor=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			pstmt.setInt(1, doctorId);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {

				appointment = new Appoinment1();

				appointment.setId(resultSet.getInt(1));// appoint id
				appointment.setPatientId(resultSet.getInt(2));// userId
				appointment.setDoctor(resultSet.getInt(3));
				appointment.setDateAndTime(resultSet.getString(4));
				appointment.setTest(resultSet.getInt(5));
				appointment.setStatus(resultSet.getString(12));
				appList.add(appointment);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return appList;

	}

	// for doctor comment need specific appointment id
	public Appoinment1 getAppointmentById(int id) {

		Appoinment1 appointment = null;

		try {

			String sql = "select * from appointment where AppoinmentId=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			pstmt.setInt(1, id);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {

				appointment = new Appoinment1();

				appointment.setId(resultSet.getInt(1));// appoint id
				appointment.setPatientId(resultSet.getInt(2));// userId
				appointment.setDoctor(resultSet.getInt(3));
				appointment.setDateAndTime(resultSet.getString(4));
				appointment.setTest(resultSet.getInt(5));
				appointment.setStatus(resultSet.getString(12));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return appointment;

	}

	// for update comment status
	public boolean updateDrAppointmentCommentStatus(int apptId, int docId, String comment) {

		boolean f = false;

		try {

			String sql = "update appointment set status=? where AppoinmentId=? and doctorId=?";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, comment);
			pstmt.setInt(2, apptId);
			pstmt.setInt(3, docId);

			pstmt.executeUpdate();

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	// get all appointment in admin panel
	public List<Appoinment1> getAllAppointment() {
		List<Appoinment1> appList = new ArrayList<Appoinment1>();
		Appoinment1 appointment = null;

		try {

			String sql = "select * from appointment order by AppoinmentId desc";
			PreparedStatement pstmt = this.conn.prepareStatement(sql);

			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {

				appointment = new Appoinment1();

				appointment.setId(resultSet.getInt(1));// appoint id
				appointment.setPatientId(resultSet.getInt(2));// userId
				appointment.setDoctor(resultSet.getInt(3));
				appointment.setDateAndTime(resultSet.getString(4));
				appointment.setTest(resultSet.getInt(5));
				appointment.setStatus(resultSet.getString(12));
				appList.add(appointment);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return appList;
	}
	
}
