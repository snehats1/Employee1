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
	JButton b2 = new JButton("Previous");
	JButton b3 = new JButton("last");
	JButton b4 = new JButton("First");
	
	JButton ud = new JButton("Update");
	JButton del = new JButton("Delete");
	JButton newrec = new JButton("New Record");
	JButton save = new JButton("Save");
	
	public UI(){
		
		frame();
		btnAction();
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
		p.add(b2);
		p.add(b3);
		p.add(b4);
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
		
		
	}
	
	public void btnAction(){
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				try{
					
					if(result.next()){
						t.setText(result.getString("LastName"));
						t1.setText(result.getString("FirstName"));
						t2.setText(result.getString("Age"));
					}
					else{
						result.previous();
						//JOptionPane.showMessageDialog(null, "No message", "Error Message", JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(null,"Np mpre records");
					}
					
				}catch(Exception ex){
					
					
				}
				
			}
		});
		
		
		b2.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				try{
					System.out.println("going in this loop for previous");
					if(result.previous()){
						System.out.println("going in this loop for previous");
						t.setText(result.getString("LastName"));
						t1.setText(result.getString("FirstName"));
						t2.setText(result.getString("Age"));
					}
					else{
						System.out.println("going in else loop for previous");
						result.next();
						//JOptionPane.showMessageDialog(null, "No message", "Error Message", JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(null,"Np mpre records");
					}
					
				}catch(Exception ex){
					
					
				}
				
			}
		});
		
		b3.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				try{
					result.last();
					t.setText(result.getString("LastName"));
					t1.setText(result.getString("FirstName"));
					t2.setText(result.getString("Age"));
					
					
					
				}catch(Exception ex){
					
					
				}
				
			}
		});
		b4.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				try{
					result.first();
					t.setText(result.getString("LastName"));
					t1.setText(result.getString("FirstName"));
					t2.setText(result.getString("Age"));
					
					
					
				}catch(Exception ex){
					System.out.println(ex);
					
				}
				
			}
		});
		
		ud.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String lname = t.getText();
				String fname = t1.getText();
				String age = t2.getText();
				try{
					
					result.updateString("LsstName", lname);
					result.updateString("FirstName", fname);
					result.updateString("Age", age);
					result.updateRow();
					
					JOptionPane.showMessageDialog(null, "record update");
					
				}catch(Exception ex){
					
				}
				
			}
		});
		
		del.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					result.deleteRow();
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
		
		newrec.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				t.setText(" ");
				t1.setText(" ");
				t2.setText(" ");
				
			}
		});
		
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
