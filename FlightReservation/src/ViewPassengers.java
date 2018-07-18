import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

public class ViewPassengers implements ActionListener{

JLabel l1,l2,la1;	

JLabel[] l4,l5,l6,l7,l8,l9;


ViewPassengers(){
	
	JFrame f=new JFrame("View Tickets");
	
	f.getContentPane().setBackground(Color.darkGray);;

	l1=new JLabel("OnlineBookStore");
	l1.setFont(new Font("Arial",Font.BOLD,50));
	l1.setForeground(Color.yellow);
	l1.setBounds(100,0 ,500,100);
	f.getContentPane().add(l1);
	
	l2=new JLabel("Admin Panel");
	l2.setFont(new Font("Arial",Font.BOLD,40));
	l2.setForeground(Color.yellow);
	l2.setBounds(1100,0,500,100);
	f.getContentPane().add(l2);

	JLabel lblAllTickets = new JLabel("All Tickets");
    lblAllTickets.setFont(new Font("Tahoma", Font.BOLD, 25));
    lblAllTickets.setForeground(Color.YELLOW);
    lblAllTickets.setBounds(579, 96, 266, 53);
    f.getContentPane().add(lblAllTickets);
    
/*
 * created a JPanel and used GridBagLayout that provides grids		
 */
	
    JPanel p=new JPanel();
    GridBagLayout grid = new GridBagLayout();  
    GridBagConstraints gbc = new GridBagConstraints();  
	gbc.insets = new Insets(10,25,5,25);	//for padding
    p.setLayout(grid);  
  
   p.setBackground(Color.getHSBColor(0.56f, 1.0f, 0.8f)); //for using HSB color values

   //Database connection
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
  
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","system");	//Driver-'thin',Server-'localhost',PortNumber-'1521',sysId-'oracle',userName-'system',password-'system'  
  
		Statement stmt=con.createStatement();  
 
		ResultSet rs=stmt.executeQuery("select * from reserved ");  
		
		int	range=0;
		
		//for finding the number of records in the table
		
		while(rs.next()){
		range++;
		}
			
		//Initializing the array labels with the range(number of records)
		
		l4=new JLabel[range]; 
		l5=new JLabel[range];
		l6=new JLabel[range]; 
		l7=new JLabel[range];
		l8=new JLabel[range];
		l9=new JLabel[range];
		
		String a,b,c,d,e,g;
		
		int x=0,y=0;
		
		//Query to get the records from table
		
		ResultSet rs1=stmt.executeQuery("select * from reserved ");  
		
		for(int i=0;rs1.next();i++){  
			
			 a=rs1.getString("fid");
			 b=rs1.getString("uname");
			 c=rs1.getString("phno");
			 d=rs1.getString("ddate");
			 e=rs1.getString("noseats");		
			 g=rs1.getString("amount");
			
			gbc.fill = GridBagConstraints.HORIZONTAL;  
			gbc.gridx = x;  
			gbc.gridy = y; 
			gbc.anchor = GridBagConstraints.PAGE_START;
			 
			
			l4[i]=new JLabel("Flight ID: "+a);
			l4[i].setFont(new Font("Arial",Font.BOLD,25));
			l4[i].setForeground(Color.orange);
			p.add(l4[i],gbc);
			
			gbc.fill = GridBagConstraints.HORIZONTAL;  
			gbc.gridx = x;  
			gbc.gridy = y+1; 
			
			l5[i]=new JLabel("Passenger Name :"+b);
			l5[i].setFont(new Font("Arial",Font.BOLD,15));
			l5[i].setForeground(Color.green);
			p.add(l5[i],gbc);
			
			
			gbc.fill = GridBagConstraints.HORIZONTAL;  
			gbc.gridx = x;  
			gbc.gridy = y+2; 
			
			l6[i]=new JLabel("phone Number :"+c);
			l6[i].setFont(new Font("Arial",Font.BOLD,15));
			l6[i].setForeground(Color.white);
			p.add(l6[i],gbc);
			
			
			gbc.fill = GridBagConstraints.HORIZONTAL;  
			gbc.gridx = x;  
			gbc.gridy = y+3; 
			
			
			l7[i]=new JLabel("Date Of Travel :"+d);
			l7[i].setForeground(Color.white);
			l7[i].setFont(new Font("Arial",Font.BOLD,15));
			p.add(l7[i],gbc);
			
			
			gbc.fill = GridBagConstraints.HORIZONTAL;  
			gbc.gridx = x;  
			gbc.gridy = y+4; 
			
			
			l8[i]=new JLabel("Number of Seats :"+e);
			l8[i].setFont(new Font("Arial",Font.BOLD,15));
			l8[i].setForeground(Color.white);
			p.add(l8[i],gbc);
			
			gbc.fill = GridBagConstraints.HORIZONTAL;  
			gbc.gridx = x;  
			gbc.gridy = y+5; 
			
			
			l9[i]=new JLabel("Amount(INR) :"+g);
			l9[i].setFont(new Font("Arial",Font.BOLD,15));
			l9[i].setForeground(Color.white);
			p.add(l9[i],gbc);
				 
			x++;
			/*
			 * for displaying the records in the new row after 4 columns
			 */
			 if(x==4){
			 x=0;y+=6;}
		 
        }
		
	con.close();  
  
}catch(Exception e){ System.out.println(e);}  

	
	JScrollPane pane = new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	pane.setBounds(40,160,1250,520);
	f.getContentPane().add(pane);  

	
	f.setSize(900,500);  
    f.getContentPane().setLayout(null);  
    
    
    f.setVisible(true);
	f.setExtendedState(JFrame.MAXIMIZED_BOTH);	//To display full screen 
	
	}

public void actionPerformed(ActionEvent ae){
	
}

public static void main(String args[]){
	
	new ViewPassengers();
}
}