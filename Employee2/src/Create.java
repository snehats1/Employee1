import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Create  extends UI {
	public static void main(String[] args) {
		new EmployeeList();
		UI ui = new UI();
		ui.newrec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				ui.t.setText(" ");
				ui.t1.setText(" ");
				ui.t2.setText(" ");
	}
	
});
}
}