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
 * Servlet implementation class ExamMainController
 */
public class ExamMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamMainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.getWriter().append("Served at: ").append(request.getContextPath());*/

	System.out.println("In Exam main Controller");
	
	request.getSession().setAttribute("min",15);
	request.getSession().setAttribute("sec",0);
	
	System.out.println("Minutes "+request.getSession().getAttribute("min")+"---------------- sec   "+request.getSession().getAttribute("sec"));
	
	response.sendRedirect("exam.jsp");
	
	
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
			    
				PreparedStatement pstmt = conn.prepareStatement("select * from question");
		      
				ResultSet rs = pstmt.executeQuery();
		       System.out.println(rs);
		                   
		         if (rs.next()){
		        	 rs.getString("ques_question");
		        	 rs.getString("quest_ans_opt1");
		        	 rs.getString("quest_ans_opt2");
		        	 rs.getString("quest_ans_opt3");
		        	 rs.getString("quest_ans_opt4");
		        	 System.out.println("Success");
		        	
		          }
		        else{
		    	  System.out.println("Failed");
		    	  
		        }

			   } 
		       catch (SQLException e) {
			   // TODO Auto-generated catch block
				 e.printStackTrace();
			    }	
			
			
	}

}
