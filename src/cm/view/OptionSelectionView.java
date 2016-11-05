package cm.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OptionSelectionView extends View{
	
	private String username;
	private JPanel optionSelectionPanel;
	private JLabel greetingLabel;
	private JLabel optionSelectionLabel;
	private JButton[] optionButton;
	private JButton startGameButton;

	public OptionSelectionView(String username){	
		this.username = username;

		optionSelectionPanel = new JPanel();
		greetingLabel = new JLabel("<html>Welcome, " + this.username + "!", SwingConstants.CENTER);
		optionSelectionLabel = new JLabel("Select a game theme: ", SwingConstants.CENTER);
		optionButton = new JButton[3];
		startGameButton = new JButton("start");
		
		setFrame();
		setOptionSelectionPanel();
		setGreetingLabel();
		setOptionSelectionLabel();
		setOptionButton();
		setStartGameButton();
		
		startGameButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  optionSelectionPanel.setVisible(false);
				  new GameView(username);
			  } 
		} );
		
		frame.revalidate();	
	}
	
	public void setOptionSelectionPanel(){
		frame.add(optionSelectionPanel);
		optionSelectionPanel.setLayout(null);
		optionSelectionPanel.setBackground(Color.white);
		optionSelectionPanel.add(greetingLabel);
		optionSelectionPanel.add(optionSelectionLabel);
		optionSelectionPanel.add(startGameButton);
	}
	
	public void setGreetingLabel(){
		greetingLabel.setLocation(0,10);
		greetingLabel.setSize(600,50);
	}
	
	public void setOptionSelectionLabel(){
		optionSelectionLabel.setLocation(0,60);
		optionSelectionLabel.setSize(600,50);
	}
	
	public void setStartGameButton(){
		startGameButton.setBackground(Color.white);
		startGameButton.setLocation(100,315);
		startGameButton.setSize(400,50);
	}
	
	public void setOptionButton(){
		for(int index = 0; index < optionButton.length; index++){
			optionButton[index] = new JButton();
			optionButton[index].setSize(150,200);
			optionButton[index].setLocation(setButtonXLocation(index), setButtonYLocation(index));
			optionSelectionPanel.add(optionButton[index]);
		}
	}
	
	public int setButtonXLocation(int index){
		if(index == 0)
			return 62;
		else if(index == 1)
			return 222;
		else
			return 382;
	}
	
	public int setButtonYLocation(int index){
		return 100;
	}
}
