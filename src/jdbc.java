import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.ResultSet;
		import java.sql.*;

public class jdbc {

	public static void main(String[] args) {
		

		
				try
				{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
		Statement st=con.createStatement();
		String sql="select * from login";
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
			System.out.println(rs.getString(1)+"  "+rs.getString(2));
		con.close();
				}
				
		catch(Exception e)
				{
		System.out.println(e);
				}
				
			}
		}
	


