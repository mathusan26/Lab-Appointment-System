package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hms.entity.Appointment;
public class AppointmentDAO {
		private Connection conn;

		public AppointmentDAO(Connection conn) {
			super();
			this.conn = conn;
		}

		//for create appointment
		public boolean addAppointment(Appointment appointment) {

			boolean f = false;

			try {
				 System.out.println (appointment);
				String sql = "insert into appointment(patientId, DateAndTime, doctor_name, TestId, statusId,totalPrice) values(?,?,?,?,?,?)";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);

				pstmt.setInt(1, appointment.getPatientId());
				pstmt.setString(2, appointment.getDateAndTime());
				pstmt.setString(3, appointment.getDoctor());
				pstmt.setInt(4, appointment.getTest());
				pstmt.setInt(5, appointment.getStatus());
				pstmt.setDouble(6, appointment.getPrice());

				pstmt.executeUpdate();

				f = true;

			} catch (Exception e) {
				e.printStackTrace();
			}

			return f;
		}

		// get list of appointment for logged in specific user 
		//show appointment list for specific user panel
		public List<Appointment> getAllAppointmentByLoginUser(int patientId) {
			List<Appointment> appList = new ArrayList<Appointment>();

			Appointment appointment = null;

			try {

				String sql = "select * from appointment where patientId=?";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);

				pstmt.setInt(1, patientId);

				ResultSet resultSet = pstmt.executeQuery();

				while (resultSet.next()) {

					appointment = new Appointment();

					appointment.setId(resultSet.getInt(1));// appoint id
					appointment.setPatientId(resultSet.getInt(2));// userId
					appointment.setDateAndTime(resultSet.getString(3));
					appointment.setDoctor(resultSet.getString(4));
					appointment.setTest(resultSet.getInt(5));
					appointment.setStatus(resultSet.getInt(6));
					appList.add(appointment);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return appList;

		}

		// for doctor comment need specific appointment id
		public Appointment getAppointmentById(int id) {

			Appointment appointment = null;

			try {

				String sql = "select * from appointment where appointmentId=?";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);

				pstmt.setInt(1, id);

				ResultSet resultSet = pstmt.executeQuery();

				while (resultSet.next()) {

					appointment = new Appointment();

					appointment.setId(resultSet.getInt(1));// appoint id
					appointment.setPatientId(resultSet.getInt(2));// userId
					
					appointment.setDateAndTime(resultSet.getString(3));
					appointment.setDoctor(resultSet.getString(4));
					appointment.setTest(resultSet.getInt(5));
					appointment.setStatus(resultSet.getInt(6));
					appointment.setPrice(resultSet.getDouble(7));

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return appointment;

		}
		
		
		// for doctor comment need specific appointment id
				public Appointment getLastAppointment() {

					Appointment appointment = null;

					try {

						String sql = "select * from appointment order by appointmentId desc LIMIT 1";
						PreparedStatement pstmt = this.conn.prepareStatement(sql);

						
						ResultSet resultSet = pstmt.executeQuery();

						while (resultSet.next()) {

							appointment = new Appointment();

							appointment.setId(resultSet.getInt(1));// appoint id
							appointment.setPatientId(resultSet.getInt(2));// userId
							
							appointment.setDateAndTime(resultSet.getString(3));
							appointment.setDoctor(resultSet.getString(4));
							appointment.setTest(resultSet.getInt(5));
							appointment.setStatus(resultSet.getInt(6));

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

				String sql = "update appointment set statusId=? where appointmentId=? and doctor_name=?";
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
		
		// for update comment status
		public boolean cancelAppointment(int apptId) {

			boolean f = false;

			try {

				String sql = "update appointment set statusId=3 where appointmentId=?";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setInt(1, apptId);
				

				pstmt.executeUpdate();

				f = true;

			} catch (Exception e) {
				e.printStackTrace();
			}

			return f;
		}
		
		public boolean updateAppointmentPrice(int apptId,double price) {

			boolean f = false;

			try {

				String sql = "update appointment set paidAmount=? ,statusId=1 where appointmentId=?";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setDouble(1, price);
				pstmt.setInt(2, apptId);
				

				pstmt.executeUpdate();

				f = true;

			} catch (Exception e) {
				e.printStackTrace();
			}

			return f;
		}
		
		public boolean updateAppointmentStatusORDate( Appointment appoinment) {

			boolean f = false;

			try {

				String sql = "update appointment set dateAndTime=? , statusId=? where appointmentId=?";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, appoinment.getDateAndTime());
				pstmt.setInt(2, appoinment.getStatus());
				pstmt.setInt(3, appoinment.getId());
			

				pstmt.executeUpdate();

				f = true;

			} catch (Exception e) {
				e.printStackTrace();
			}

			return f;
		}

		// get all appointment in admin panel
		public List<Appointment> getAllAppointment() {
			List<Appointment> appList = new ArrayList<Appointment>();
			Appointment appointment = null;

			try {

				String sql = "select * from appointment order by appointmentId desc";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);

				ResultSet resultSet = pstmt.executeQuery();

				while (resultSet.next()) {

					appointment = new Appointment();

					appointment.setId(resultSet.getInt(1));// appoint id
					appointment.setPatientId(resultSet.getInt(2));// userId
					appointment.setDateAndTime(resultSet.getString(3));
					appointment.setDoctor(resultSet.getString(4));
					appointment.setTest(resultSet.getInt(5));
					appointment.setStatus(resultSet.getInt(6));
					appList.add(appointment);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return appList;
		}
		
	}



