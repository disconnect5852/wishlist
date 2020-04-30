package com.wishlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wishlist.entity.Role;
import com.wishlist.entity.User;
import com.wishlist.repository.RoleRepository;
import com.wishlist.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles= new HashSet<Role>(roleRepository.findAll());
        if (!user.getAdminRole()) roles.removeIf(r -> r.getId()==0L);
        user.setRoles(new HashSet<>(roles));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Transactional
	@Override
	public List<User> listAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void adminUser(long id) {
		Optional<User> user= userRepository.findById(id);
		Optional<Role> adminrole= roleRepository.findById(0L);
		if (user.isPresent() && adminrole.isPresent()) {
			User theuser= user.get();
			theuser.getRoles().add(adminrole.get());
			userRepository.save(theuser);
		}
	}
	
	@Transactional
	@Override
	public void revokeAdmin(long id) {
		Optional<User> user= userRepository.findById(id);
		Optional<Role> adminrole= roleRepository.findById(0L);
		if (user.isPresent() && adminrole.isPresent()) {
			User theuser= user.get();
			theuser.getRoles().remove(adminrole.get());
			userRepository.save(theuser);
		}
	}
	
	@Transactional
	@Override
	public void changePassword(long id, String newPassword) {
		if (newPassword==null || newPassword.isEmpty()) return;
		Optional<User> user= userRepository.findById(id);
		if (user.isPresent()) {
			User theuser= user.get();
			theuser.setPassword(bCryptPasswordEncoder.encode(newPassword));
			userRepository.save(theuser);
		}
	}
}
