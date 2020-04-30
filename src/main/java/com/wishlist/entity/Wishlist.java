package com.wishlist.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    
    @ManyToOne
    private User owner;
    
    private String name;
    
    private Date createDate;
    
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ownerWishlist")
	@Cascade(CascadeType.ALL)
    private Set<WishlistElement> elements;
	
	public Wishlist() {
	}

	public Wishlist(User owner, String name, Date createDate) {
		this.owner = owner;
		this.name = name;
		this.createDate = createDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Set<WishlistElement> getElements() {
		return elements;
	}

	public void setElements(Set<WishlistElement> elements) {
		this.elements = elements;
	}
	
    
}
