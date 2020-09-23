package ca.sheridancollege.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String rolename;
	private String prettyRolename;
	
	@ManyToMany(cascade = CascadeType.REFRESH)
	@JoinTable(name = "user_roles",
			joinColumns = {@JoinColumn(table="user", name = "user_id", referencedColumnName = "id")}, 
			inverseJoinColumns = {@JoinColumn(table="role", name = "roles_id", referencedColumnName = "id")})
//	@ForeignKey(name="user_roles_user_id",inverseName="user_roles_role_id")
	private List<User> users = new ArrayList<User>();
	
	public Role(String rolename) {
		this.rolename = rolename;
	}
}
