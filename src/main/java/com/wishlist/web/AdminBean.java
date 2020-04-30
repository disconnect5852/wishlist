package com.wishlist.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.wishlist.entity.User;
import com.wishlist.service.UserService;

@ManagedBean
@ViewScoped
public class AdminBean implements Serializable {
	private static final long serialVersionUID = 2497000132813201777L;
	//@CollectionType(type = "java.util.List")
	private List<User> users;
	private User selected;
	
	private String pw;
	
	@Autowired
	private UserService usrservice;
	
    @PostConstruct
    public void init() {
        users= usrservice.listAllUsers();
    }

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getSelected() {
		return selected;
	}

	public void setSelected(User selected) {
		this.selected = selected;
	}
	
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void deleteUser() {
		if (selected!=null) usrservice.deleteUser(selected.getId());
		init();
	}
	public void adminUser() {
		if (selected!=null) usrservice.adminUser(selected.getId());
		init();
	}
	public void revokeAdmin() {
		if (selected!=null) usrservice.revokeAdmin(selected.getId());
		init();
	}
	public void changePw() {
		if (selected!=null && pw!=null && !pw.isEmpty()) usrservice.changePassword(selected.getId(),pw);
		init();
	}
}
