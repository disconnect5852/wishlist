package com.wishlist.service;

import java.util.List;

import com.wishlist.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    
    List<User> listAllUsers();
    
    void deleteUser(long id);
    void adminUser(long id);

	void revokeAdmin(long id);

	void changePassword(long id, String newPassword);
}
