import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.Callable;

import oracle.jdbc.*;
import java.math.*;
import java.io.*;
import java.awt.*;
import oracle.jdbc.pool.OracleDataSource;

//    This program shows how to get a record set from an Oracle stored 
//    procedure or function.
//    Suppose we have a table students(sid, firstname, lastname, status, 
//    gpa, email), and a stored function called getstudents in a package, 
//    which returns all students records. 
//    To return a result set from a stored procedure, you must use a 
//    cursor variable. Cursor variables are basically pointers to cursors, 
//    and you use them to pass around references to cursors, such as a 
//    parameter to a stored procedure. The PL/SQL type of a cursor variable 
//    is REF CURSOR.
//
//    create a type of ref cursor and a function that returns a
//      result of ref cursor:
//
//    create or replace package refcursor_jdbc1 as
//    type ref_cursor is ref cursor;
//    function getstudents
//    return ref_cursor;
//    end;
//    show errors
//
//    create or replace package body refcursor_jdbc1 as
//    function getstudents
//    return ref_cursor as
//    rc ref_cursor;
//    begin
//    open rc for
//    select * from students;
//    return rc;
//    end;
//    end;
//    /
//    show errors
public class mydemo3 {
	public static void main (String args []) throws SQLException {
		System.out.println("Press 1 to run a query");
        System.out.println("Press 2 to exit");
        Scanner reader20 = new Scanner(System.in);
        int choice = reader20.nextInt();
        while(choice==1){
        	try
        	{	CallableStatement cs = null;
        		//Connection to Oracle server
        		Class.forName("oracle.jdbc.driver.OracleDriver");
        		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","PLASH","thepresident");
        		//Prepare to call stored procedure:
	        	System.out.println("Press 1 to run Query 1");
	        	System.out.println("Press 2 to run Query 2");
	        	System.out.println("Press 3 to run Query 3");
	        	System.out.println("Press 4 to run Query 4");
	        	System.out.println("Press 5 to run Query 5");
	        	System.out.println("Press 6 to run Query 6");
	        	System.out.println("Press 7 to run Query 7");
	        	System.out.println("Press 8 to run Query 8");
	        	System.out.println("Press 8 to run Query 9");
	        	System.out.println("Press 0 to run Query 10");
	        	Scanner reader0 = new Scanner(System.in);  // Reading from System.in
	        	System.out.println("Enter a number: ");
	        	int n1 = reader0.nextInt();
	        	switch(n1){
	        	case 1:
	        		break;
	        	case 2:
	        		System.out.println("Press 1 to show students");
	        		System.out.println("Press 2 to show courses");
	        		System.out.println("Press 3 to show prerequisites");
	        		System.out.println("Press 4 to show Classes");
	        		System.out.println("Press 5 to show enrollments");
	        		System.out.println("Press 6 to show logs");
	        		Scanner reader = new Scanner(System.in);  // Reading from System.in
	        		System.out.println("Enter a number: ");
	        		int n = reader.nextInt();
	        		switch (n) {
	        		case 1:
	        			cs = con.prepareCall("begin ? := project2.show_students; end;");
		        		//register the out parameter (the first parameter)
		        		cs.registerOutParameter(1, OracleTypes.CURSOR);
		        		// execute and retrieve the result set
		        		cs.execute();
		    	        ResultSet rs = (ResultSet)cs.getObject(1);
		    	        // print the results
		    	        while (rs.next()) {
		    	            System.out.println(rs.getString(1) + "\t" +
		    	            	rs.getString(2) + "\t" + rs.getString(3) + "\t" +
		    	                rs.getString(4) + 
		    	                "\t" + rs.getDouble(5) + "\t" +
		    	                rs.getString(6));
		    	        }
		    	        break;
	        		case 2:
		        		cs = con.prepareCall("begin ? := project2.show_courses; end;");
		        		//register the out parameter (the first parameter)
		        		cs.registerOutParameter(1, OracleTypes.CURSOR);
		        		// execute and retrieve the result set
		        		cs.execute();
		    	        ResultSet rs1 = (ResultSet)cs.getObject(1);
		    	        // print the results
		    	        while (rs1.next()) {
		    	            System.out.println(rs1.getString(1) + "\t" +
		    	                rs1.getString(2) + "\t" + rs1.getString(3));
		    	        }
		    	        break;
	        		case 3:
		        		cs = con.prepareCall("begin ? := project2.show_pre; end;");
		        		//register the out parameter (the first parameter)
		        		cs.registerOutParameter(1, OracleTypes.CURSOR);
		        		// execute and retrieve the result set
		        		cs.execute();
		    	        ResultSet rs2 = (ResultSet)cs.getObject(1);
		    	        // print the results
		    	        while (rs2.next()) {
		    	            System.out.println(rs2.getString(1) + "\t" +
		    	                rs2.getString(2) + "\t" + rs2.getString(3) + "\t" +
		    	    	                rs2.getString(4));
		    	        }
		    	        break;
	        		case 4:
		        		cs = con.prepareCall("begin ? := project2.show_classes; end;");
		        		//register the out parameter (the first parameter)
		        		cs.registerOutParameter(1, OracleTypes.CURSOR);
		        		// execute and retrieve the result set
		        		cs.execute();
		    	        ResultSet rs3 = (ResultSet)cs.getObject(1);
		    	        // print the results
		    	        while (rs3.next()) {
		    	            System.out.println(rs3.getString(1) + "\t" +
		    	                rs3.getString(2) + "\t" + rs3.getString(3) + "\t" +
		    	    	                rs3.getString(4) + "\t" +
		    	    	                rs3.getString(5) + "\t" + rs3.getString(6) + "\t" +
		    	    	                rs3.getString(7) + "\t" +
		    	    	                rs3.getString(8));
		    	        }
		    	        break;
	        		case 5:
		        		cs = con.prepareCall("begin ? := project2.show_enrollments; end;");
		        		//register the out parameter (the first parameter)
		        		cs.registerOutParameter(1, OracleTypes.CURSOR);
		        		// execute and retrieve the result set
		        		cs.execute();
		    	        ResultSet rs4 = (ResultSet)cs.getObject(1);
		    	        // print the results
		    	        while (rs4.next()) {
		    	            System.out.println(rs4.getString(1) + "\t" +
		    	                rs4.getString(2) + "\t" + rs4.getString(3));
		    	        }
		    	        break;
	        		case 6:
		        		cs = con.prepareCall("begin ? := project2.show_logs; end;");
		        		//register the out parameter (the first parameter)
		        		cs.registerOutParameter(1, OracleTypes.CURSOR);
		        		// execute and retrieve the result set
		        		cs.execute();
		    	        ResultSet rs5 = (ResultSet)cs.getObject(1);
		    	        // print the results
		    	        while (rs5.next()) {
		    	            System.out.println(rs5.getString(1) + "\t" +
		    	                rs5.getString(2) + "\t" + rs5.getString(3)+ "\t" +
		    	    	                rs5.getString(4) + "\t" +
		    	    	                rs5.getString(5) + "\t" + rs5.getString(6));
		    	        }
		    	        break;
	        		}
	        		break;
	        	case 3:
	        		System.out.println("Enter Student sid");
	        		Scanner reader3 = new Scanner(System.in);
	        		String sid1 = reader3.nextLine();
	        		System.out.println("Enter Student Firstname");
	        		Scanner reader4 = new Scanner(System.in);
	        		String fname = reader4.nextLine();
	        		System.out.println("Enter Student Lastname");
	        		Scanner reader5 = new Scanner(System.in);
	        		String lname = reader4.nextLine();
	        		System.out.println("Enter Student Status");
	        		Scanner reader6 = new Scanner(System.in);
	        		String status = reader4.nextLine();
	        		System.out.println("Enter Student GPA");
	        		Scanner reader7 = new Scanner(System.in);
	        		String gpa = reader7.nextLine();
	        		System.out.println("Enter Student Email");
	        		Scanner reader8 = new Scanner(System.in);
	        		String email = reader8.nextLine();
	        		cs = con.prepareCall("begin insertStudents(:1,:2,:3,:4,:5,:6); end;");
        			cs.setString(1, sid1);
        			cs.setString(2, fname);
        			cs.setString(3, lname);
        			cs.setString(4, status);
        			cs.setString(5, gpa);
        			cs.setString(6, email);
        			// execute and retrieve the result set
        			cs.execute();
        			break;
	        	case 4:
	        		System.out.println("Enter Sid");
	        		Scanner reader1 = new Scanner(System.in);
	        		String sid = reader1.nextLine();
	        		cs = con.prepareCall("begin :1 := project2.query_4(:2); end;");
        			cs.setString(2, sid);
        			//register the out parameter (the first parameter)
        			cs.registerOutParameter(1, OracleTypes.CURSOR);
        			// execute and retrieve the result set
        			cs.execute();
        			ResultSet rs6 = (ResultSet)cs.getObject(1);
        			// print the results
        			while (rs6.next()) {
        				System.out.println(rs6.getString(1) + "\t" +
        						rs6.getString(2) + "\t" + rs6.getString(3)+ "\t" +
        						rs6.getString(4) + "\t" +
        						rs6.getString(5) + "\t" + rs6.getString(6) + "\t" +
        						rs6.getString(7) + "\t" +
        						rs6.getString(8) + "\t");
        			}
        			break;
	        	case 5:
	        		break;
	        	case 6:
	        		System.out.println("Enter Cid");
	        		Scanner reader2 = new Scanner(System.in);
	        		String cid = reader2.nextLine();
	        		//System.out.println(sid);
	        		cs = con.prepareCall("begin :1 := project2.query_6(:2); end;");
        			cs.setString(2, cid);
        			//register the out parameter (the first parameter)
        			cs.registerOutParameter(1, OracleTypes.CURSOR);
        			// execute and retrieve the result set
        			cs.execute();
        			ResultSet rs7 = (ResultSet)cs.getObject(1);
        			// print the results
        			while (rs7.next()) {
        				System.out.println(rs7.getString(1) + "\t" +
        						rs7.getString(2) + "\t" + rs7.getString(3)+ "\t" +
        						rs7.getString(4) + "\t" +
        						rs7.getString(5) + "\t" + rs7.getString(6) + "\t" +
        						rs7.getString(7));
        			}
        			break;
	        	case 7:
	        		System.out.println("Enter Student sid");
	        		Scanner reader22 = new Scanner(System.in);
	        		String sid5 = reader22.nextLine();
	        		System.out.println("Enter Classid");
	        		Scanner reader25 = new Scanner(System.in);
	        		String classid4 = reader25.nextLine();
	        		cs = con.prepareCall("begin :1 := project2.query_7(:2,:3); end;");
	        		cs.registerOutParameter(1,OracleTypes.INTEGER);
	        		cs.setString(2, sid5);
	        		cs.setString(3, classid4);
	        		cs.execute();
	        		//System.out.println(flag);
	        		break;
	        	case 8:
	        		System.out.println("Enter Student sid");
	        		Scanner reader9 = new Scanner(System.in);
	        		String sid2 = reader9.nextLine();
	        		System.out.println("Enter classid");
	        		Scanner reader10 = new Scanner(System.in);
	        		String classid1 = reader10.nextLine();
	        		cs = con.prepareCall("begin query8(:1,:2); end;");
	        		cs.setString(1, sid2);
	        		cs.setString(2, classid1);
	        		// execute and retrieve the result set
	        		cs.execute();
	        		break;
	        	case 9:
	        		System.out.println("Enter Student sid");
	        		Scanner reader11 = new Scanner(System.in);
	        		String sid3 = reader11.nextLine();
	        		cs = con.prepareCall("begin query9(:1); end;");
	        		cs.setString(1, sid3);
	        		// execute and retrieve the result set
	        		cs.execute();
	        	break;
	        	case 10:
	        		break;
	        	}
	        	cs.close();
		        con.close();
        	}
        
        
	   //close the result set, statement, and the connection
	        catch (SQLException ex) { 
	        	//System.out.println(ex.getErrorCode());
	        	if(ex.getErrorCode()== 20001 ){
	        		System.out.println("The sid is invalid");
	        	}
	        	if(ex.getErrorCode()== 20002 ){
	        		System.out.println("The classid is invalid");
	        	}
	        	if(ex.getErrorCode()== 20003 ){
	        		System.out.println("The class has no students");
	        	}
	        	if(ex.getErrorCode()== 20004 ){
	        		System.out.println("This student is not enrolled in any classes");
	        	}
	        	if(ex.getErrorCode()== 20005){
	        		System.out.println("The drop is not permitted because another class uses it as a prerequisite");
	        	}
	        	if(ex.getErrorCode()== 20006){
	        		System.out.println("The student has not taken any course");
	        	}
	        	if(ex.getErrorCode()== 20007){
	        		System.out.println("No student is enrolled in the class");
	        	}
	        	if(ex.getErrorCode()== 20008){
	        		System.out.println("The class now has no students");
	        	}
	        	if(ex.getErrorCode()== 20009){
	        		System.out.println("class_size>limit");
	        		System.out.println("The class is closed");
	        	}
	        	if(ex.getErrorCode()== 20010){
	        		System.out.println("The student is already in the class");
	        	}
	        	if(ex.getErrorCode()== 20011){
	        		System.out.println("Students cannot be enrolled in more than three classes in the same semester");
	        	}
	        	if(ex.getErrorCode()== 20012){
	        		System.out.println("Prerequisite courses have not been completed");
	        	}
        	}
        	catch (Exception e) {System.out.println ("\n*** other Exception caught ***\n");}
        	System.out.println("Press 1 to run a query");
            System.out.println("Press 2 to exit");
            Scanner reader21 = new Scanner(System.in);
            choice = reader21.nextInt();
        }
        if(choice==2){
        	System.out.println("Thank You!!");
        	System.exit(0);
        }
   }     	
}