package com.hms.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

import com.hms.entity.Status;


public class StatusDAO {

		private Connection conn;
		

		public StatusDAO(Connection conn) {
			super();
			this.conn = conn;
		}
		// getAllTest list
		public List<Status> getAllStatus() {

			Status status = null;
				List<Status> StatusList = new ArrayList<Status>();

				try {

					String sql = "select * from status";
					PreparedStatement pstmt = this.conn.prepareStatement(sql);

					ResultSet resultSet = pstmt.executeQuery();

					while (resultSet.next()) {
						status = new Status();

						status.setId(resultSet.getInt("statusId"));
						status.setStatusName(resultSet.getString("statusName"));
						status.setStatusFlag(resultSet.getBoolean("isLabTest"));
						
				
						StatusList.add(status);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				return StatusList;
			}
			
			
			//Add new Test
			public boolean AddNewStatus(Status status) {

				boolean f = false;

				try {
					// insert user in db
					String sql = "insert into status(statusName,isLabTest) values(?,?)";

					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, status.getStatusName());
					pstmt.setBoolean(2, status.getStatusFlag());
					pstmt.executeUpdate();

					f = true; // if query execute successfully then f becomes true otherwise false...

				} catch (Exception e) {
					e.printStackTrace();

				}

				return f;
			}
			
		
			// get test by id
				public Status getStatusById(int id) {

					Status status = null;

					try {

						String sql = "select * from status where statusId=?";
						PreparedStatement pstmt = this.conn.prepareStatement(sql);
						pstmt.setInt(1, id);

						ResultSet resultSet = pstmt.executeQuery();

						while (resultSet.next()) {
							status = new Status();

							status.setId(resultSet.getInt("statusId"));
							status.setStatusName(resultSet.getString("statusName"));
							status.setStatusFlag(resultSet.getBoolean("isLabTest"));
							

						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					return status;
				}

				
				// get test by id
				public List<Status> getStatusForAppointment(int isLabTest) {
					Status status = null;
					List<Status> StatusList = new ArrayList<Status>();


					try {

						String sql = "select * from status where isLabTest=?";
						PreparedStatement pstmt = this.conn.prepareStatement(sql);
						pstmt.setInt(1, isLabTest);

						ResultSet resultSet = pstmt.executeQuery();

						while (resultSet.next()) {
							status = new Status();

							status.setId(resultSet.getInt("statusId"));
							status.setStatusName(resultSet.getString("statusName"));
							status.setStatusFlag(resultSet.getBoolean("isLabTest"));
							
							StatusList.add(status);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					return StatusList;
				}

				
			
			// update test detail by id
				public boolean updateStatusName(Status status) {

					boolean f = false;

					try {

						String sql = "update status set statusName =? ,isLabTest=? where statusId=?";

						PreparedStatement pstmt = this.conn.prepareStatement(sql);
						pstmt.setString(1, status.getStatusName());
						pstmt.setBoolean(2, status.getStatusFlag());
					
						// need to set id also for update
						pstmt.setInt(3, status.getId());

						pstmt.executeUpdate();
						// if query updated or all ok than
						f = true;

					} catch (Exception e) {
						e.printStackTrace();
					}

					return f;
				}
				
				
				// delete test by id
				public boolean deleteStatusById(int id) {

					boolean f = false;

					try {

						String sql = "delete from status where statusId=?";
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
