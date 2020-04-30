package com.wishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wishlist.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
//    @Query("SELECT u FROM User u JOIN FETCH")
//    List<User> findAllUsers();
    
//    @Modifying
//    @Query("UPDATE Role r SET r.")
//    void adminizeUser(long id);
}
