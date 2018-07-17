import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
 
@SuppressWarnings("serial")

public class BookFlight extends JApplet{
	
	JLabel l1,l2;
	
	private JTextField t1,t2,t3;

	
	BookFlight(String fid,String date,int nos,int price){
		
	int total=nos*price;	//for multiplying number of seats with price to get total price
			
	JFrame f=new JFrame("Confrim Booking");
	
	l2=new JLabel(fid);
   
    
	f.getContentPane().setBackground(new Color(255, 51, 102));;
	
	l1=new JLabel("Flight Reservation");
	l1.setHorizontalAlignment(SwingConstants.CENTER);
	l1.setBackground(Color.WHITE);
	l1.setFont(new Font("Arial",Font.BOLD,30));
	l1.setForeground(Color.BLACK);
	l1.setBounds(191,21 ,311,34);
	l1.setOpaque(true);
	f.getContentPane().add(l1);
	
	f.setSize(900,500);  
    f.getContentPane().setLayout(null);  
    
    JLabel lblName = new JLabel("Name");
    lblName.setForeground(Color.WHITE);
    lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
    lblName.setBounds(130, 99, 109, 34);
    f.getContentPane().add(lblName);
    
    t1 = new JTextField();
    t1.setBounds(301, 102, 198, 34);
    f.getContentPane().add(t1);
    t1.setColumns(10);
    
    JLabel lblPhone = new JLabel("Phone");
    lblPhone.setFont(new Font("Tahoma", Font.BOLD, 20));
    lblPhone.setForeground(Color.WHITE);
    lblPhone.setBounds(130, 154, 109, 34);
    f.getContentPane().add(lblPhone);
    
    t2 = new JTextField();
    t2.setBounds(301, 158, 198, 34);
    f.getContentPane().add(t2);
    t2.setColumns(10);
    
    JLabel lblEmail = new JLabel("email");
    lblEmail.setForeground(Color.WHITE);
    lblEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
    lblEmail.setBounds(130, 203, 109, 34);
    f.getContentPane().add(lblEmail);
    
    t3 = new JTextField();
    t3.setBounds(301, 209, 198, 31);
    f.getContentPane().add(t3);
    t3.setColumns(10);
    
    JLabel lblSeats = new JLabel("Seats");
    lblSeats.setForeground(Color.WHITE);
    lblSeats.setFont(new Font("Tahoma", Font.BOLD, 20));
    lblSeats.setBounds(130, 275, 100, 32);
    f.getContentPane().add(lblSeats);
    
    JLabel t4 = new JLabel(""+nos);
    t4.setForeground(Color.WHITE);
    t4.setBounds(304, 274, 198, 34);
    t4.setFont(new Font("Tahoma", Font.BOLD, 20));
    f.getContentPane().add(t4);
    
    
    JLabel lblTotal = new JLabel("Total (INR)");
    lblTotal.setForeground(Color.WHITE);
    lblTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
    lblTotal.setBounds(130, 318, 132, 34);
    f.getContentPane().add(lblTotal);
    
    JLabel l3 = new JLabel(""+total);
    l3.setForeground(Color.WHITE);
    l3.setFont(new Font("Tahoma", Font.BOLD, 20));
    l3.setBounds(304, 320, 198, 31);
    f.getContentPane().add(l3);
    
    JLabel lblDate = new JLabel("Date");
    lblDate.setForeground(Color.WHITE);
    lblDate.setFont(new Font("Tahoma", Font.BOLD, 20));
    lblDate.setBounds(130, 363, 109, 25);
    f.getContentPane().add(lblDate);
    
    JLabel l4 = new JLabel(date);
    l4.setForeground(Color.WHITE);
    l4.setFont(new Font("Tahoma", Font.BOLD, 20));
    l4.setBounds(301, 361, 198, 28);
    f.getContentPane().add(l4);
    
    JButton btnNewButton = new JButton("Confirm");
    btnNewButton.setForeground(Color.BLACK);
    btnNewButton.setBackground(Color.WHITE);
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    	String name,email,date,fid,number;
    	int nos,amount;
    		
    	name=t1.getText();email=t3.getText();
    	number=t2.getText();
    	fid=l2.getText();
    	date=l4.getText();
    	amount=Integer.parseInt(l3.getText());
    	nos=Integer.parseInt(t4.getText());
    	
    	
    	if(name.equals("")||email.equals("")||(t2.getText()).equals("")||(t4.getText()).equals("")){
    		
    		JOptionPane.showMessageDialog(null,"All Fields Must Be Filled !!");
    	
    	}
    	
    	else{
    		
    	try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","system");

    	//PreparedStatement used to	insert multiple values at once in the database
    	
    	PreparedStatement psmnt = connection.prepareStatement("insert into reserved values(?,?,?,?,?,?,?)");
    	
    	psmnt.setString(1,""+fid+"");  
    	psmnt.setString(2,""+name.toUpperCase()+"");
    	psmnt.setString(3,""+email.toUpperCase()+"");
    	psmnt.setString(4,""+date+"");
    	psmnt.setInt(5,amount);
    	psmnt.setInt(6, nos);
    	psmnt.setString(7,""+number+"");
    	psmnt.executeUpdate();
    	
    	Statement stmt=connection.createStatement();  
    	 
		ResultSet rs=stmt.executeQuery("select * from flight where fid='"+fid+"'");  

		String arrival="",departure="";
    	
		while(rs.next()) {
    		
    		arrival=rs.getString("endtime");
    		departure=rs.getString("starttime");	
    	}
    	
		//content to print in the JOptionPane as a message to the user
		
    	JLabel j=new JLabel("Reservation Sucessfull");
    	j.setFont(new Font("Arial",Font.BOLD,25));
        j.setForeground(Color.black);
    	
        JLabel	jspace=new JLabel(" ");
        jspace.setFont(new Font("Arial",Font.BOLD,25));
        
    	JLabel j1=new JLabel("Name : "+name);
    	j1.setFont(new Font("Arial",Font.BOLD,25));
        j1.setForeground(Color.black);
    	
        JLabel j2=new JLabel("Date : "+date);
    	j2.setFont(new Font("Arial",Font.BOLD,25));
        j2.setForeground(Color.black);
    	
        JLabel j3=new JLabel("Departure : "+departure);
    	j3.setFont(new Font("Arial",Font.BOLD,25));
        j3.setForeground(Color.black);
    	
        JLabel j4=new JLabel("Arrival : "+arrival);
    	j4.setFont(new Font("Arial",Font.BOLD,25));
        j4.setForeground(Color.black);
    	
        JLabel j5=new JLabel("No of seats : "+nos);
    	j5.setFont(new Font("Arial",Font.BOLD,25));
        j5.setForeground(Color.black);
        
        JLabel j6=new JLabel("Amount : "+amount);
    	j6.setFont(new Font("Arial",Font.BOLD,25));
        j6.setForeground(Color.black);
    	
    	//UIManager is used to increase the default size of the JOptionPane
        
    	UIManager.put("OptionPane.minimumSize",new Dimension(500,500));
    	JLabel[] arr = {j,jspace,j1,j2,j3,j4,j5,j6};
    	JOptionPane.showMessageDialog(null, arr);
    	
        }
        catch(Exception ex){
            System.out.print(ex);
        }	

    	//removing the lastPage(Booking Page) 
    	f.dispose();
    	
    	}    		
    	}
    });
    
    
    
    btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    btnNewButton.setBounds(620, 381, 151, 51);
    f.getContentPane().add(btnNewButton);
    
    ImageIcon icon=new ImageIcon();
	
	Image img=new Image() {
		
		@Override
		public int getWidth(ImageObserver observer) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public ImageProducer getSource() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Object getProperty(String name, ImageObserver observer) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int getHeight(ImageObserver observer) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Graphics getGraphics() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	
	JLabel label1 = new JLabel();
	label1.setHorizontalAlignment(SwingConstants.CENTER);
	label1.setBounds(620, 34, 254, 99);
    f.getContentPane().add(label1);
    
    JLabel label2 = new JLabel();
    label2.setHorizontalAlignment(SwingConstants.CENTER);
    label2.setFont(new Font("Tahoma", Font.BOLD, 14));
    label2.setForeground(Color.WHITE);
    label2.setBounds(620, 141, 254, 34);
    f.getContentPane().add(label2);
    
    JLabel label3 = new JLabel();
    label3.setHorizontalAlignment(SwingConstants.CENTER);
    label3.setForeground(Color.WHITE);
    label3.setFont(new Font("Tahoma", Font.BOLD, 14));
    label3.setBounds(620, 175, 254, 34);
    f.getContentPane().add(label3);
    
    JLabel label4 = new JLabel();
    label4.setHorizontalAlignment(SwingConstants.CENTER);
    label4.setForeground(Color.WHITE);
    label4.setFont(new Font("Tahoma", Font.BOLD, 14));
    label4.setBounds(620, 207, 254, 31);
    f.getContentPane().add(label4);
    
	
	try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","system");    	
    	Statement stmt=connection.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from flight where fid='"+fid+"'");  

		while(rs.next()) {
		
			byte[] image = null;
            image = rs.getBytes("image");
            img = Toolkit.getDefaultToolkit().createImage(image);
			icon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
         
			label1.setIcon(icon);
			
			label2.setText("Flight Name: "+rs.getString("fname"));
			label3.setText("Departure: "+rs.getString("starttime"));
			label4.setText("Arrival: "+rs.getString("endtime"));
			
			
		}

    }
    catch(Exception ex){
        System.out.print(ex);
    }	    
    
    f.setVisible(true);
 	
	
	}


}