package com.elearning.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.elearning.util.DBConnector;

public class CourseDAO {
	public DBConnector connector = new DBConnector();
	
	public List<String> selectAllCourse(){
		List<String> lsResult = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			con = connector.getConnection();
			
			stmt = con.createStatement();
			
			rset = stmt.executeQuery("select `course_id`,`course_name`,`course_description`,`course_batch_no`,`course_start_date`,`course_end_date` from `COURSE`");
			
			int count=0;
			while(rset.next()) {
				List<String> record = new ArrayList<String>();
				record.add(0,rset.getString("course_id").trim());
				record.add(1,rset.getString("course_name").trim());
				record.add(2,rset.getString("course_description").trim());
				record.add(3,rset.getString("course_batch_no").trim());
				record.add(4,rset.getString("course_start_date").trim());
				record.add(5,rset.getString("course_end_date").trim());
				lsResult.add(0,record.toString());
				count++;
			}
			System.out.println("Total Records : "+count);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Select All Course Error : "+e.getMessage());
		}
		
		return lsResult;
	}
	
	public List<String> selectCourseByID(String strCourseID){
		List<String> lsResult = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			con = connector.getConnection();
			
			stmt = con.createStatement();
			
			rset = stmt.executeQuery("select `course_id`,`course_name`,`course_description`,`course_batch_no`,`course_start_date`,`course_end_date` from `COURSE` where `course_id`='"+strCourseID+"'");
			
			int count=0;
			while(rset.next()) {
				List<String> record = new ArrayList<String>();
				record.add(0,rset.getString("course_id").trim());
				record.add(1,rset.getString("course_name").trim());
				record.add(2,rset.getString("course_description").trim());
				record.add(3,rset.getString("course_batch_no").trim());
				record.add(4,rset.getString("course_start_date").trim());
				record.add(5,rset.getString("course_end_date").trim());
				lsResult.add(0,record.toString());
				count++;
			}
			System.out.println("Total Records : "+count);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Select Course By ID Error : "+e.getMessage());
		}
		
		return lsResult;
	}
	
	public String insertCourse(String strCourseName,String strCourseDesp,String strCourseBathNo,String strCourseStartDate,String strCourseEndDate){
		String message = "";
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			con = connector.getConnection();
			stmt = con.createStatement();
			int rowSet = stmt.executeUpdate("Insert into `COURSE` values(uuid(),'"+strCourseName+"','"+strCourseDesp+"','"+strCourseBathNo+"','"+strCourseStartDate+"','"+strCourseEndDate+"')");
			
			if(rowSet == 1)
				message = "success";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Insert Course Error : "+e.getMessage());
		}
		
		return message;
	}
	
	public String updateCourse(String strCourseID,String strCourseName,String strCourseDesp,String strCourseBathNo,String strCourseStartDate,String strCourseEndDate){
		String message = "fail";
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = connector.getConnection();
			stmt = con.createStatement();
			int rowSet = stmt.executeUpdate("Update `COURSE` set `course_name`='"+strCourseName+"',`course_description`='"+strCourseDesp+"',`course_batch_no`='"+strCourseBathNo+"',`course_start_date`='"+strCourseStartDate+"',`course_end_date`='"+strCourseEndDate+"' where `course_id`='"+strCourseID+"'");
			
			if(rowSet == 1)
				message = "success";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Update Course Error : "+e.getMessage());
		}
		
		return message;
	}
	
	public String deleteCourse(String strCourseID){
		String message = "fail";
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = connector.getConnection();
			stmt = con.createStatement();
			int rowSet = stmt.executeUpdate("Delete from `COURSE` where `course_id`='"+strCourseID+"'");
			
			if(rowSet == 1)
				message = "success";
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Delete Course Error : "+e.getMessage());
		}
		
		return message;
	}
}
