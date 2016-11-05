package cm.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameView extends View {
	private String username;
	private JPanel gamePanel;
	private JLabel usernameLabel;
	private JLabel scoreLabel;
	private JLabel questionLabel;
	private JLabel timeLabel;
	private JButton[] answerButton;

	public GameView(String username){
		this.username = username;
		
		gamePanel = new JPanel();
		usernameLabel = new JLabel("username: " + this.username, SwingConstants.LEFT);
		scoreLabel = new JLabel("score: 0", SwingConstants.RIGHT);
		questionLabel = new JLabel("Question", SwingConstants.CENTER);
		timeLabel = new JLabel("0:00", SwingConstants.CENTER);
		answerButton = new JButton[4];
		
		setFrame();
		setGamePanel();
		setUsernameLabel();
		setScoreLabel();
		setQuestionLabel();
		setTimeLabel();
		setAnswerButton();
		setAnwerButtonText();
		
		answerButton[3].addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				 gamePanel.setVisible(false);
				 new EndView();
			  } 
		} );
	}
	
	public void setGamePanel(){
		frame.add(gamePanel);
		gamePanel.setLayout(null);
		gamePanel.setBackground(Color.BLUE);
	}
	
	public void setUsernameLabel(){
		gamePanel.add(usernameLabel);
		usernameLabel.setBackground(Color.BLACK);
		usernameLabel.setLocation(22,10);
		usernameLabel.setSize(200,20);
	}
	
	public void setScoreLabel(){
		gamePanel.add(scoreLabel);
		scoreLabel.setBackground(Color.blue);
		scoreLabel.setLocation(10,30);
		scoreLabel.setSize(58,20);
	}
	
	public void setQuestionLabel(){
		gamePanel.add(questionLabel);
		questionLabel.setBackground(Color.blue);
		questionLabel.setLocation(0,150);
		questionLabel.setSize(600,50);
	}
	
	public void setTimeLabel(){
		gamePanel.add(timeLabel);
		timeLabel.setBackground(Color.BLACK);
		timeLabel.setLocation(0,317);
		timeLabel.setSize(592,50);
	}
	
	public int setAnswerButtonXLocation(int index){
		if(index % 2 == 0)
			return 23;
		else
			return 300;
	}
	
	public int setAnswerButtonYLocation(int index){
		if(index < 2)
			return 210;
		else
			return 265;
	}

	public void setAnswerButton(){
		for(int index = 0; index < answerButton.length; index++){
			answerButton[index] = new JButton();
			answerButton[index].setSize(270,50);
			answerButton[index].setLocation(setAnswerButtonXLocation(index), setAnswerButtonYLocation(index));
			gamePanel.add(answerButton[index]);
		}
	}
	
	public void setAnwerButtonText(){
		answerButton[0].setText("A");
		answerButton[1].setText("B");
		answerButton[2].setText("C");
		answerButton[3].setText("D");
		//...
	}
}