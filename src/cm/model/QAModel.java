package cm.model;

//Question and Answer model from Q&A Database
public class QAModel {

	private int id;
	private String question;
	private String answer;
	private String incorrect_answer1;
	private String incorrect_answer2;
	private String incorrect_answer3;

	public QAModel(int id, String question, String answer) {
		this.id = id;
		this.question = question;
		this.answer = answer;
	}

	public QAModel(int id, String incorrect_answer1, String incorrect_answer2, String incorrect_answer3) {
		this.id = id;
		this.incorrect_answer1 = incorrect_answer1;
		this.incorrect_answer2 = incorrect_answer2;
		this.incorrect_answer3 = incorrect_answer3;

	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getIncorrect_answer1() {
		return incorrect_answer1;
	}

	public void setIncorrect_answer1(String incorrect_answer1) {
		this.incorrect_answer1 = incorrect_answer1;
	}

	public String getIncorrect_answer2() {
		return incorrect_answer2;
	}

	public void setIncorrect_answer2(String incorrect_answer2) {
		this.incorrect_answer2 = incorrect_answer2;
	}

	public String getIncorrect_answer3() {
		return incorrect_answer3;
	}

	public void setIncorrect_answer3(String incorrect_answer3) {
		this.incorrect_answer3 = incorrect_answer3;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
