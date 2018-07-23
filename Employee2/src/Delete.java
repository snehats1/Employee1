import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Delete extends UI {

	
		public static void main(String[] args) {
			new EmployeeList();
			UI ui = new UI();
			ui.del.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			try{
				ui.result.deleteRow();
				ui.st.close();
				ui.result.close();

				ui.st = ui.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				String sql = "SELECT * from Emp";
				ui.result = ui.st.executeQuery(sql);
				
				ui.result.next();
				ui.t.setText(ui.result.getString("LastName"));
				ui.t1.setText(ui.result.getString("FirstName"));
				ui.t2.setText(ui.result.getString("Age"));
				
				
			}catch(Exception ex){
				
			}
		}
	});
	
	
}
}
