

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String n=request.getParameter("userid");  
		String p=request.getParameter("firstname");  
		String e=request.getParameter("lastname");  
		String c=request.getParameter("username"); 
		String b=request.getParameter("password"); 
		String a=request.getParameter("mobileno");  
		          
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		  
		PreparedStatement ps=con.prepareStatement("insert into registration values(?,?,?,?,?,?)");  
		  
		ps.setString(1,n);  
		ps.setString(2,p);  
		ps.setString(3,e);  
		ps.setString(4,c);  
		ps.setString(5,b);  
		ps.setString(6,a);  
		          
		int i=ps.executeUpdate();  
		if(i>0)  
		out.println("You are successfully registered...");  

		          
		}catch (Exception se) {
			se.printStackTrace();
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
