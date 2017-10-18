
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/Login")
public class login extends HttpServlet {

	Connection con=null;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			   System.out.println("database connected");
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String un=request.getParameter("username");
		String pwd=request.getParameter("password");
		 
		try{
		 
		Statement st=con.createStatement();
		String sql="select * from login1 where username='"+un+"' and password='"+pwd+"'";
		ResultSet rs=st.executeQuery(sql);
		PrintWriter pw=response.getWriter();
		String u="";
		String p="";
		
		
		
		if(rs.next()){
			
		u=rs.getString(1);
		 p=rs.getString(2);
		 
		 if(un.equals(u) && pwd.equals(p))
			{
				pw.println("Success");
			}
		 else
		 {
			 pw.print("unsuccess");
		 }
		}
		else
		{
			pw.println("No data");
		}
		
	}catch(Exception e)
		{
			
		}
	}
}