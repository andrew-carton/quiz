package ie.andrew.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name="username")
	private String username;
	
	
	@Column(name="password")
	private String password;


	@Column(name="enabled")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean enabled;
	
	@Column(name="score")
	private int score;
	
	public int getScore() {
		return score;
	}


	public User() {
	}


	public void setScore(int score) {
		this.score = score;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}


	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.enabled = true;
		this.score = 0;
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


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
}
