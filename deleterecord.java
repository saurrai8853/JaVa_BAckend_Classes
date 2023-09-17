package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deleterecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public deleterecord() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String uid=request.getParameter("uid");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/backend","root","root");
			PreparedStatement stmt=con.prepareStatement("delete from employee where id= ? ");
		
			stmt.setString(1, uid);
			stmt.execute();
			stmt.close();
			con.close();
			System.out.println("Data Deleted Successfully...");
			out.print("<a href='index.html'>Home page</a>");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
