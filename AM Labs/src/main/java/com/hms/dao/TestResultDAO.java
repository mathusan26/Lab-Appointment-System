package com.hms.dao;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hms.entity.TestResult;
import com.mysql.cj.jdbc.Blob;


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

				String sql = "insert into test_result_details( appoinmentId, patientId,testResult,technicianId,testId, statusId) values(?,?,?,?,?,?)";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);

				pstmt.setInt(1, testresult.getAppointmentId());
				pstmt.setInt(2, testresult.getPatientId());
				
				if (testresult.getTestResult() != null) {
					// fetches input stream of the upload file for the blob column
					pstmt.setBlob(3, testresult.getTestResult());
				}
				pstmt.setInt(4, testresult.getTechnician());
				pstmt.setInt(5, testresult.getTestId());
				pstmt.setInt(6, testresult.getStatus());

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
					testResult.setAppointmentId(resultSet.getInt(2));
					testResult.setPatientId(resultSet.getInt(3));// userId
					testResult.setTestResult(resultSet.getBinaryStream(4));
					testResult.setTechnician(resultSet.getInt(5));
					testResult.setTestId(resultSet.getInt(6));
					testResult.setStatus(resultSet.getInt(7));
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
					testResult.setAppointmentId(resultSet.getInt(2));
					testResult.setPatientId(resultSet.getInt(3));// userId
					testResult.setTestResult(resultSet.getBinaryStream(4));
					testResult.setTechnician(resultSet.getInt(5));
					testResult.setTestId(resultSet.getInt(6));
					testResult.setStatus(resultSet.getInt(7));
					resultList.add(testResult);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return resultList;
		}
		
		// get list of appointment for logged in specific user 
				//show appointment list for specific user panel
				public TestResult getResultByAppointmentId(int appoinmentId) {
					//List<TestResult> resultList = new ArrayList<TestResult>();

					TestResult testResult = null;

					try {

						String sql = "select * from test_result_details where appoinmentId=?";
						PreparedStatement pstmt = this.conn.prepareStatement(sql);

						pstmt.setInt(1, appoinmentId);

						ResultSet resultSet = pstmt.executeQuery();

						while (resultSet.next()) {

							testResult = new TestResult();

							testResult.setId(resultSet.getInt(1));// appoint id
							testResult.setAppointmentId(resultSet.getInt(2));
							testResult.setPatientId(resultSet.getInt(3));// userId
							testResult.setTestResult(resultSet.getBinaryStream(4));
							testResult.setTechnician(resultSet.getInt(5));
							testResult.setTestId(resultSet.getInt(6));
							testResult.setStatus(resultSet.getInt(7));
							//resultList.add(testResult);

						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					return testResult;

				}
				
				// get list of appointment for logged in specific user 
				//show appointment list for specific user panel
				public TestResult getTestResultById(int testResultId) {
					//List<TestResult> resultList = new ArrayList<TestResult>();

					TestResult testResult = null;

					try {

						String sql = "select * from test_result_details where testResultId=?";
						PreparedStatement pstmt = this.conn.prepareStatement(sql);

						pstmt.setInt(1, testResultId);

						ResultSet resultSet = pstmt.executeQuery();

						while (resultSet.next()) {

							testResult = new TestResult();

							testResult.setId(resultSet.getInt(1));// appoint id
							testResult.setAppointmentId(resultSet.getInt(2));
							testResult.setPatientId(resultSet.getInt(3));// userId
							testResult.setTestResult(resultSet.getBinaryStream(4));
							testResult.setTechnician(resultSet.getInt(5));
							testResult.setTestId(resultSet.getInt(6));
							testResult.setStatus(resultSet.getInt(7));
							//resultList.add(testResult);

						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					return testResult;

				}
				public TestResult getTestResultFileId(int testResultId) {
					//List<TestResult> resultList = new ArrayList<TestResult>();

					TestResult testResult = null;

					try {

						String sql = "select testResult from test_result_details where testResultId=?";
						PreparedStatement pstmt = this.conn.prepareStatement(sql);

						pstmt.setInt(1, testResultId);

						ResultSet resultSet = pstmt.executeQuery();
						
						while (resultSet.next()) {
							testResult = new TestResult();
							
						
							testResult.setTestResult(resultSet.getBinaryStream("testResult"));// appoint id
						
						}
//
//						while (resultSet.next()) {
//							Blob blob = resultSet.getBlob(0);
//							BufferedInputStream is = new BufferedInputStream(blob.getBinaryStream());
//							FileOutputStream fos = new FileOutputStream();
//								   // you can set the size of the buffer
//							byte[] buffer = new byte[2048];
//							int r = 0;
//							while((r = is.read(buffer))!=-1) {
//								   fos.write(buffer, 0, r);
//							}
//							fos.flush();
//								   fos.close();
//								   is.close();
//								   blob.free();
//								}
//								pstmt.close();

						

					} catch (Exception e) {
						e.printStackTrace();
					}

					return testResult;

				}

}
