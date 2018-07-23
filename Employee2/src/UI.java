import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class UI extends EmployeeList{
	
	JFrame f;
	JLabel fName;
	JLabel lName;
	JLabel age;
	
	JTextField t;
	JTextField t1;
	JTextField t2;
	
	JButton b1 = new JButton("Next");
		
	JButton ud = new JButton("Update");
	JButton del = new JButton("Delete");
	JButton newrec = new JButton("New Record");
	JButton save = new JButton("Save");
	
	public UI(){
		
		frame();
		
	}
	
	public void frame(){
		
		f = new JFrame();
		f.setVisible(true);
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		lName = new JLabel ("Last Name");
		fName = new JLabel("First Name");
		age = new JLabel("Age");
		
		t = new JTextField(10);
		t1 = new JTextField(10);
		t2 = new JTextField(10);
		
		
		JPanel p = new JPanel();
		p.add(lName);
		p.add(t);
		p.add(fName);
		p.add(t1);
		p.add(age);
		p.add(t2);
		p.add(b1);
		p.add(ud);
		p.add(del);
		p.add(newrec);
		p.add(save);
		
		
		f.add(p);
		try{
			
			result.next();
			t.setText(result.getString("LastName"));
			t1.setText(result.getString("FirstName"));
			t2.setText(result.getString("Age"));
			
		} catch(Exception ex){
			System.out.println(ex);
		}
		
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String lname = t.getText();
				String fname = t1.getText();
				String age = t2.getText();
				
				try{
					
					result.moveToInsertRow();
					result.updateString("LastName", lname);
					result.updateString("FirstName", fname);
					result.updateString("Age", age);
					result.insertRow();
					st.close();
					result.close();
					st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					String sql = "SELECT * from Emp";
					result = st.executeQuery(sql);
					
					result.next();
					t.setText(result.getString("LastName"));
					t1.setText(result.getString("FirstName"));
					t2.setText(result.getString("Age"));
					
					
				}catch(Exception ex){
					
				}
			}
		});
	}
	
	public static void main(String[] args){
		new EmployeeList();
		new UI();
	}

}
