import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.*;

public class Update extends UI {
	public static void main(String[] args) {
	new EmployeeList();UI ui = new UI();
	ui.ud.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String lname = ui.t.getText();
			String fname = ui.t1.getText();
			String age = ui.t2.getText();
			try{
				
				ui.result.updateString("LsstName", lname);
				ui.result.updateString("FirstName", fname);
				ui.result.updateString("Age", age);
				ui.result.updateRow();
				
				JOptionPane.showMessageDialog(null, "record update");
				
			}catch(Exception ex){
				
			}
			
		}
	});
	}
}
	

