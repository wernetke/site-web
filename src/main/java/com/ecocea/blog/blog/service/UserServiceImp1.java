package com.ecocea.blog.blog.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.ecocea.blog.blog.repository.RoleRepository;
import com.ecocea.blog.blog.repository.UserRepository;
import com.ecocea.blog.blog.entity.User;
import com.ecocea.blog.blog.entity.Category;
import com.ecocea.blog.blog.entity.Role;


@Service("userService")
public class UserServiceImp1 implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    
    @Override
	public User findUserByEmail(String addMail) {
		return userRepository.findByEmail(addMail);
	}
    @Override
    public void updateUser(User user) {
    	
    	userRepository.save(user);
    }
    @Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
}
