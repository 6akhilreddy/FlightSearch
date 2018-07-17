import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

@SuppressWarnings("serial")

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField t1,t2,t3,t4;
	
	int xx,xy;
	
	static int count=0;
	
	//Start of the program
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();	//Constructor Call
					frame.setUndecorated(true);	//To Remove Default Window Options
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	public Home() {
		
		//Initialization of contentPane
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(241,57,83));
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Flight Search");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(111, 305, 141, 27);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		
		//Adding MouseEvents To Use the close label("X")
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            Home.this.setLocation(x - xx, y - xy);  
			}
		});
		label.setBounds(-38, 0, 420, 275);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(Home.class.getResource("/images/d.jpg")));
		panel.add(label);
		
		JLabel lblWeGotYou = new JLabel("....Search Best Flights....");
		lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeGotYou.setForeground(new Color(240, 248, 255));
		lblWeGotYou.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWeGotYou.setBounds(96, 343, 189, 27);
		panel.add(lblWeGotYou);
		
		t3 = new JTextField();
		t3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t3.setBounds(395, 229, 179, 35);
		contentPane.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t4.setBounds(395, 309, 141, 35);
		contentPane.add(t4);
		t4.setColumns(10);
		
		
		Button button = new Button("Search");
		button.setFont(new Font("Dialog", Font.BOLD, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//getText from the textFields neglecting any whitespace
				
				String from=t1.getText().replaceAll("\\s",""),to=t2.getText().replaceAll("\\s","");
				String date=t3.getText();int nos=Integer.parseInt(t4.getText());
			
				Date date2 = new Date();  
			    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
			    String strDate = formatter.format(date2);  
			    String[] d1=new String[3];
			    d1=strDate.split("-");
			    
			    String[] d2=new String[3];
			    d2=date.split("-");
			    
			    if(Integer.parseInt(d2[0])<Integer.parseInt(d1[0]) || Integer.parseInt(d2[1])<Integer.parseInt(d1[1]) || Integer.parseInt(d2[2])<Integer.parseInt(d1[2])) {
			    	
			    	JOptionPane.showMessageDialog(null,"Cannot select the Previous Date");
			    }
			    else {
			    int range=0;	
					
				//Database Connection
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver"); //Used Oracle 11g
					Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle","system","system");	//Driver-'thin',Server-'localhost',PortNumber-'1521',sysId-'oracle',userName-'system',password-'system'
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from flight where source='"+from.toUpperCase()+"' and destination='"+to.toUpperCase()+"'");	
					
					while(rs.next()){
						range++;	//To check flights are present in database
					}
					
					con.close();
				}catch(Exception ee) {
					System.out.println(ee);
				}
			
				if(range==0)
					JOptionPane.showMessageDialog(null,"No Flights Between These Airpots");
				else
				new View(from,to,date,nos);	//new page call
				
			}
			}
				
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(395, 380, 283, 36);
		contentPane.add(button);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t1.setBounds(395, 83, 283, 36);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JLabel from = new JLabel("From");
		from.setFont(new Font("Tahoma", Font.BOLD, 15));
		from.setBounds(395, 45, 114, 27);
		contentPane.add(from);
		
		JLabel to = new JLabel("To");
		to.setFont(new Font("Tahoma", Font.BOLD, 15));
		to.setBounds(395, 132, 54, 14);
		contentPane.add(to);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		t2.setColumns(10);
		t2.setBounds(395, 157, 283, 36);
		contentPane.add(t2);
		
		JLabel date = new JLabel("Date (DD-MM-YYYY)");
		date.setFont(new Font("Tahoma", Font.BOLD, 15));
		date.setBounds(395, 204, 179, 14);
		contentPane.add(date);
		
		JLabel nos = new JLabel(" Number of Passengers");
		nos.setFont(new Font("Tahoma", Font.BOLD, 15));
		nos.setBounds(395, 275, 193, 23);
		contentPane.add(nos);
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(241, 57, 83));
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_close.setBounds(691, 0, 37, 27);
		contentPane.add(lbl_close);
		
		JButton btnNewButton = new JButton("select");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 51, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Using DatePicker Class For Easy Selection Of Date
				
				final JFrame f = new JFrame();
				t3.setText(new DatePicker(f).setPickedDate());
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(589, 229, 89, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				count++;
				t4.setText(""+count);	
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(255, 51, 102));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(563, 309, 54, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("-");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				count--;
				if(count>=0)
				t4.setText(""+count);	
				else
				count=0;
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(255, 51, 102));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnNewButton_2.setBounds(627, 309, 51, 35);
		contentPane.add(btnNewButton_2);
		
	}
}
