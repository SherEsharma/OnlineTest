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
import com.xenture.model.College;
import com.xenture.model.Registration;
import com.xenture.service.CandidateService;
import com.xenture.util.Utilities;

/**
 * Servlet implementation class CandidateLoginController
 */
public class CandidateLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateLoginController() {
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
		String candidateEmail=request.getParameter("candidateEmail");
		String candidatePassword=request.getParameter("candidatePassword");
		
			System.out.println(candidateEmail+" "+candidatePassword);
		
			try {	
			    Connection conn=DConnection.getConnection();
			    HttpSession session = request.getSession();
				PreparedStatement pstmt = conn.prepareStatement("select candidate_email,candidate_password from registration where candidate_email=? and candidate_password=?");
		        pstmt.setString(1, candidateEmail);
		        pstmt.setString(2, candidatePassword);
		       
 
		        ResultSet rs = pstmt.executeQuery();
		       System.out.println(rs);
		                   
		         if (rs.next()){
		        	System.out.println("Success");
		        	response.sendRedirect("instructions.jsp");		        	
		        	
		          }
		        else{
		    	  System.out.println("Failed");
		    	  session.setAttribute("message", "Email or password is incorrect.");
		          response.sendRedirect("candidateLogin.jsp");
		        }

			   } 
		       catch (SQLException e) {
			   // TODO Auto-generated catch block
				 e.printStackTrace();
			    }	
			
			
			
			
	}

}
