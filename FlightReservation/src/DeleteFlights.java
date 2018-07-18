import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

@SuppressWarnings("serial")

public class DeleteFlights extends JApplet implements ActionListener{
	  JLabel[] l1,l2,l3,l4,l5,ll1,ll2,ll3;
	  JButton[] b1;
	  JLabel l6,l7,l8,l9,l10,l11,l12;
	  JTextField t1;
	  JButton bu;
		JFrame f;

	  int i=0;
DeleteFlights(){
	
	f=new JFrame("Delete Flights");
	
	
    f.getContentPane().setBackground(Color.darkGray);
    
	
	l6=new JLabel("OnlineBookStore");
	l6.setFont(new Font("Arial",Font.BOLD,50));
	l6.setForeground(Color.yellow);
	l6.setBounds(100,0 ,500,100);
	f.add(l6);
	
	
	l8=new JLabel("All Flights");
	l8.setFont(new Font("Arial",Font.BOLD,35));
	l8.setForeground(Color.yellow);
	l8.setBounds(500,100,300,50);
	f.add(l8);

	
	l9=new JLabel();
	l10=new JLabel();
	l12=new JLabel();
	
	
	JPanel p=new JPanel();
  GridBagLayout grid = new GridBagLayout();  
            GridBagConstraints gbc = new GridBagConstraints();  
			gbc.insets = new Insets(10,25,5,25);
            p.setLayout(grid);  
  
   p.setBackground(Color.getHSBColor(0.56f, 1.0f, 0.8f));
		
    
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");  
  
	    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","system");  
  
		Statement stmt=con.createStatement();  
 
		ResultSet rs=stmt.executeQuery("select * from flight ");  
		
		int	range=0;
		
		while(rs.next()){
		range++;
		}
		
		ImageIcon[] icon=new ImageIcon[range];
		
		Image[] img=new Image[range];
		
		l1=new JLabel[range]; 
		l2=new JLabel[range];
		l3=new JLabel[range]; 
		l4=new JLabel[range];
		l5=new JLabel[range];
		ll1=new	JLabel[range];
		ll2=new JLabel[range];
		ll3=new JLabel[range];
		
		b1=new JButton[range];
		
		String a,b,c,d,e,g;
		int h;
		
		int x=0,y=0;
		
		ResultSet rs1=stmt.executeQuery("select * from flight");

		
		
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
		 
		 
		 a=rs1.getString("fid");
		 b=rs1.getString("fname");
		 c=rs1.getString("source");
		 d=rs1.getString("destination");
		 e=rs1.getString("starttime");
		 g=rs1.getString("endtime");
		 h=rs1.getInt("price");
				
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+1; 
		
		l2[i]=new JLabel(a);
		l2[i].setFont(new Font("Arial",Font.BOLD,25));
		l2[i].setForeground(Color.white);
		p.add(l2[i],gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+2; 
		
		
		l3[i]=new JLabel("Flight Name :"+b);
		l3[i].setForeground(Color.orange);
		l3[i].setFont(new Font("Arial",Font.BOLD,15));
		p.add(l3[i],gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+3; 
		
		
		l4[i]=new JLabel("Source :"+c);
		l4[i].setForeground(Color.green);
		l4[i].setFont(new Font("Arial",Font.BOLD,15));
		p.add(l4[i],gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+4; 
		
		
		l5[i]=new JLabel("Destination :"+d);
		l5[i].setForeground(Color.green);
		l5[i].setFont(new Font("Arial",Font.BOLD,15));
		p.add(l5[i],gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+5; 
		
		
		ll1[i]=new JLabel("StartTime :"+e);
		ll1[i].setForeground(Color.green);
		ll1[i].setFont(new Font("Arial",Font.BOLD,15));
		p.add(ll1[i],gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+6; 
		
		
		ll2[i]=new JLabel("EndTime :"+g);
		ll2[i].setForeground(Color.green);
		ll2[i].setFont(new Font("Arial",Font.BOLD,15));
		p.add(ll2[i],gbc);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+7; 
		
		
		ll3[i]=new JLabel("Price(INR) :"+h);
		ll3[i].setForeground(Color.green);
		ll3[i].setFont(new Font("Arial",Font.BOLD,15));
		p.add(ll3[i],gbc);
		
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = x;  
		gbc.gridy = y+8; 
		
		b1[i]=new JButton("Delete Flight");
		b1[i].setFont(new Font("Arial",Font.BOLD,25));
		b1[i].setForeground(Color.black);
		b1[i].setBackground(Color.white);
		p.add(b1[i],gbc);
		b1[i].putClientProperty("id",i);
		b1[i].addActionListener(this);
		 
		 x++;
		 
		 
		 if(x==4){
		 x=0;y+=9;}
		 
        }

	con.close();  
  
}catch(Exception e){ System.out.println(e);}  
	
	JScrollPane pane = new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	pane.setBounds(40,160,1280,520);
	f.add(pane);  
		
	
	f.setSize(900,500);  
    f.setLayout(null);  
    f.setVisible(true);
    f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	
	
	
}

public void actionPerformed(ActionEvent ae){
  
  if( ae.getSource() instanceof JButton) {
	  
     ((JButton)ae.getSource()).setOpaque(true);
  }
  
  	JButton source = (JButton)ae.getSource();
    int id = (int) source.getClientProperty("id");
  
    String m=l2[id].getText(); 
 
 
    		try{
    			Class.forName("oracle.jdbc.driver.OracleDriver");  
  
            	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","system");  
  
            	Statement stmt=con.createStatement();  
 
 
            	stmt.executeQuery("begin delete from reserved where fid='"+m+"'; delete from flight where fid='"+m+"'; end; ");  
		
            	con.close();
		
            	JOptionPane.showMessageDialog(null,"Deleted flight with ID: "+m+""+"and tickets booked to this flight");
            	
            	f.dispose();
		
            }catch(Exception e){ System.out.println(e);}
	

	}

}