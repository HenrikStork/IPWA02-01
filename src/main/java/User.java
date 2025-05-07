
public class User {


	private Long id;

	private String name;
	private String password;
	private String role; 

	public User() {
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	
