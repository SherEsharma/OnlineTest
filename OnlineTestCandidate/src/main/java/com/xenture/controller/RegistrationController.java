package com.xenture.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xenture.model.College;
import com.xenture.model.Registration;
import com.xenture.service.CandidateService;
import com.xenture.util.Utilities;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				System.out.println("In post method");
				CandidateService service = new CandidateService();
				Utilities util= new Utilities();
				
				String candidateFullName=request.getParameter("candidateName").trim();
				String candidateContactNo=request.getParameter("candidatePhone").trim();
				String candidateEmail=request.getParameter("candidateEmail").trim();
				String candidatePassYear=request.getParameter("candidatePassYear").trim();	
				String candidateFreExp= request.getParameter("candidatestatus").trim();
				String candidatePassword = request.getParameter("candidatePassword").trim();
				String candidateCollegeName =request.getParameter("candidateCollegeName").trim();
				String candidateAddress=request.getParameter("candidateCollegeName").trim();
				
				 HttpSession session = request.getSession();
				
				// validate given input  
				if (candidateFullName.isEmpty() || candidateContactNo.isEmpty() || candidateEmail.isEmpty() || 	candidatePassYear.isEmpty() || candidateFreExp.isEmpty() || candidatePassword.isEmpty()|| candidateCollegeName.isEmpty() || candidateAddress.isEmpty()) 
				{   
					response.sendRedirect("register.jsp"); 
					session.setAttribute("message", "Please fill all the filed");
					
				}
				else
				{
				System.out.println(candidatePassword);
				Registration registration = new Registration();
				College college = new College();
				registration.setCandidateFullName(candidateFullName);
				registration.setCandidateContactNo(candidateContactNo);
				registration.setCandidateAddress(candidateAddress);
				registration.setCandidateEmail(candidateEmail);				
				registration.setCandidateFresherExp(candidateFreExp);
				registration.setCandidatePassoutYear(candidatePassYear);
				registration.setCandidatePassword(candidatePassword);
				college.setCollegeName(candidateCollegeName);
				String candidateIp=util.getIPAddress(request);
				registration.setCandidateIpAddress(candidateIp);
			
				int i = service.saveCollege(college);
			
				
				System.out.println("In controller"+i);
					if(i!=0)
					{
						registration.setCollegeId(i);
						service.saveCandidate(registration);				
					}
				response.sendRedirect("candidateLogin.jsp"); 
				}
							
				
	}

}
