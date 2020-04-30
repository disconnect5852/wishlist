package com.wishlist.service;

import java.util.List;

import com.wishlist.entity.Wishlist;

public interface WishlistService {
	List<Wishlist> findWishlistsForCurrentUser();

	boolean newWishlistForCurrentUser(String name);

	boolean newWishlistElement(String newwishelementname, Integer newwishelementprice, Long ownerid);

	boolean editWishlistElement(String wishelementname, Integer wishelementprice, Long id);
	
	void deleteWishlistElement(Long id);

	Wishlist findWishlistById(Long id);

	void deleteSelectedWishlist(Long id);
}
