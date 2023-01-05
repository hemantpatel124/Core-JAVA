package Module_3_Database;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSet.*;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class SwingAssignment extends JFrame  implements ActionListener{
		
		JLabel l1,l2,l3,l4,l5,l6,l7,l8;
		JTextField txtId,txtName,txtAdd,txtContact;
		JRadioButton r1,r2;
		JButton btnExit,btnRegister,btnDelete,btnUpdate,btnReset,btnRefresh;
		JTable tbl;
		JScrollPane scroll; 
		public SwingAssignment() {
				
				JFrame fr=new JFrame("REGISTRATION FORM");
				fr.setVisible(true);
				fr.setSize(1024, 700);
				fr.setLayout(null);
				
				
				l1=new JLabel("Registration Form");
				l1.setBounds(70, 50, 200, 30);
				fr.add(l1);
			
				tbl=new JTable();
				tbl.setBounds(370, 70, 600, 380);
				scroll.setViewportView(tbl);
				fr.add(tbl); 
			
				btnRefresh=new JButton("Refresh");
				btnRefresh.setBounds(500, 460,300, 20);
				fr.add(btnRefresh);
				
				l2=new JLabel("Id");
				l2.setBounds(50, 100, 200, 30);
				fr.add(l2);
				txtId=new JTextField();
				txtId.setBounds(150, 100, 200, 30);
				fr.add(txtId);
				
				l3=new JLabel("Name");
				l3.setBounds(50, 150, 200, 30);
				fr.add(l3);
				txtName=new JTextField();
				txtName.setBounds(150, 150, 200, 30);
				fr.add(txtName);
				
				l4=new JLabel("Gender");
				l4.setBounds(50, 200, 200, 30);
				fr.add(l4);
				r1=new JRadioButton("Male");
				r1.setBounds(150, 200, 100, 30);
				fr.add(r1);
				r2=new JRadioButton("Female");
				r2.setBounds(250, 200, 100, 30);
				fr.add(r2);
				ButtonGroup bg=new ButtonGroup();
				bg.add(r1);
				bg.add(r2);
				
				
				l5=new JLabel("Address");
				l5.setBounds(50, 250, 200, 30);
				fr.add(l5);
				txtAdd=new JTextField();
				txtAdd.setBounds(150, 250, 200, 30);
				fr.add(txtAdd);
				
				l6=new JLabel("Contact");
				l6.setBounds(50, 300, 200, 30);
				fr.add(l6);
				txtContact=new JTextField();
				txtContact.setBounds(150, 300, 200, 30);
				fr.add(txtContact);
				
				
				btnExit=new JButton("Exit");
				btnExit.setBounds(50, 350,100, 30);
				fr.add(btnExit);
				
				btnRegister=new JButton("Register");
				btnRegister.setBounds(200, 350,150, 30);
				fr.add(btnRegister);
				
				btnDelete=new JButton("Delete");
				btnDelete.setBounds(50, 400,100, 30);
				fr.add(btnDelete);
				
				btnUpdate=new JButton("Update");
				btnUpdate.setBounds(200, 400,150, 30);
				fr.add(btnUpdate);
				
				btnReset=new JButton("Reset");
				btnReset.setBounds(125, 450,100, 30);
				fr.add(btnReset);
				
				
				btnExit.addActionListener(this);
				btnRegister.addActionListener(this);
				btnDelete.addActionListener(this);
				btnUpdate.addActionListener(this);
				btnReset.addActionListener(this);
				btnRefresh.addActionListener(this);
				
				

		
		}	
	
	
		public static void main(String[] args) {
			
			new SwingAssignment();
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
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==btnRegister) {
				System.out.println("Insert button clicked");
				int id=Integer.parseInt(txtId.getText());		
				String name=txtName.getText();
				
				String gender = null;
				if(r1.isSelected()) {
					gender="Male";
				}
				else if(r2.isSelected()) {
					gender="Female";
				}
				String address=txtAdd.getText();
				long contact=Long.parseLong(txtContact.getText());
				
				try {
					
					Connection conn=SwingAssignment.createConnection();
					String sql="insert into regstudent(id, name, gender, address, contact) values(?,?,?,?,?)";
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setString(3, gender);
					ps.setString(4, address);
					ps.setLong(5, contact);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Inserte Successfull..");
					txtId.setText("");
					txtName.setText("");
					//r1.setSelected(false);
					r2.setSelected(false);
					txtAdd.setText("");
					txtContact.setText("");
			
				}
				catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			else if(e.getSource()==btnRefresh) {
				
				
				try {
					
						
					Connection conn=SwingAssignment.createConnection();
					Statement st=conn.createStatement();
					String sql="select *from regstudent";
					ResultSet rs=st.executeQuery(sql);
					java.sql.ResultSetMetaData rsmd=rs.getMetaData();
					DefaultTableModel model=(DefaultTableModel)tbl.getModel();
					
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
				
					for(int i=1;i<cols; i++) {
						colName[i]=rsmd.getCatalogName(i+1);
						model.setColumnIdentifiers(colName);
					}
					
				}
				catch (Exception e2) {
					e2.printStackTrace();
				}
				
//				
//			}
//			else if(e.getSource()==b3) {
//				
//				int id=Integer.parseInt(t1.getText());
//				String name=t2.getText();
//				long contact=Long.parseLong(t3.getText());
//				String email=t4.getText();
//				String address= t5.getText();
//				
//				try {
//					
//					Connection conn=SwingDemo.createConnection();
//					String sql="update student set name=?, contact=?, email=?, address=? where id=?";
//					PreparedStatement ps=conn.prepareStatement(sql);
//
//					ps.setString(1, name);
//					ps.setLong(2, contact);
//					ps.setString(3, email);
//					ps.setString(4, address);
//					ps.setInt(5,id);
//					
//					ps.executeUpdate();
//					
//					JOptionPane.showMessageDialog(null, "Data Upadate Successfull..");
//					t1.setText("");
//					t2.setText("");
//					t3.setText("");
//					t4.setText("");
//					t5.setText("");
//				}
//				catch (Exception e1) {
//					e1.printStackTrace();
//				}
//				
//			}
//			else if(e.getSource()==b4) {
//				
//				int id=Integer.parseInt(t1.getText());
//				try
//				{
//					Connection conn=SwingAssignment.createConnection();
//					String sql="delete from student where id=?";
//					PreparedStatement st=conn.prepareStatement(sql);
//					st.setInt(1, id);
//					st.executeUpdate();
//					
//					JOptionPane.showMessageDialog(null, "Data Deleted Successfull..");
//					t1.setText("");
//					t2.setText("");
//					t3.setText("");
//					t4.setText("");
//					t5.setText("");
//					
//				}
//				catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
	//		}
	}
		
		}
}
