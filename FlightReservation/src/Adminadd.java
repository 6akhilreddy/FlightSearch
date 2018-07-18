import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
 
@SuppressWarnings("serial")

public class Adminadd extends JApplet implements ActionListener{
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
	JButton b1,b2;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	
	Adminadd(){
		
		
	JFrame f=new JFrame("ADMIN PANNEL");
		
	f.getContentPane().setBackground(Color.darkGray);;
	
	l1=new JLabel("Flight Reservation");
	l1.setFont(new Font("Arial",Font.BOLD,50));
	l1.setForeground(Color.yellow);
	l1.setBounds(100,0 ,500,100);
	f.getContentPane().add(l1);
	
	l2=new JLabel("Admin Pannel");
	l2.setFont(new Font("Arial",Font.BOLD,40));
	l2.setForeground(Color.yellow);
	l2.setBounds(1100,0,500,100);
	f.getContentPane().add(l2);
	
	l3=new JLabel("Add Flights");
	l3.setFont(new Font("Arial",Font.BOLD,35));
	l3.setForeground(Color.yellow);
	l3.setBounds(800,70,300,50);
	f.getContentPane().add(l3);

	l4=new JLabel("Flight Id : ");
	l4.setFont(new Font("Arial",Font.BOLD,25));
	l4.setForeground(Color.orange);
	l4.setBounds(612,139,300,50);
	f.getContentPane().add(l4);

	t1=new JTextField(20);
	t1.setForeground(Color.white);
	t1.setFont(new Font("Arial",Font.BOLD,18));
	t1.setOpaque(false);
	t1.setBounds(900,150,200,30);
	f.getContentPane().add(t1);
	
	l5=new JLabel("Flight Name : ");
	l5.setFont(new Font("Arial",Font.BOLD,25));
	l5.setForeground(Color.orange);
	l5.setBounds(612,189,300,50);
	f.getContentPane().add(l5);

	t2=new JTextField(20);
	t2.setForeground(Color.white);
	t2.setFont(new Font("Arial",Font.BOLD,18));
	t2.setOpaque(false);
	t2.setBounds(900,200,200,30);
	f.getContentPane().add(t2);
	
	
	l6=new JLabel("Source : ");
	l6.setFont(new Font("Arial",Font.BOLD,25));
	l6.setForeground(Color.orange);
	l6.setBounds(612,241,300,50);
	f.getContentPane().add(l6);

	t3=new JTextField(20);
	t3.setForeground(Color.white);
	t3.setFont(new Font("Arial",Font.BOLD,18));
	t3.setOpaque(false);
	t3.setBounds(900,250,200,30);
	f.getContentPane().add(t3);
	
	
	l7=new JLabel("Destination : ");
	l7.setFont(new Font("Arial",Font.BOLD,25));
	l7.setForeground(Color.orange);
	l7.setBounds(612,291,300,50);
	f.getContentPane().add(l7);

	t4=new JTextField(20);
	t4.setForeground(Color.white);
	t4.setFont(new Font("Arial",Font.BOLD,18));
	t4.setOpaque(false);
	t4.setBounds(900,300,200,30);
	f.getContentPane().add(t4);
	
	l8=new JLabel("Start Time(hh:mm) : ");
	l8.setFont(new Font("Arial",Font.BOLD,25));
	l8.setForeground(Color.orange);
	l8.setBounds(612,341,300,50);
	f.getContentPane().add(l8);

	t5=new JTextField(20);
	t5.setForeground(Color.white);
	t5.setFont(new Font("Arial",Font.BOLD,18));
	t5.setOpaque(false);
	t5.setBounds(900,350,200,30);
	f.getContentPane().add(t5);
	
    l9=new JLabel("End Time(hh:mm) : ");
    l9.setFont(new Font("Arial",Font.BOLD,25));
    l9.setForeground(Color.orange);
    l9.setBounds(612,391,300,50);
    f.getContentPane().add(l9);

    t6=new JTextField(20);
    t6.setForeground(Color.white);
    t6.setFont(new Font("Arial",Font.BOLD,18));
    t6.setOpaque(false);
    t6.setBounds(900,400,200,30);
    f.getContentPane().add(t6);

    l10=new JLabel("seats : ");
	l10.setFont(new Font("Arial",Font.BOLD,25));
	l10.setForeground(Color.orange);
	l10.setBounds(612,437,300,50);
	f.getContentPane().add(l10);

	t7=new JTextField(20);
	t7.setForeground(Color.white);
	t7.setFont(new Font("Arial",Font.BOLD,18));
	t7.setOpaque(false);
	t7.setBounds(900,450,200,30);
	f.getContentPane().add(t7);

	l11=new JLabel("Price : ");
	l11.setFont(new Font("Arial",Font.BOLD,25));
	l11.setForeground(Color.orange);
	l11.setBounds(612,490,300,50);
	f.getContentPane().add(l11);

	t8=new JTextField(20);
	t8.setForeground(Color.white);
	t8.setFont(new Font("Arial",Font.BOLD,18));
	t8.setOpaque(false);
	t8.setBounds(900,500,200,30);
	f.getContentPane().add(t8);

	
	l12=new JLabel("Upload Photo : ");
	l12.setFont(new Font("Arial",Font.BOLD,25));
	l12.setForeground(Color.orange);
	l12.setBounds(612,540,300,50);
	f.getContentPane().add(l12);

	
	t9=new JTextField(20);
	t9.setForeground(Color.white);
	t9.setFont(new Font("Arial",Font.BOLD,18));
	t9.setOpaque(false);
	t9.setBounds(900,550,200,30);
	f.getContentPane().add(t9);
	
	b1=new JButton("Browse");
	b1.setForeground(Color.yellow);
	b1.setBackground(Color.gray);
	b1.setBounds(1150,550,150,30);
	f.getContentPane().add(b1);
	
	
	b2=new JButton("SAVE");
	b2.setFont(new Font("Arial",Font.BOLD,30));
	b2.setForeground(Color.yellow);
	b2.setBackground(Color.gray);
	b2.setBounds(860,610,130,50);
	f.getContentPane().add(b2);
	
	f.setSize(900,500);  
    f.getContentPane().setLayout(null);  
    
    btnNewButton = new JButton("Delete Flights");
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		new DeleteFlights();
    		
    		
    		
    	}
    });
    btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    btnNewButton.setBackground(Color.DARK_GRAY);
    btnNewButton.setForeground(Color.YELLOW);
    btnNewButton.setBounds(110, 172, 282, 58);
    f.getContentPane().add(btnNewButton);
    
    btnNewButton_1 = new JButton("View Passengers");
    btnNewButton_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    	new ViewPassengers();
    		
    		
    	}
    });
    btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
    btnNewButton_1.setBackground(Color.DARK_GRAY);
    btnNewButton_1.setForeground(Color.YELLOW);
    btnNewButton_1.setBounds(110, 274, 282, 58);
    f.getContentPane().add(btnNewButton_1);
    f.setVisible(true);
    f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	
	
	}
	
	public void actionPerformed(ActionEvent ae){
	
	String s=ae.getActionCommand();
	
	File file = null;
    String path="";
	 
    if(s.equals("Browse")){	

    
	JFileChooser chooser = new JFileChooser();
    chooser.addChoosableFileFilter(new ImageFileFilter());
    int returnVal = chooser.showOpenDialog(null);

    if(returnVal == JFileChooser.APPROVE_OPTION) {   
    file = chooser.getSelectedFile();
    path=file.getPath();
    t9.setText(path);
    }

    }
	
	else{
    String id,name,source,dest,sttime,endtime,image;
	int nos=Integer.parseInt(t7.getText());
	int price=Integer.parseInt(t8.getText());
	id=t1.getText();name=t2.getText();source=t3.getText();dest=t4.getText();sttime=t5.getText();endtime=t6.getText();image=t9.getText();
	
	if(id.equals("")||name.equals("")||(t7.getText()).equals("")||source.equals("")||dest.equals("")||sttime.equals("")||endtime.equals("")||(t8.getText()).equals("")){
	
		JOptionPane.showMessageDialog(null,"All Fields Must Be Filled !!");

	
	}
	
	else{
	
	try{
    File f=new File(image);
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","system");
	PreparedStatement psmnt = connection.prepareStatement("insert into flight values(?,?,?,?,?,?,?,?,?)");
	
	psmnt.setString(1,""+id+"");  
	psmnt.setString(2,""+name.toUpperCase()+"");
	psmnt.setString(3,""+source.toUpperCase()+"");
	psmnt.setString(4,""+dest.toUpperCase()+"");
	psmnt.setString(5,""+sttime+"");
	psmnt.setString(6,""+endtime+"");
	psmnt.setInt(7, nos);
	psmnt.setInt(8, price);
	
	FileInputStream fis = new FileInputStream(f);
	psmnt.setBinaryStream(9, (InputStream)fis, (int)(f.length()));
	
	
	psmnt.executeUpdate();
	JOptionPane.showMessageDialog(null,"Inserted successfully!");
    }
    catch(Exception ex){
        System.out.print(ex);
    }	
	t1.setText("");
	t2.setText("");
	t3.setText("");
	t4.setText("");
	t5.setText("");
	t6.setText("");
	t7.setText("");
	t8.setText("");
	t9.setText("");
	}
	
	}


		
	}
	
class ImageFileFilter extends javax.swing.filechooser.FileFilter {
public boolean accept(File file) {
if (file.isDirectory()) return false;
String name = file.getName().toLowerCase();
return (name.endsWith(".jpg") || name.endsWith(".png")|| name.endsWith(".gif"));
}
public String getDescription() { return "Images (*.gif,*.bmp, *.jpg, *.png )"; }
}
	
	public static void main(String args[]){
		
		String pass = JOptionPane.showInputDialog("Enter Password");
		
		if (pass == null) {
		   JOptionPane.showMessageDialog(null,"Enter Password");
		}	
		else if(pass.equals("admin")){
			new Adminadd();		
		}
		else {
			JOptionPane.showMessageDialog(null,"password wrong");
				
			}
		
	}
}