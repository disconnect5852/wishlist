package com.wishlist.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wishlist.entity.WishlistElement;

@Repository
public interface WishlistElementRepository extends CrudRepository<WishlistElement, Long> {
	@Modifying
	@Query("DELETE FROM WishlistElement e WHERE e.id=?1")
	public void forceDeleteById(long id);
}
