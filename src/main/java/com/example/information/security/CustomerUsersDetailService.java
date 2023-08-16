package com.example.information.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.information.entity.Role;
import com.example.information.entity.User;
import com.example.information.repository.UserRepository;
@Service
public class CustomerUsersDetailService implements UserDetailsService{

	
	private UserRepository userrepository;

	
	public CustomerUsersDetailService(UserRepository userrepository) {
		super();
		this.userrepository = userrepository;
	}


	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userrepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(() ->
		new UsernameNotFoundException("User not found with username or email:" + usernameOrEmail));
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
}
