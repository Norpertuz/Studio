package Theme;
import java.awt.Button;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Components.PasswordField;
import Components.Textfield;

@SuppressWarnings("serial")
public class Theme extends JPanel{
	
	public void Login(boolean dark, String Parent) {
		if (dark == true) {
			if (Parent == "Login") {
				//DARK THEME
				this.setBackground(Colors.DTBackground);
				Textfield username = (Textfield) this.getComponent(0);
				username.handleFocus(true, username.type, username.name);
				PasswordField password = (PasswordField) this.getComponent(1);
				password.handleFocus(true, password.name);
				this.getComponent(2).setBackground(Colors.DTPurple);
				this.getComponent(3).setForeground(Colors.DTPurple); 
				this.getComponent(6).setForeground(Colors.DTInactive);
				this.getComponent(7).setForeground(Colors.DTInactive);
				this.getComponent(8).setForeground(Colors.DTPurple);
			}
		} else {
			if (Parent == "Login") {
				//LIGHT THEME
				this.setBackground(Colors.LTBackground);
				Textfield username = (Textfield) this.getComponent(0);
				username.handleFocus(false, username.type, username.name);
				PasswordField password = (PasswordField) this.getComponent(1);
				password.handleFocus(false, password.name);
				this.getComponent(2).setBackground(Colors.LTBlue);
				this.getComponent(3).setForeground(Colors.LTBlue);
				this.getComponent(6).setForeground(Colors.LTGray);
				this.getComponent(7).setForeground(Colors.LTGray);
				this.getComponent(8).setForeground(Colors.LTBlue);
			}
		}
	}
	
	public void Register(boolean dark, String Parent) {
		if (dark == true) {
			if (Parent == "Register") {
				//DARK THEME
				this.setBackground(Colors.DTBackground);
				Textfield nickname = (Textfield) this.getComponent(2);
				nickname.handleFocus(true, nickname.type, nickname.name);
				Textfield fullname = (Textfield) this.getComponent(3);
				fullname.handleFocus(true, fullname.type, fullname.name);
				Textfield email = (Textfield) this.getComponent(4);
				email.handleFocus(true, email.type, email.name);
				PasswordField password = (PasswordField) this.getComponent(5);
				password.handleFocus(true, password.name);
				PasswordField rpassword = (PasswordField) this.getComponent(6);
				rpassword.handleFocus(true, rpassword.name);
				this.getComponent(9).setBackground(Colors.DTPurple);
			}
		} else {
			if (Parent == "Register") {
				//LIGHT THEME
				this.setBackground(Colors.LTBackground);
				Textfield nickname = (Textfield) this.getComponent(2);
				nickname.handleFocus(false, nickname.type, nickname.name);
				Textfield fullname = (Textfield) this.getComponent(3);
				fullname.handleFocus(false, fullname.type, fullname.name);
				Textfield email = (Textfield) this.getComponent(4);
				email.handleFocus(false, email.type, email.name);
				PasswordField password = (PasswordField) this.getComponent(5);
				password.handleFocus(false, password.name);
				PasswordField rpassword = (PasswordField) this.getComponent(6);
				rpassword.handleFocus(false, rpassword.name);
				this.getComponent(9).setBackground(Colors.LTBlue);
			}
		}
	}
	
	public void setDarkTheme(JFrame frame, boolean dark) {
		String Parent = frame.getClass().getName();
		Login(dark, Parent);
		Register(dark, Parent);
	}
	public Theme() {
		//nothing
	}
}
