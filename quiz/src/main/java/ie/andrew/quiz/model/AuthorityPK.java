package ie.andrew.quiz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class AuthorityPK implements Serializable {
	protected String username;
	protected String authority;


    public AuthorityPK() {}


	public AuthorityPK(String username, String authority) {
		this.username = username;
		this.authority = authority;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authority == null) ? 0 : authority.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthorityPK other = (AuthorityPK) obj;
		if (authority == null) {
			if (other.authority != null)
				return false;
		} else if (!authority.equals(other.authority))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

   
}
