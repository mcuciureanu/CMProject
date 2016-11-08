package cm.model;

//Question  model from User Database
public class UserModel {
	private int id_user;
	private String name_user;
	private String password_user;
	private int score_user;

	public UserModel(String name_user, int score_user) {
		this.name_user = name_user;
		this.score_user = score_user;
	}

	public UserModel(String name_user, String password_user, int score_user) {
		this.name_user = name_user;
		this.password_user = password_user;
		this.score_user = score_user;
	}

	public UserModel(int id_user, String name_user, String password_user, int score_user) {
		this.id_user = id_user;
		this.name_user = name_user;
		this.password_user = password_user;
		this.score_user = score_user;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	public String getPassword_user() {
		return password_user;
	}

	public void setPassword_user(String password_user) {
		this.password_user = password_user;
	}

	public int getScore_user() {
		return score_user;
	}

	public void setScore_user(int score_user) {
		this.score_user = score_user;
	}

}
