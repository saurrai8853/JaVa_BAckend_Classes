package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class displayrecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public displayrecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/backend","root","root");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from employee");
			while(rs.next()) {
				out.println(rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getInt(4)+":"+rs.getString(5)+":");  
			}
			
			
			stmt.close();
			con.close();
			System.out.println("Data fetch Successfully..");
			out.print("<a href='index.html'>Home page </a>");
			
		} catch (Exception e) {
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
