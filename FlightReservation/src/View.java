import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

@SuppressWarnings("serial")

public class View extends JApplet implements ActionListener{

	  JLabel[] l1,l2,l3,l4,l5,l6;
	  JButton[] b1;
	  JLabel l7,l8,l9,l10,l11,l12;
	  JTextField t1;
	  JButton bu;

	  int i=0;
 public View(String from, String to, String date, int nos) {
			
	JFrame f=new JFrame("User View");
	f.getContentPane().setForeground(Color.WHITE);
    f.getContentPane().setBackground(new Color(255, 51, 102));;

	
	l8=new JLabel("All Flights");
	l8.setFont(new Font("Arial",Font.BOLD,35));
	l8.setForeground(Color.WHITE);
	l8.setBounds(320,7,300,50);
	f.getContentPane().add(l8);
	
	l9=new JLabel(date);
	l10=new JLabel(""+nos);
	
	
	//used GridBagLayout inside the JPanel for displaying the flight details
	
	JPanel p=new JPanel();
	GridBagLayout grid = new GridBagLayout();  
    GridBagConstraints gbc = new GridBagConstraints();  
    gbc.insets = new Insets(10,25,5,25); //For Padding
    p.setLayout(grid);  
  
    p.setBackground(Color.WHITE);
		
    //database Connection
    
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");  //Oracle Database
  
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","system");	//Driver-'thin',Server-'localhost',PortNumber-'1521',sysId-'oracle',userName-'system',password-'system'  
  
		Statement stmt=con.createStatement();  
 
		ResultSet rs=stmt.executeQuery("select * from flight where source='"+from.toUpperCase()+"' and destination='"+to.toUpperCase()+"'");  
		
		int	range=0;
		
		while(rs.next()){
		range++;	//To get the count for initializing the variables
		}
		
		ImageIcon[] icon=new ImageIcon[range];
		
		Image[] img=new Image[range];
		
		l1=new JLabel[range]; 
		l2=new JLabel[range];
		l3=new JLabel[range]; 
		l4=new JLabel[range];
		l5=new JLabel[range];
		l6=new JLabel[range];
		
		b1=new JButton[range];
		
		String a,b,c,e;
		int d;
	
		int x=0,y=0;
		
		ResultSet rs1=stmt.executeQuery("select * from flight where source='"+from.toUpperCase()+"' and destination='"+to.toUpperCase()+"'");

		
		
		for(i=0;rs1.next();i++){  
			
			byte[] image = null;
            image = rs1.getBytes("image");
            img[i] = Toolkit.getDefaultToolkit().createImage(image);
			icon[i] = new ImageIcon(new ImageIcon(img[i]).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
         
			gbc.fill = GridBagConstraints.HORIZONTAL;  
			gbc.gridx = x;  
			gbc.gridy = y; 
			gbc.anchor = GridBagConstraints.PAGE_START;
		 
			l1[i]=new JLabel();
			l1[i].setIcon(icon[i]);
			p.add(l1[i],gbc);
		 
		 
			a=rs1.getString("fname");
			b=rs1.getString("startTime");
			c=rs1.getString("endTime");
			d=rs1.getInt("price");
			e=rs1.getString("fid");
				
			gbc.fill = GridBagConstraints.HORIZONTAL;  
			gbc.gridx = x;  
			gbc.gridy = y+1; 
		
			l2[i]=new JLabel(a);
			l2[i].setFont(new Font("Arial",Font.BOLD,20));
			l2[i].setForeground(Color.black);
			p.add(l2[i],gbc);
		
			gbc.fill = GridBagConstraints.HORIZONTAL;  
			gbc.gridx = x;  
			gbc.gridy = y+2; 
		
		
			l3[i]=new JLabel("Departure :"+b);
			l3[i].setForeground(new Color(255, 51, 102));
			l3[i].setFont(new Font("Arial",Font.BOLD,15));
			p.add(l3[i],gbc);
		
			gbc.fill = GridBagConstraints.HORIZONTAL;  
			gbc.gridx = x;  
			gbc.gridy = y+3; 
		
		
			l4[i]=new JLabel("Arrival :"+c);
			l4[i].setForeground(new Color(255, 51, 102));
			l4[i].setFont(new Font("Arial",Font.BOLD,15));
			p.add(l4[i],gbc);
		
			gbc.fill = GridBagConstraints.HORIZONTAL;  
			gbc.gridx = x;  
			gbc.gridy = y+4; 
		
		
			//for calculation of time
			
			/*
			 
			 Take the strings of departure and arrival 
			 and store it in string array by spiting the string
			 with '-' sign, later subtract the two values to
			 get the duration between departure and arrival
			 
			 */
			
			String[] arr1=new String[2];	
			String[] arr2=new String[2];
		
			arr1=b.split(":");
			arr2=c.split(":");
		
			int	hr1=Integer.parseInt((arr1[0]));
			int hr2=Integer.parseInt((arr2[0]));
		
			if(hr1==0)
				hr1=24;
			else if(hr2==0)
				hr2=24;
		
			int	min1=Integer.parseInt(arr2[1]);
			int min2=Integer.parseInt(arr1[1]);
		
			if(hr1>hr2)
				l12=new JLabel("Duration :"+Math.abs(Math.abs((hr2-hr1))-24)+"h : "+Math.abs((min2-min1))+"M");
			else
				l12=new JLabel("Duration :"+Math.abs((hr2-hr1))+"h : "+Math.abs((min2-min1))+"M");
		
			l12.setForeground(new Color(255, 51, 102));
			l12.setFont(new Font("Arial",Font.BOLD,15));
			p.add(l12,gbc);
		
			gbc.fill = GridBagConstraints.HORIZONTAL;  
			gbc.gridx = x;  
			gbc.gridy = y+5; 
		
		
			l5[i]=new JLabel("Price (INR):"+d);
			l5[i].setForeground(new Color(255, 51, 102));
			l5[i].setFont(new Font("Arial",Font.BOLD,15));
			p.add(l5[i],gbc);
		
			gbc.fill = GridBagConstraints.HORIZONTAL;  
			gbc.gridx = x;  
			gbc.gridy = y+6; 
		
			l6[i]=new JLabel(""+e);
		
			b1[i]=new JButton("Book Flight");
			b1[i].setFont(new Font("Arial",Font.BOLD,25));
			b1[i].setForeground(Color.white);
			b1[i].setBackground(new Color(255, 51, 102));
			p.add(b1[i],gbc);
			b1[i].putClientProperty("id",i);
			b1[i].addActionListener(this);
		 
			x++;
		 
			//For printing the details in the next row
			
			if(x==4){
				x=0;y+=7;}
		 
        }
		

	con.close();  
  
}catch(Exception e){ System.out.println(e);}  

	
	JScrollPane pane = new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	pane.setBounds(10,60,890,420);
	f.getContentPane().add(pane);  

	
	f.setSize(930,550);  
    f.getContentPane().setLayout(null);  
    f.setVisible(true);
	
	
}



public void actionPerformed(ActionEvent ae){
  
  if( ae.getSource() instanceof JButton) {
	  
     ((JButton)ae.getSource()).setOpaque(true);
  }
  
  //get the id of the button
  
  JButton source = (JButton)ae.getSource();
  int id = (int) source.getClientProperty("id");
            
  String m=l6[id].getText(),n=l9.getText();
  int o=Integer.parseInt(l10.getText());

  String[] sp=new String[2];
  sp=(l5[id].getText()).split(":");

  int price = Integer.parseInt(sp[1]);
  
  new BookFlight(m, n, o, price);	
	
	}


}