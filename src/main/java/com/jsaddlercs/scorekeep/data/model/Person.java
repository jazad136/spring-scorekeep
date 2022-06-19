package com.jsaddlercs.scorekeep.data.model;

public class Person {
	private String nickname;
	
	private String personName;
	
	public Person(String nickname, String personName) {
		this.nickname = nickname;
		this.personName = personName;
	}

	@Override
	public String toString() {
		return "Person [nickname=" + nickname + ", personName=" + personName + "]";
	}

	public String getNickname() { return nickname; }
	public void setNickname(String nickname) { this.nickname = nickname; }

	public String getPersonName() { return personName; }
	public void setPersonName(String personName) { this.personName = personName; }
}
