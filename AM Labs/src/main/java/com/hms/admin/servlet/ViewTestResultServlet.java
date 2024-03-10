package com.hms.admin.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.dao.TestResultDAO;
import com.hms.db.DBConnection;
import com.hms.entity.TestResult;
import com.mysql.cj.jdbc.Blob;


@WebServlet("/viewTestResult")
public class ViewTestResultServlet  extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req,
			            HttpServletResponse resp) throws ServletException, IOException {
				try {

					// connects to the database
					DriverManager.registerDriver(new com.mysql.jdbc.Driver());
					int id = Integer.parseInt(req.getParameter("id"));
					TestResultDAO testResultDAO = new TestResultDAO(DBConnection.getConn());
					
					//get session
					HttpSession session = req.getSession();
					

					// call userRegister() and pass user object to insert or save user into DB.
					TestResult result = testResultDAO.getTestResultById(id);
					
					byte byteArray[]= result.getTestResult().readAllBytes();
					//byte byteArray[] = blob.getBytes(1, (int)blob.length());
					
					OutputStream os =resp.getOutputStream();
					os.write(byteArray);
					os.flush();
					os.close();
					
					
					
//					while(rs.next()) { // for each row
//						   // take the blob
//						   Blob blob = rs.getBlob(index);
//						   BufferedInputStream is = new BufferedInputStream(blob.getBinaryStream());
//						   FileOutputStream fos = new FileOutputStream(file);
//						   // you can set the size of the buffer
//						   byte[] buffer = new byte[2048];
//						   int r = 0;
//						   while((r = is.read(buffer))!=-1) {
//						      fos.write(buffer, 0, r);
//						   }
//						   fos.flush();
//						   fos.close();
//						   is.close();
//						   blob.free();
//						}
//						su.close();
//					resp.sendRedirect(result.getTestResult());
					// queries the database
//					
//					if (result) {
//					    // gets file name and file blob data
////					    String fileName = result.getString("file_name");
//					    Blob blob = result.getTestResult();
//					    InputStream inputStream = blob.getBinaryStream();
//					    int fileLength = inputStream.available();
//					     
//					    System.out.println("fileLength = " + fileLength);
//
//					    ServletContext context = getServletContext();
//
//					    // sets MIME type for the file download
//					    String mimeType = context.getMimeType(fileName);
//					    if (mimeType == null) {        
//					        mimeType = "application/octet-stream";
//					    }              
//					     
//					    // set content properties and header attributes for the response
//					    response.setContentType(mimeType);
//					    response.setContentLength(fileLength);
//					    String headerKey = "Content-Disposition";
//					    String headerValue = String.format("attachment; filename=\"%s\"", fileName);
//					    response.setHeader(headerKey, headerValue);
//
//					    // writes the file to the client
//					    OutputStream outStream = response.getOutputStream();
//					     
//					    byte[] buffer = new byte[BUFFER_SIZE];
//					    int bytesRead = -1;
//					     
//					    while ((bytesRead = inputStream.read(buffer)) != -1) {
//					        outStream.write(buffer, 0, bytesRead);
//					    }
//					     
//					    inputStream.close();
//					    outStream.close();             
//					}

//					HttpSession session = req.getSession();

//					if (f == true) {
//						session.setAttribute("successMsg", "Test added Successfully");
//						resp.sendRedirect("admin/appointment/view_appointment.jsp");
//
//					} else {
//						session.setAttribute("errorMsg", "Something went wrong on server!");
//						resp.sendRedirect("admin/appointment/view_appointment.jsp");
//					}

				} catch (Exception e) {
					e.printStackTrace();
				}


			}



}