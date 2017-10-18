import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class log
 */
@WebServlet("/log")
public class log extends HttpServlet {
	Connection con=null;

	public void init() throws ServletException {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			try {
				  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
				   System.out.println("database connected");
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String un=request.getParameter("username");
		String pwd=request.getParameter("password");
		 
		try{
		 
		java.sql.Statement st= con.createStatement();
		String sql="select * from registration where username='"+un+"' and password='"+pwd+"'";
		ResultSet rs= st.executeQuery(sql);
		PrintWriter pw=response.getWriter();
		String u="";
		String p="";
		
		
		
		if(rs.next()){
			
		u=rs.getString(4);
		 p=rs.getString(5);
		 
		 if(un.equals(u) && pwd.equals(p)) 
			{
				pw.print("Success");
				
			}
		
		}
		

		else
		{
			pw.print("unsuccess");
		}
		
		
		
		
		
		
		
		
		}catch(Exception e)
		{
			
		}
	
		} 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
