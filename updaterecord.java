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

public class updaterecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public updaterecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
		String uid=request.getParameter("uid");
		String uname=request.getParameter("uname");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/backend","root","root");
			PreparedStatement stmt=con.prepareStatement("update employee set name=? where id=?");
		
			stmt.setString(1, uname);
			stmt.setString(2, uid);
			
			stmt.execute();
			stmt.close();
			con.close();
			System.out.println("Data Updated Succesfully..");
			out.print("<a href='index.html'>Home page </a>");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
