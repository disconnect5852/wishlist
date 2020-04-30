package com.wishlist.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wishlist.entity.Wishlist;

@Repository
public interface WishlistRepository extends CrudRepository<Wishlist, Long>  {
	//@Query("SELECT w FROM Wishlist w JOIN User u ON w.owner_id=u.id WHERE u.id=?1")
	//@Query("SELECT w FROM Wishlist w WHERE w.owner_id=?1")
	List<Wishlist> findAllByOwnerId(long owner);
}
