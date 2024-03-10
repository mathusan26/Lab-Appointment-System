package com.hms.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.dao.TestDAO;
import com.hms.db.DBConnection;
import com.hms.entity.Test;

@WebServlet("/updateTest")
public class UpdateTestServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			try {

				String testName = req.getParameter("test_name");
				String TestDescription = req.getParameter("test_description");
				double price = Double.parseDouble(req.getParameter("price"));
				
				int id = Integer.parseInt(req.getParameter("testId"));

				Test test = new Test(id, testName,  TestDescription, price);

				TestDAO testDAO = new TestDAO(DBConnection.getConn());

				boolean f = testDAO.updateTestName(test);

				HttpSession session = req.getSession();

				if (f == true) {
					session.setAttribute("successMsg", "Test update Successfully");
					resp.sendRedirect("admin/test/view_test.jsp");

				} else {
					session.setAttribute("errorMsg", "Something went wrong on server!");
					resp.sendRedirect("admin/test/view_test.jsp");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

