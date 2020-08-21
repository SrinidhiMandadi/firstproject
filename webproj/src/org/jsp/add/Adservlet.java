package org.jsp.add;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.lang.ClassNotFoundException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")

public class Adservlet extends HttpServlet
{	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
			String companyname= req.getParameter("companyname");
			String contactname= req.getParameter("contactname");
			String Email= req.getParameter("Email");
			String Phone= req.getParameter("Phone");
			String Message= req.getParameter("Message");
			System.out.println(companyname+" "+contactname);
			String url="jdbc:mysql://localhost:3306?user=root&password=12345";

		String query = "insert into test.register values(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1,companyname);
			preparedStatement.setString(2,contactname);
			preparedStatement.setString(3,Email);
			preparedStatement.setString(4,Phone);
			preparedStatement.setString(5,Message);
			preparedStatement.executeUpdate();
			System.out.println("Done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}