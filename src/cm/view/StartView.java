package cm.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class StartView extends View {
	
	private JPanel startPanel;
	private JLabel welcomeLabel;
	private JTextField usernameTextField;
	private JButton startButton;

	public StartView(){		
		startPanel = new JPanel();
		welcomeLabel = new JLabel("Welcome!", SwingConstants.CENTER);
		usernameTextField = new JTextField();
		startButton = new JButton("start");
		
		setFrame();
		setStartPanel();
		setWelcomeLabel();
		setUsernameTextField();
		setStartButton();
		
		/*
		 * username maximum of characters is 10.
		 */
		usernameTextField.setDocument(new JTextFieldLimit(10));
		   
		Action action = new AbstractAction()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {				 
		        String username = usernameTextField.getText();
				startPanel.setVisible(false);
			    new GameView(username);
		    }
		};

		usernameTextField.addActionListener( action );
		
		startButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				 String username = usernameTextField.getText();
				 startPanel.setVisible(false);
				 new GameView(username);
			  } 
		} );
		
		frame.revalidate();	
	}
	
	public void setStartPanel(){
		frame.add(startPanel);
		startPanel.setLayout(null);
		startPanel.setBackground(Color.white);
		startPanel.add(welcomeLabel);
		startPanel.add(startButton);
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
	
	public void setStartButton(){
		startButton.setBackground(Color.white);
		startButton.setLocation(100,315);
		startButton.setSize(400,50);
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
