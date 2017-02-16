package kz.salta.model;

public class User {
	
	private String name;
	private String password;
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean authValidate() {
		if("admin".equalsIgnoreCase(this.name)
				&& "admin".equalsIgnoreCase(this.password)) {
			return true;
		}
		return false;
	}
}
