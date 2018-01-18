package com.xenture.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xenture.connection.DConnection;

/**
 * Servlet implementation class AdminControllers
 */
public class AdminControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminControllers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminEmail = request.getParameter("adminEmailId");
		String password = request.getParameter("adminPassword");
		//shuhbham
		
		try {
			Connection conn = DConnection.getConnection();
			HttpSession session = request.getSession();
			PreparedStatement pstmt = conn.prepareStatement(
					"select admin_email_id,admin_password from admin where admin_email_id=? and admin_password=?");
			pstmt.setString(1, adminEmail);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(rs);

			if (rs.next()) {
				System.out.println("Success");
				response.sendRedirect("dashboard.jsp");

			} else {
				System.out.println("invalid ");
				session.setAttribute("message", "Email or password is incorrect.");
				response.sendRedirect("adminlogin.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
