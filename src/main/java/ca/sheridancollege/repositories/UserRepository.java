package ca.sheridancollege.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.sheridancollege.beans.Role;
import ca.sheridancollege.beans.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findById(long id);
    User findByUsername(String username);
    List<User> findByRoles(Role role);
}
