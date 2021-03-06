import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Components.Button;
import Components.Heading;
import Components.PasswordField;
import Components.Textfield;
import Theme.Colors;
import Theme.Theme;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;




@SuppressWarnings("serial")
public class UserEdit extends JFrame {
	

	int posX=0,posY=0;
	static String user1;
    static int admin;
    static String fullname11, nickname11, password11, mail1;
    static ResourceBundle res;
	private Theme contentPane;

	/**
	 * Launch the application.
	 */
	
	
	
	public static void okno_edycji1(String user,int is_Admin) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					
					user1=user;
					admin = is_Admin;
					
					
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
						Statement stmt=con.createStatement();
						String sql="Select * from users WHERE fullname='"+user+"'";
						ResultSet rs=stmt.executeQuery(sql);
						if(rs.next()) {
							nickname11=rs.getString("nickname");
							fullname11 = rs.getString("fullname");
							password11=rs.getString("password");
							mail1 =rs.getString("email");
					}
						else
							JOptionPane.showMessageDialog(null, res.getString("n_logged"));
						
						con.close();
					} 
					catch(Exception e){System.out.print(e);}
					
					

					
					UserEdit frame = new UserEdit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserEdit() {
		
		if(GlobalVariables.jezyk==1)res = ResourceBundle.getBundle("lang_PL");
		if(GlobalVariables.jezyk==0)res = ResourceBundle.getBundle("lang_EN");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 621);
		contentPane = new Theme();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Colors.DTBackground);
		contentPane.setLayout(null);
		
		setUndecorated(true);
		
		JLabel DragBar = new JLabel("");
		DragBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				posX=e.getX();
                posY=e.getY();
				
				
			}
		});
		DragBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {
				
                setLocation (evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
			}
		});
		DragBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		DragBar.setBounds(0, 0, 350, 30);
		getContentPane().add(DragBar);
		
		
		JLabel close = new JLabel("");
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			dispose();
			}
		});
		close.setHorizontalAlignment(SwingConstants.CENTER);
		close.setIcon(new ImageIcon(UserEdit.class.getResource("/assets/closeIcon.png")));
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.setBounds(360, 0, 46, 30);
		getContentPane().add(close);
		
		
		Heading lblNewLabel = new Heading(res.getString("edit_profile"), Colors.DTPurple);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(28, 22, 186, 37);
		getContentPane().add(lblNewLabel);
		
		/*
		textField = new Label_TextField("Nickname","default");
		textField.setBounds(28, 240, 350, 82);
		getContentPane().add(textField);
		*/
		String nickname = res.getString("username");
		Textfield label_TextField_0 = new Textfield("default", nickname);
		GridBagLayout gridBagLayout_0 = (GridBagLayout) label_TextField_0.getLayout();
		gridBagLayout_0.rowWeights = new double[]{0.0, 0.0};
		gridBagLayout_0.rowHeights = new int[]{0, 0};
		gridBagLayout_0.columnWeights = new double[]{0.0};
		gridBagLayout_0.columnWidths = new int[]{0};
		label_TextField_0.setBounds(28, 70, 350, 82);
		getContentPane().add(label_TextField_0);
		
		String fullname = res.getString("fullname");
		Textfield label_TextField = new Textfield("default", fullname);
		GridBagLayout gridBagLayout = (GridBagLayout) label_TextField.getLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0};
		gridBagLayout.columnWidths = new int[]{0};
		label_TextField.setBounds(28, 188, 350, 82);
		getContentPane().add(label_TextField);
		
		String password = res.getString("password");
		PasswordField label_TextField_1 = new PasswordField(password);
		GridBagLayout gridBagLayout_1 = (GridBagLayout) label_TextField_1.getLayout();
		gridBagLayout_1.rowWeights = new double[]{0.0, 0.0};
		gridBagLayout_1.rowHeights = new int[]{0, 0};
		gridBagLayout_1.columnWeights = new double[]{0.0};
		gridBagLayout_1.columnWidths = new int[]{0};
		label_TextField_1.setBounds(28, 311, 350, 82);
		getContentPane().add(label_TextField_1);
		
		String email = "E-mail";
		Textfield label_TextField_2 = new Textfield("default", email);
		GridBagLayout gridBagLayout_2 = (GridBagLayout) label_TextField_2.getLayout();
		gridBagLayout_2.rowWeights = new double[]{0.0, 0.0};
		gridBagLayout_2.rowHeights = new int[]{0, 0};
		gridBagLayout_2.columnWeights = new double[]{0.0};
		gridBagLayout_2.columnWidths = new int[]{0};
		label_TextField_2.setBounds(28, 429, 350, 82);
		getContentPane().add(label_TextField_2);
		
		JLabel nickname1 = new JLabel(nickname11);
		nickname1.setBounds(225, 163, 129, 14);
		getContentPane().add(nickname1);
		
		JLabel fullname1 = new JLabel(fullname11);
		fullname1.setBounds(225, 286, 130, 14);
		getContentPane().add(fullname1);
		
		JLabel password1 = new JLabel(password11);
		password1.setBounds(225, 404, 144, 14);
		getContentPane().add(password1);
		
		JLabel email1 = new JLabel(mail1);
		email1.setBounds(225, 522, 137, 14);
		getContentPane().add(email1);
		Button customButton__1 = new Button();
		customButton__1.setBackground(Colors.DTPurple);
		customButton__1.setText(res.getString("remove_acc"));
		customButton__1.setVisible(false);
		if(admin==1) {
			customButton__1.setVisible(true);
			customButton__1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					
					
					
					
					
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
						Statement stmt=con.createStatement();
						String sql="delete from users where fullname='"+user1+"'";
					
						
						stmt.executeUpdate(sql);
						stmt.close();
						
						
						con.close();
						if(GlobalVariables.fullname1.equals(user1)) {
						final Frame[] frames = Frame.getFrames();
						if (frames != null)
						    for (final Frame f : frames)
						    {
						        f.dispose();
						    }
						JOptionPane.showMessageDialog(null,res.getString("acc_remove") );
						String[] errorSoon = new String[1];
						Login.main(errorSoon);
						}else {
							final Frame[] frames = Frame.getFrames();
							if (frames != null)
							    for (final Frame f : frames)
							    {
							        f.dispose();
							    }
							JOptionPane.showMessageDialog(null,res.getString("acc_remove") );
							MainWindow.main1(GlobalVariables.fullname1,1);
							list_users.main22(true);
							
						}
					} 
					catch(Exception e){System.out.print(e);}
					
					
					
					
					
					
					
					
					
					
				}
			});
			}
		customButton__1.setBounds(28, 547, 153, 46);
		getContentPane().add(customButton__1);
		Button customButton_ = new Button();
		customButton_.setBackground(Colors.DTPurple);
		customButton_.setText(res.getString("save_changes"));
		customButton_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://remotemysql.com/Lf5M3N6QnK","Lf5M3N6QnK","7me26nI8IY");
					Statement stmt=con.createStatement();
					Statement stmt2=con.createStatement();
					String sql="";
				
					
					
				
					if(!label_TextField_0.textfield.getText().equals("")) {
					sql="update users set nickname='"+label_TextField_0.textfield.getText()+"' WHERE fullname='"+fullname11+"'";
					stmt.executeUpdate(sql);
					//TimeUnit.SECONDS.sleep(3);
					JOptionPane.showMessageDialog(null,res.getString("e_username") );
				
					}
					if(!label_TextField.textfield.getText().equals("")) {
						sql="update users set fullname='"+label_TextField.textfield.getText()+"' WHERE fullname='"+fullname11+"'";
						stmt.executeUpdate(sql);	
						//TimeUnit.SECONDS.sleep(3);
						fullname11 = label_TextField.textfield.getText();
						JOptionPane.showMessageDialog(null,res.getString("e_fullname") );
					
						
					}
					if(!label_TextField_1.passwordfield.getText().equals("")) {
						sql="update users set password='"+label_TextField_1.passwordfield.getText()+"' WHERE fullname='"+fullname11+"'";
						stmt.executeUpdate(sql);	
						//TimeUnit.SECONDS.sleep(3);
						JOptionPane.showMessageDialog(null,res.getString("e_password") );
					}
					if(!label_TextField_2.textfield.getText().equals("")) {
					
						String sql2="update users set email='"+label_TextField_2.textfield.getText()+"' WHERE fullname='"+fullname11+"'";
						stmt2.executeUpdate(sql2);
						//TimeUnit.SECONDS.sleep(3);
						JOptionPane.showMessageDialog(null,res.getString("e_mail") );
						}
					
					//con.close();
					stmt.close();
					stmt2.close();
					//MainWindow nw = new MainWindow();
					//nw.dispose(); //nw jest konieczne by dzialac na innym jframie z poziomu innego jframe
					//nw.setVisible(false);
					//nw.dispose();
					//nw = null;
					//
					
					final Frame[] frames = Frame.getFrames();
					if (frames != null)
					    for (final Frame f : frames)
					    {
					        f.dispose();
					    }
					if(GlobalVariables.fullname1.equals(fullname11)) {MainWindow.main1(fullname11, admin);}
					else {
					MainWindow.main1(fullname11, admin);
					}
					/*
					JOptionPane.showMessageDialog(null,"Wymagane jest ponowne uruchomienie aplikacji." );
					System.exit(0);
					*/
				} 
				catch(Exception e){System.out.print(e);}
				
				
				
				
				
				
				
				
				
				
			}
		});
		customButton_.setBounds(225, 547, 153, 46);
		getContentPane().add(customButton_);
		
		JLabel lblAktualnyNickname = new JLabel(res.getString("a_username"));
		lblAktualnyNickname.setForeground(Color.GRAY);
		lblAktualnyNickname.setBounds(28, 160, 186, 14);
		contentPane.add(lblAktualnyNickname);
		
		JLabel lblAktualnyFullname = new JLabel(res.getString("a_fullname"));
		lblAktualnyFullname.setForeground(Color.GRAY);
		lblAktualnyFullname.setBounds(28, 286, 186, 14);
		contentPane.add(lblAktualnyFullname);
		
		JLabel lblAktualneHaslo = new JLabel(res.getString("a_password"));
		lblAktualneHaslo.setForeground(Color.GRAY);
		lblAktualneHaslo.setBounds(28, 404, 186, 14);
		contentPane.add(lblAktualneHaslo);
		
		JLabel lblAktualnyEmail = new JLabel(res.getString("a_mail"));
		lblAktualnyEmail.setForeground(Color.GRAY);
		lblAktualnyEmail.setBounds(28, 522, 186, 14);
		contentPane.add(lblAktualnyEmail);
		
		
		
		contentPane.setDarkTheme(this, GlobalVariables.isDark);
		
		
		
		
	}
}
