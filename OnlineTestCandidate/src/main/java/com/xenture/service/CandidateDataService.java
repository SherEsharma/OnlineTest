package com.xenture.service;

import java.sql.Connection;
import java.util.List;

import com.xenture.connection.DConnection;
import com.xenture.model.Registration;

public class CandidateDataService {
	public static void main(String[] args) {
		fatchData();
	}
	
	public static List<Registration> fatchData(){
		Connection conn=DConnection.getConnection();
		System.out.println("Db connected");
		return null;
		
		
	}

}
