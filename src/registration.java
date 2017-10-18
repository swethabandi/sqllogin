

import java.beans.Statement;
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

@WebServlet("/registration")
public class registration extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		int userid=Integer.parseInt(request.getParameter("userid"));        
		String firstname=request.getParameter("firstname");        
		String lastname=request.getParameter("lastname"); 
		String username=request.getParameter("username");        
		String password=request.getParameter("password"); 
		String mobileno=request.getParameter("mobileno"); 
		Connection con=null;        
		java.sql.Statement stmt=null;        
		PrintWriter out=response.getWriter();        
		try       
		{              
		Class.forName("oracle.jdbc.driver.OracleDriver");              
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root" );              
		stmt=con.createStatement();              
		int i=stmt.executeUpdate("insert into registration values('"+userid+"', '"+firstname+"', '"+lastname+"','"+username+"','"+password+"','"+mobileno+"')");
		if(i>0)                
		out.println("Inserted Successfully");              
		else                
		out.println("Insert Unsuccessful");        
		}        
		catch(Exception e)        
		{          out.println(e);               
		 }    
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String un=request.getParameter("username");
		String pwd=request.getParameter("password");

		int userid=Integer.parseInt(request.getParameter("userid"));        
		String firstname=request.getParameter("firstname");        
		String lastname=request.getParameter("lastname"); 
		//String username=request.getParameter("username");        
		//String password=request.getParameter("password"); 
		String mobileno=request.getParameter("mobileno"); 
		try{
		 
		Connection con = null;
		Statement st=(Statement) con.createStatement();
		String sql="select(userid,firstname,lastname,mobilrno) from registration  where username='"+un+"' and password='"+pwd+"'";
		ResultSet rs=((java.sql.Statement) st).executeQuery(sql);
		PrintWriter pw=response.getWriter();
		String u="";
		String p="";
		
		String sql1="select * from login  where username='"+un+"' and password='"+pwd+"'";
		ResultSet rs1=((java.sql.Statement) st).executeQuery(sql1);
		PrintWriter pw1=response.getWriter();
		String u1="";
		String p1="";
		
		
		if(rs1.next()){
			
		u=rs.getString(4);
		 p=rs.getString(5);
		 
		 u1=rs1.getString(1);
		 p1=rs1.getString(2);
		 
		 if(u.equals(u1) && p.equals(p1))
			{
				pw1.println("Success");
				System.out.println(userid);
				System.out.println(firstname);
				System.out.println(lastname);
				System.out.println(mobileno);
			}
		 else
		 {
			 pw1.print("unsuccess");
		 }
		}
		
		
	}catch(Exception e)
		{
			
		}
		}
	}


