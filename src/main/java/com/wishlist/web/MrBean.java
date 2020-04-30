package com.wishlist.web;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.wishlist.entity.Wishlist;
import com.wishlist.service.WishlistService;

@ManagedBean
@RequestScoped
public class MrBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Wishlist selectedWishlist;
	private String name;
	
	@Autowired
	private WishlistService wishservice;
	
	@Autowired
	private JsfDTO haxok;
	
    @PostConstruct
    public void init() {
    	magic=haxok.getHaxxor();
    	System.out.println("medzsikinit"+magic);
    	//wishlists=wishservice.findWishlistsForCurrentUser();
    	selectedWishlist=wishservice.findWishlistById(Long.valueOf(magic));
    }

	private String magic;

	public String getMagic() {
		
		return magic;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setMagic(String magic) {
		System.out.println("medzsik"+magic);
		this.magic = magic;
	}

	public Wishlist getSelectedWishlist() {
		return selectedWishlist;
	}

	public void setSelectedWishlist(Wishlist selectedWishlist) {
		this.selectedWishlist = selectedWishlist;
	}

}
