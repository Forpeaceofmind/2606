package edu.training.web.bean;

public class UserRegInfo {
	private long id;
	private String login;
	private String password;
	private String name;
	private String birthDate;
	private String residence;

	public UserRegInfo() {

	}

	public UserRegInfo(String login, String password, String name, String birthDate, String residence) {
		this.login = login;
		this.password = password;
		this.name = name;
		this.birthDate = birthDate;
		this.residence = residence;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}
}