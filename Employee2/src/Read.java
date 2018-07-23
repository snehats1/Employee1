import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Read extends UI{
	public static void main(String[] args) {
		new EmployeeList();
		UI ui = new UI();
		ui.b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				try{
					
					if(ui.result.next()){
						ui.t.setText(ui.result.getString("LastName"));
						ui.t1.setText(ui.result.getString("FirstName"));
						ui.t2.setText(ui.result.getString("Age"));
					}
					else{
						ui.result.previous();
						//JOptionPane.showMessageDialog(null, "No message", "Error Message", JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(null,"Np mpre records");
					}
					
				}catch(Exception ex){
					
					
				}
				
			}
		});
	}
}	
		
