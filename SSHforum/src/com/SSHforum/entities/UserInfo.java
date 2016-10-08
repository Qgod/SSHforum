package com.SSHforum.entities;

public class UserInfo {
	private Integer id;
	private String username;
	private String password;
	private String phoneNumber;
	private String email;
	private String question;
	private String answer;
	private String nickname;
	private int privateletternumber;
	private String address;
	private String worktype;
	private String education;
	private String introduce;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWorktype() {
		return worktype;
	}

	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public int getPrivateletternumber() {
		return privateletternumber;
	}

	public void setPrivateletternumber(int privateletternumber) {
		this.privateletternumber = privateletternumber;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", question=" + question + ", answer=" + answer + ", nickname="
				+ nickname + ", address=" + address + ", worktype=" + worktype + ", education=" + education
				+ ", introduce=" + introduce + "]";
	}

}
