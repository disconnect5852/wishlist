package com.wishlist.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class WishlistElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    
	@ManyToOne
	private Wishlist ownerWishlist;
	
	private String name;
	
	private Integer price;
	
	private Date createDate;

	public WishlistElement() {
	}

	public WishlistElement(Wishlist ownerWishlist, String name, Integer price, Date createDate) {
		this.ownerWishlist = ownerWishlist;
		this.name = name;
		this.price = price;
		this.createDate = createDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Wishlist getOwnerWishlist() {
		return ownerWishlist;
	}

	public void setOwnerWishlist(Wishlist ownerWishlist) {
		this.ownerWishlist = ownerWishlist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
