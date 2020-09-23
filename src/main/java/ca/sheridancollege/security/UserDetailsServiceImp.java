package ca.sheridancollege.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ca.sheridancollege.beans.Role;
import ca.sheridancollege.repositories.UserRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		ca.sheridancollege.beans.User user = userRepo.findByUsername(username);
		

		
		if (user == null) {

			System.out.println("User not found:" + username);

			throw new UsernameNotFoundException

			("User " + username + " was not found in the database");

		}
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

		
		for (Role role : user.getRoles()) {

			grantList.add(new SimpleGrantedAuthority(role.getRolename()));

		}
		
		UserDetails userDetails = (UserDetails) new User(user.getUsername(), user.getPassword(), grantList);

		return userDetails;		
	}
}