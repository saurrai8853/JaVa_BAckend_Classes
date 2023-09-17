package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class insertrecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public insertrecord() {
      super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
		String uid=request.getParameter("uid");
		String uname=request.getParameter("uname");
		String uage=request.getParameter("uage");
		String usalary=request.getParameter("usalary");
		String udisig=request.getParameter("udisig");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/backend","root", "root");
			PreparedStatement stmt=con.prepareStatement("insert into employee values(?,?,?,?,?)");
			
			stmt.setString(1, uid);
			stmt.setString(2,uname);
			stmt.setString(3, uage);
			stmt.setString(4, usalary);
			stmt.setString(5, udisig);
			
			stmt.execute();
			stmt.close();
			con.close();
			
			System.out.println("Data Inserted Succsfully....!<br>");
			out.print("<a href='index.html'>Home page </a>");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
