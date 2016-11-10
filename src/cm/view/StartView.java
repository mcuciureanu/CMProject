package cm.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class StartView extends View {
	
	private String username;
	private JPanel startPanel;
	private JLabel welcomeLabel;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JButton submitButton;

	public StartView(){		
		startPanel = new JPanel();
		welcomeLabel = new JLabel("Welcome!", SwingConstants.CENTER);
		usernameTextField = new JTextField();
		passwordTextField = new JPasswordField();
		submitButton = new JButton("submit");
		
		setFrame();
		setStartPanel();
		setWelcomeLabel();
		setUsernameTextField();
		setPasswordTextField();
		setSubmitButton();
		
		usernameTextField.addActionListener( new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	passwordTextField.requestFocusInWindow();
		    }
		});
		
		usernameTextField.setDocument(new JTextFieldLimit(10));
		   
		Action action = new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {				 
		        username = usernameTextField.getText();
				startPanel.setVisible(false);
				new OptionSelectionView(username);
		    }
		};
		
		passwordTextField.addActionListener( action );
		
		
		submitButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				 startPanel.setVisible(false);
				 new OptionSelectionView(username);
			  } 
		} );
		
		frame.revalidate();	
	}

	public void setStartPanel(){
		frame.add(startPanel);
		startPanel.setLayout(null);
		startPanel.setBackground(Color.white);
		startPanel.add(welcomeLabel);
		startPanel.add(submitButton);
	}
	
	public void setWelcomeLabel(){
		welcomeLabel.setLocation(0,100);
		welcomeLabel.setSize(600,50);
	}
	
	public void setUsernameTextField(){
		startPanel.add(usernameTextField);
		usernameTextField.setLocation(302,202);
		usernameTextField.setSize(115,20);
		
		JLabel usernameLabel = new JLabel("username: ", SwingConstants.CENTER);
		startPanel.add(usernameLabel);
		usernameLabel.setLocation(230,200);
		usernameLabel.setSize(70,20);
	}
	
	public void setPasswordTextField(){
		startPanel.add(passwordTextField);
		passwordTextField.setLocation(302,222);
		passwordTextField.setSize(115,20);
		
		JLabel passewordLabel = new JLabel("password: ", SwingConstants.CENTER);
		startPanel.add(passewordLabel);
		passewordLabel.setLocation(230,220);
		passewordLabel.setSize(70,20);
	}
	
	
	public void setSubmitButton(){
		submitButton.setBackground(Color.white);
		submitButton.setLocation(260,250);
		submitButton.setSize(80,20);
	}
}

class JTextFieldLimit extends PlainDocument {
	private static final long serialVersionUID = 1L;
	private int limit;
	  JTextFieldLimit(int limit) {
	    super();
	    this.limit = limit;
	  }
	
	  JTextFieldLimit(int limit, boolean upper) {
	    super();
	    this.limit = limit;
	  }
	
	  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
	    if (str == null)
	      return;
	
	    if ((getLength() + str.length()) <= limit) {
	      super.insertString(offset, str, attr);
	    }
	  }
}
