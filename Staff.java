package com.hasasiki.sellproject;

public class Staff {
	private String name;
	private String id;
	private String password;
	Csv usecsv = new Csv();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void LogIn(String csvFilePath) {
		/**use csv method to check*/
		usecsv.CheckDatebase(csvFilePath,getId(),getPassword());
		
	}
}
