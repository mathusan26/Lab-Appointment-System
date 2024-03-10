package com.hms.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.dao.UserDAO;
import com.hms.db.DBConnection;
import com.hms.pat.PatientDAO;

@WebServlet("/userChangePassword")
public class ChangePasswordServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userId = Integer.parseInt(req.getParameter("userId"));
		String oldPassword = req.getParameter("oldPassword");
		String newPassword = req.getParameter("newPassword");
		String confirmPassword = req.getParameter("confirmPassword");
		
		PatientDAO patientDAO = new PatientDAO(DBConnection.getConn());
		//boolean f = uDAO.checkOldPassword(userId, oldPassword);
		
		
		HttpSession session = req.getSession();
		
		if(!(newPassword.equals(confirmPassword))) {
			session.setAttribute("passwordErrorMsg", "Password doesn't match");
			resp.sendRedirect("change_password.jsp");
			return;
		}
		
		if(patientDAO.checkOldPassword(userId, oldPassword)) {
			
			if(patientDAO.changePassword(userId, newPassword)) {
				
				session.setAttribute("successMsg", "Password Change Successfully. Please logIn with new password");
				session.removeAttribute("userObj");
				resp.sendRedirect("user_login.jsp");
				
			}else {
				
				session.setAttribute("errorMsg", "Something wrong on server!");
				resp.sendRedirect("change_password.jsp");
				
			}
			
		}else {
			session.setAttribute("errorMsg", "Old password incorrect");
			resp.sendRedirect("change_password.jsp");
		}
		
		
		
	}
	
	

}
