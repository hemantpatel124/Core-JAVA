import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingDemo {
	JLabel l1,l2,l3,l4,l5;
	JTextField t1,t2,t3,t4;
	JTextArea ta1;
	JButton b1,b2,b3,b4;
	
	public SwingDemo() {
		JFrame frm= new JFrame("MyApp");  
	   
	    l1=new JLabel("Id : ");
	    l1.setBounds(100, 100, 100, 30);
	    frm.add(l1);
		t1=new JTextField();  
	    t1.setBounds(200,100, 200,30);  
	    frm.add(t1); 
	    
	    l2=new JLabel("Name : ");
	    l2.setBounds(100, 150, 100, 30);
	    frm.add(l2);
	    t2=new JTextField();  
	    t2.setBounds(200,150, 200,30);  
	    frm.add(t2);  
	    
	    l3=new JLabel("Contact : ");
	    l3.setBounds(100, 200, 100, 30);
	    frm.add(l3);
	    t3=new JTextField();  
	    t3.setBounds(200,200, 200,30);  
	    frm.add(t3); 
	    
	    l4=new JLabel("Email : ");
	    l4.setBounds(100, 250, 100, 30);
	    frm.add(l4);
	    t4=new JTextField();  
	    t4.setBounds(200,250, 200,30);  
	    frm.add(t4);
	    
	    l5=new JLabel("Address : ");
	    l5.setBounds(100, 300, 100, 30);
	    frm.add(l5);
	    ta1=new JTextArea();  
	    ta1.setBounds(200,300, 200,50);  
	    frm.add(ta1);
	    
	    b1=new JButton(" Insert ");
	    b1.setBounds(50, 400, 100, 30);
	    frm.add(b1);
	    
	    b2=new JButton(" Update ");
	    b2.setBounds(225, 400, 100, 30);
	    frm.add(b2);
	    
	    b3=new JButton(" Delete ");
	    b3.setBounds(400, 400, 100, 30);
	    frm.add(b3);
	    
	    b4=new JButton(" Search ");
	    b4.setBounds(575, 400, 100, 30);
	    frm.add(b4);
	    
	    frm.setSize(750,500);  
	    frm.setLayout(null);  
	    frm.setVisible(true); 
	}
	
	public static void main(String[] args) {
		new SwingDemo();
		
	}
}