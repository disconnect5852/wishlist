package com.wishlist.web;

import org.springframework.stereotype.Component;

@Component
public class JsfDTO {
	private String haxxor;

	public String getHaxxor() {
		return haxxor;
	}

	public void setHaxxor(String haxxor) {
		this.haxxor = haxxor;
	}
	
}
