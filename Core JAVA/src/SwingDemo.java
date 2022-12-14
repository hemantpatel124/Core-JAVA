import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.PreparableStatement;

public class SwingDemo implements ActionListener{
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3,b4;
	
	public SwingDemo() {
		JFrame frm= new JFrame("MyApp");  
		
	    frm.setVisible(true); 
	    frm.setSize(750,500);  
	    frm.setLayout(null);  

	   
	    l1=new JLabel("Id : ");
	    l1.setBounds(100, 50, 100, 30);
	    frm.add(l1);
		t1=new JTextField();  
	    t1.setBounds(200,50, 200,30);  
	    frm.add(t1); 
	    
	    l2=new JLabel("Name : ");
	    l2.setBounds(100, 100, 100, 30);
	    frm.add(l2);
	    t2=new JTextField();  
	    t2.setBounds(200,100, 200,30);  
	    frm.add(t2);  
	    
	    l3=new JLabel("Contact : ");
	    l3.setBounds(100, 150, 100, 30);
	    frm.add(l3);
	    t3=new JTextField();  
	    t3.setBounds(200,150, 200,30);  
	    frm.add(t3); 
	    
	    l4=new JLabel("Email : ");
	    l4.setBounds(100, 200, 100, 30);
	    frm.add(l4);
	    t4=new JTextField();  
	    t4.setBounds(200,200, 200,30);  
	    frm.add(t4);
	    
	    l5=new JLabel("Address : ");
	    l5.setBounds(100, 250, 100, 30);
	    frm.add(l5);
	    t5=new JTextField();  
	    t5.setBounds(200,250, 200,30);  
	    frm.add(t5);
	    
	    b1=new JButton(" Insert ");
	    b1.setBounds(100, 350, 100, 30);
	    frm.add(b1);
	    
	    b2=new JButton(" Search ");
	    b2.setBounds(300, 350, 100, 30);
	    frm.add(b2);
	    
	    b3=new JButton(" Update ");
	    b3.setBounds(100, 400, 100, 30);
	    frm.add(b3);
	    
	    b4=new JButton(" Delete ");
	    b4.setBounds(300, 400, 100, 30);
	    frm.add(b4);
	    
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	    b4.addActionListener(this);
	    
	}
	
	public static void main(String[] args) {
		new SwingDemo();
		
	}
	
	public static Connection createConnection() {
		Connection conn=null;
		
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/swing", "root", "");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==b1) {
				System.out.println("Insert button clicked");
				int id=Integer.parseInt(t1.getText());
				String name=t2.getText();
				long contact=Long.parseLong(t3.getText());
				String email=t4.getText();
				String address= t5.getText();
				
				try {
					
					Connection conn=SwingDemo.createConnection();
					String sql="insert into student(id, name, contact, email, address) values(?,?,?,?,?)";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setLong(3, contact);
					ps.setString(4, email);
					ps.setString(5, address);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Inserte Successfull..");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			else if(e.getSource()==b2) {
				
				int id=Integer.parseInt(t1.getText());
				
				try {
					Connection conn=SwingDemo.createConnection();
					String sql="select *from student where id=?";
					PreparedStatement st=conn.prepareStatement(sql);
					st.setInt(1, id);
					ResultSet rs=st.executeQuery();
					if(rs.next()){
						
						t1.setText(String.valueOf(rs.getString("id")));
						t2.setText(rs.getString("name"));
						t3.setText(rs.getString("contact"));
						t4.setText(String.valueOf(rs.getString("email")));
						t5.setText(rs.getString("address"));
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Data not found !...");

						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						t5.setText("");
					}
				}
				catch (Exception e2) {
					e2.printStackTrace();
				}
				
				
			}
			else if(e.getSource()==b3) {
				
				int id=Integer.parseInt(t1.getText());
				String name=t2.getText();
				long contact=Long.parseLong(t3.getText());
				String email=t4.getText();
				String address= t5.getText();
				
				try {
					
					Connection conn=SwingDemo.createConnection();
					String sql="update student set name=?, contact=?, email=?, address=? where id=?";
					PreparedStatement ps=conn.prepareStatement(sql);

					ps.setString(1, name);
					ps.setLong(2, contact);
					ps.setString(3, email);
					ps.setString(4, address);
					ps.setInt(5,id);
					
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data Upadate Successfull..");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			else if(e.getSource()==b4) {
				
				int id=Integer.parseInt(t1.getText());
				try
				{
					Connection conn=SwingDemo.createConnection();
					String sql="delete from student where id=?";
					PreparedStatement st=conn.prepareStatement(sql);
					st.setInt(1, id);
					st.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data Deleted Successfull..");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					
				}
				catch (Exception e2) {
					e2.printStackTrace();
				}
			}
	}
}
