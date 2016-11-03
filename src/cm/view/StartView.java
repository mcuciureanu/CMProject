package cm.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class StartView extends View {
	
	private JPanel startPanel;
	private JLabel welcomeLabel;
	private JButton startButton;

	public StartView(){
		setFrame();
		
		startPanel = new JPanel();
		welcomeLabel = new JLabel("Welcome!", SwingConstants.CENTER);
		startButton = new JButton("start");
		
		setStartPanel();
		setWelcomeLabel();
		setStartButton();
		
		startButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				 startPanel.setVisible(false);
				 new GameView();
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
	
	public void setStartButton(){
		startButton.setBackground(Color.white);
		startButton.setLocation(100,315);
		startButton.setSize(400,50);
	}
}