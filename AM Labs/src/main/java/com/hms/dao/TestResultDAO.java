package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hms.entity.Appoinment1;
import com.hms.entity.TestResult;


public class TestResultDAO {
	
	private Connection conn;

	public TestResultDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	//for create appointment
		public boolean addTestResult(TestResult testresult) {

			boolean f = false;

			try {

				String sql = "insert into test_result_details( AppoinmentId, patientId,Technician,TestId,TestResult, status) values(?,?,?,?,?,?)";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);

				pstmt.setInt(1, testresult.getPatientId());
				pstmt.setInt(2, testresult.getAppointmentId());
				pstmt.setString(3, testresult.getTechnician());
				pstmt.setInt(3, testresult.getTestId());
				pstmt.setString(4, testresult.getTestResult());
				pstmt.setString(11, testresult.getStatus());

				pstmt.executeUpdate();

				f = true;

			} catch (Exception e) {
				e.printStackTrace();
			}

			return f;
		}

		// get list of appointment for logged in specific user 
		//show appointment list for specific user panel
		public List<TestResult> getAllTestResultByLoginUser(int patientId) {
			List<TestResult> resultList = new ArrayList<TestResult>();

			TestResult testResult = null;

			try {

				String sql = "select * from test_result_details where patientId=?";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);

				pstmt.setInt(1, patientId);

				ResultSet resultSet = pstmt.executeQuery();

				while (resultSet.next()) {

					testResult = new TestResult();

					testResult.setId(resultSet.getInt(1));// appoint id
					testResult.setPatientId(resultSet.getInt(2));// userId
					testResult.setAppointmentId(resultSet.getInt(3));
					testResult.setTestId(resultSet.getInt(4));
					testResult.setTechnician(resultSet.getString(5));
					testResult.setTestResult(resultSet.getString(5));
					testResult.setStatus(resultSet.getString(12));
					resultList.add(testResult);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return resultList;

		}
		
		
		public boolean updateTestResultCommentStatus(int apptId, int patientId, String comment) {

			boolean f = false;

			try {

				String sql = "update test_result_details set status=? where AppoinmentId=? and patientId=?";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, comment);
				pstmt.setInt(2, apptId);
				pstmt.setInt(3, patientId);

				pstmt.executeUpdate();

				f = true;

			} catch (Exception e) {
				e.printStackTrace();
			}

			return f;
		}

		// get all appointment in admin panel
		public List<TestResult> getAllTestResult() {
			List<TestResult> resultList = new ArrayList<TestResult>();
			TestResult testResult = null;

			try {

				String sql = "select * from test_result_details order by AppoinmentId desc";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);

				ResultSet resultSet = pstmt.executeQuery();

				while (resultSet.next()) {

					testResult = new TestResult();

					testResult.setId(resultSet.getInt(1));// appoint id
					testResult.setPatientId(resultSet.getInt(2));// userId
					testResult.setAppointmentId(resultSet.getInt(3));
					testResult.setTestId(resultSet.getInt(4));
					testResult.setTechnician(resultSet.getString(5));
					testResult.setTestResult(resultSet.getString(5));
					testResult.setStatus(resultSet.getString(12));
					resultList.add(testResult);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return resultList;
		}

}
