import java.sql.*;


public class EmployeeList {
	
	Connection con;
	Statement st;
	ResultSet result;
	
	public EmployeeList(){
		
		connect();
	}
	
	public void connect() {
		
		try{
			
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
			
			String db="C:\\Users\\home\\Desktop";
			String url = "jdbc:ucanaccess://" +db;
			con = DriverManager.getConnection(url);
			st = con.createStatement(result.TYPE_SCROLL_INSENSITIVE,result.CONCUR_UPDATABLE);
			String sql = "SELECT * from Emp";
			result = st.executeQuery(sql);
			
			/*while(result.next())
			{
				String lName = result.getString("LastName");
				String fName = result.getString("FirstName");
				String age = result.getString("Age");
				
				System.out.println(lName +" " +fName +" "+ age);
			}*/
			
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	public static void main(String[] args){
		
		new EmployeeList();
		
	}

}
