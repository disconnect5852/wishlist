package com.wishlist;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
public class MaiUserDetailz extends org.springframework.security.core.userdetails.User {
	private Long userId;
	
	public MaiUserDetailz(String username, String password, Collection<? extends GrantedAuthority> authorities, Long userId) {
		super(username, password, authorities);
		this.userId=userId;
	}

	public Long getUserId() {
		return userId;
	}
	
}
