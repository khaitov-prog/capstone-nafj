package ca.sheridancollege.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.sheridancollege.beans.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findById(long id);
	List<Role> findAll();
}
