package cm.model;

public class UserScoreModel {
	private String user_id;
	private String user_score;

	public UserScoreModel(String user_id, String user_score) {
		this.user_id = user_id;
		this.user_score = user_score;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_score() {
		return user_score;
	}

	public void setUser_score(String user_score) {
		this.user_score = user_score;
	}

}
