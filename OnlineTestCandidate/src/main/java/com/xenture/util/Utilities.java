package com.xenture.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.*;


/**
 * 
 * @author xenturemarketing1
 * This class holds the codes that are repeatedly required in different parts of the project in
 * order to save code-writing time.
 *   
 *   
 * GETTIMESTAMP() -  Returns current timestamp
 * GETIPADDRESS() - Returns IP address of the client
 * IMAGETIMESTAMPS() - Returns TimeStamp as string for appending with image name
 *
 */

public class Utilities {

	/**
	 * 
	 * GETTIMESTAMP() - returns current timestamp in string format
	 */
	public static String getTimeStamp(){

		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date now = new Date();
	    String currentDate = sdfDate.format(now);
	    return currentDate;
	}

	/**
	 *
	 * GETIPADDRESS() - Returns the ip-Address of the client
	 * 
	 */
	public static String getIPAddress( HttpServletRequest request){

		try{
		String ip = request.getRemoteAddr();			

			if (ip.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
			    InetAddress inetAddress;				
				inetAddress = InetAddress.getLocalHost();				
			    String ipAddress = inetAddress.getHostAddress();
			    ip = ipAddress;
			}

			return ip ;
		}catch(UnknownHostException e){
			e.printStackTrace();
		}

		return "";
	}

	/***
	 * IMAGETIMESTAMPS() - Returns TimeStamp as string for appending with image name for having a
	 * 					   unique image file name
	 */
	public static String imageTimeStamps(){

		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	    Date now = new Date();
	    String currentDate = sdfDate.format(now);

	    System.out.println("*** imageTimeStamps Todays Date In Different Format : " + currentDate );		

		return currentDate;
	}	

	public static String DateToString( Date date ){

		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
	    String stringifiedDate = sdfDate.format(date);

		return stringifiedDate;
	}

	public static String getGMT( String country ){
		
		TimeZone tz = TimeZone.getTimeZone( country );
		long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
		long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset());
         minutes = Math.abs(minutes);

		String result = "";
		if (hours > 0) {
			result = String.format("(GMT+%d:%02d) %s", hours, minutes, tz.getID());
		} else {
			result = String.format("(GMT%d:%02d) %s", hours, minutes, tz.getID());
		}

		result = result.substring((result.indexOf("(")+1) , result.indexOf(")" ));

		System.out.println("Result : " + result );

		return result;
	}
}