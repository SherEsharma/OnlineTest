package com.xenture.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.xenture.connection.DConnection;
import com.xenture.model.College;
import com.xenture.model.Registration;

public class CandidateService {
	
	public int saveCollege(College college){
		
		Connection conn= null;
		PreparedStatement pstmt= null;
		int status=0;
		ResultSet rs=null;
		
		try{
		conn=DConnection.getConnection();
		System.out.println("Db Connected");
		System.out.println("in method "+college.getCollegeName());
		
		String sql="INSERT INTO `college` ( `college_name`) VALUES (?)";
		pstmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, college.getCollegeName());
		status=pstmt.executeUpdate();
		
		rs = (ResultSet) pstmt.getGeneratedKeys();
		
		
		 if(rs != null && rs.next()){
             System.out.println("Generated Emp Id: "+rs.getInt(1));
         }
		 return rs.getInt(1);
		}catch (Exception e) {
			e.printStackTrace();
		}
	

		
		return 0;
		
	}
	
	
	public int saveCandidate(Registration registration){
		System.out.println("In service method ofr registratio");
		
		
		Connection conn= null;
		PreparedStatement pstmt= null;
		int status=0;
		ResultSet rs=null;
		
		try{
		conn=DConnection.getConnection();
		System.out.println("Db Connected");
		
		
		String sql="INSERT INTO `xenture_online_test`.`registration` ( `candidate_full_name`, `candidate_email`, `candidate_contact_no`, `college_id`, `candidate_passout_year`, `candidate_fresher_exp`, `candidate_address`, `candidate_password`,  `candidate_ip_address`) VALUES (?,?,?,?,?,?,?,?,?);";
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, registration.getCandidateFullName());
		pstmt.setString(2, registration.getCandidateEmail());
		pstmt.setString(3, registration.getCandidateContactNo());
		pstmt.setInt(4, registration.getCollegeId());
		pstmt.setString(5, registration.getCandidatePassoutYear());
		pstmt.setString(6, registration.getCandidateFresherExp());
		pstmt.setString(7, registration.getCandidateAddress());
		pstmt.setString(8, registration.getCandidatePassword());
		pstmt.setString(9, registration.getCandidateIpAddress());
		int i=status=pstmt.executeUpdate();
		System.out.println(i+"Data insert");
	
		}catch (Exception e) {
			e.printStackTrace();
		}
	

		
		return 0;
	}

}
