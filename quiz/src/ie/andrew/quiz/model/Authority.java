package ie.andrew.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(AuthorityPK.class)
@Table(name="authorities")
public class Authority {
	
	@Id
	@Column(name="username")
	private String username;

	@Id
	@Column(name="authority")
	private String authority;
	
	public Authority(String username, String authority) {
		this.username = username;
		this.authority = authority;
	}

}
