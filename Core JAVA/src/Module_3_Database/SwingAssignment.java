package Module_3_Database;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SwingAssignment {
		
		JLabel l1,l2,l3,l4,l5,l6,l7,l8;
		JTextField txtId,txtName,txtAdd,txtContact;
		JRadioButton r1,r2;
		JButton btnExit,btnRegister,btnDelete,btnUpdate,btnReset,btnRefresh;
		JTable tbl;
		
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
				
				btnExit=new JButton("Register");
				btnExit.setBounds(200, 350,150, 30);
				fr.add(btnExit);
				
				btnExit=new JButton("Delete");
				btnExit.setBounds(50, 400,100, 30);
				fr.add(btnExit);
				
				btnExit=new JButton("Update");
				btnExit.setBounds(200, 400,150, 30);
				fr.add(btnExit);
				
				btnExit=new JButton("Reset");
				btnExit.setBounds(125, 450,100, 30);
				fr.add(btnExit);
				

				
		
		}	
	
	
		public static void main(String[] args) {
			
			new SwingAssignment();
		}

}
