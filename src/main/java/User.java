
public class User {

	private String name;
	private String password; 

	public User() {
	}

	public User(String name, String password) {
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

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User) {
			User b = (User)obj;
			if(b.getName().equals(this.name) && b.getPassword().equals(this.password)) {
				return true;
			}
		}
		return false;
	}
}

	
