package com.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.hms.entity.Test;
import javax.servlet.http.HttpSession;

public class TestDAO {
	
	private Connection conn;
	

	public TestDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	// getAllTest list
		public List<Test> getAllTest() {

			Test test = null;
			List<Test> TestList = new ArrayList<Test>();

			try {

				String sql = "select * from lab_tests";
				PreparedStatement pstmt = this.conn.prepareStatement(sql);

				ResultSet resultSet = pstmt.executeQuery();

				while (resultSet.next()) {
					test = new Test();

					test.setId(resultSet.getInt("testId"));
					test.setTestName(resultSet.getString("test_name"));
					test.setTestDescription(resultSet.getString("test_description"));
					
			
					TestList.add(test);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return TestList;
		}
		
		
		//Add new Test
		public boolean AddNewTest(Test test) {

			boolean f = false;

			try {
				// insert user in db
				String sql = "insert into lab_tests(test_name,test_description) values(?,?)";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, test.getTestName());
				pstmt.setString(2, test.getTestDescription());
				pstmt.executeUpdate();

				f = true; // if query execute successfully then f becomes true otherwise false...

			} catch (Exception e) {
				e.printStackTrace();

			}

			return f;
		}
		
	
		// get test by id
			public Test getTestById(int id) {

				Test test = null;

				try {

					String sql = "select * from lab_tests where testId=?";
					PreparedStatement pstmt = this.conn.prepareStatement(sql);
					pstmt.setInt(1, id);

					ResultSet resultSet = pstmt.executeQuery();

					while (resultSet.next()) {
						test = new Test();

						test.setId(resultSet.getInt("testId"));
						test.setTestName(resultSet.getString("test_name"));
						test.setTestDescription(resultSet.getString("test_description"));
						

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				return test;
			}

			
		
		// update test detail by id
			public boolean updateTestName(Test test) {

				boolean f = false;

				try {

					String sql = "update lab_tests set test_name =? ,test_description=? where testId=?";

					PreparedStatement pstmt = this.conn.prepareStatement(sql);
					pstmt.setString(1, test.getTestName());
					pstmt.setString(2, test.getTestDescription());
				
					// need to set id also for update
					pstmt.setInt(3, test.getId());

					pstmt.executeUpdate();
					// if query updated or all ok than
					f = true;

				} catch (Exception e) {
					e.printStackTrace();
				}

				return f;
			}
			
			
			// delete test by id
			public boolean deleteTestById(int id) {

				boolean f = false;

				try {

					String sql = "delete from lab_tests where testId=?";
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
