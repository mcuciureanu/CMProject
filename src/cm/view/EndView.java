package cm.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class EndView extends View {
	private String username;
	private int score;
	private JButton closeGameButton;
	private JLabel goodByeLabel;
	private JPanel endGamePanel;
	
	public EndView(String username){
		this.username = username;
		
		endGamePanel = new JPanel();
		goodByeLabel = new JLabel("<html>Congratulations, " + this.username +
				"!<br>Your score: " + this.score + "</html>", SwingConstants.CENTER);
		closeGameButton = new JButton("End Game");
		
		setFrame();
		setEndGamePanel();
		setGoodByeLabel();
		setCloseGameButton();
		
		closeGameButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				 frame.dispose(); //Close window
			  } 
		} );
		
		frame.revalidate();	
	}
	
	public void setEndGamePanel(){
		frame.add(endGamePanel);
		endGamePanel.setLayout(null);
		endGamePanel.setBackground(Color.white);
		endGamePanel.add(goodByeLabel);
	}
	
	public void setGoodByeLabel(){
		goodByeLabel.setLocation(0,100);
		goodByeLabel.setSize(600,50);
	}
	
	public void setCloseGameButton(){
		endGamePanel.add(closeGameButton);
		closeGameButton.setLocation(100,315);
		closeGameButton.setSize(400,50);
	}
}
