package cm.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window {
	private JFrame frame = new JFrame("Title");
	private JPanel panel = new JPanel();
    private JButton[] answerButton = new JButton[4];
    private JButton nextButton = new JButton("Next");
    private JLabel questionLable = new JLabel();
	
	public Window(){
		setFrame();
		setPanel();
		setLable();
		setAnswerButtons(); 	
	}
	
	public void setFrame(){
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
	}
	
	public void setPanel(){
		frame.add(panel);
	}
	
	public void setLable(){
		questionLable.setText("question");
		questionLable.setHorizontalAlignment(200);
		questionLable.setVerticalAlignment(100);
		frame.add(questionLable);
	}
	
	public void setAnswerButtons(){
		for(JButton button : answerButton){
			panel.add(button);
		}
	}
	
	public void setNextButton(){
		panel.add(nextButton);
	}
}
