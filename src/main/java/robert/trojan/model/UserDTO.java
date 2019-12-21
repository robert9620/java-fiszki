package robert.trojan.model;

public class UserDTO {
	private String username;
	private String name;
	private String surname;
	private String password;
	private int points;
	private int mistakes;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getMistakes() {
		return mistakes;
	}

	public void setMistakes(int mistakes) {
		this.mistakes = mistakes;
	}
}
