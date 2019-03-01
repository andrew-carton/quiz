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
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}


	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.enabled = true;
	}
	
	
	
}
