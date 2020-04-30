package com.wishlist.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.wishlist.entity.Wishlist;
import com.wishlist.entity.WishlistElement;
import com.wishlist.service.WishlistService;

@ManagedBean
@ViewScoped
public class WishlistBean implements Serializable {
	private static final long serialVersionUID = 8899536580447869768L;
	private static final String INPUT_FAIL = "Check yo self (input)...";
	private List<Wishlist> wishlists;
	private Wishlist selectedWishlist;
	private WishlistElement selectedElement;
	private String newwishlistname;
	private String newwishelementname;
	private Integer newwishelementprice;

	@Autowired
	private WishlistService wishservice;

	@PostConstruct
	public void init() {
		wishlists = wishservice.findWishlistsForCurrentUser();
	}

	public void newList() {
		if (newwishlistname == null || newwishlistname.isEmpty()) {
			returnMessage(INPUT_FAIL);
			return;
		}
		returnMessage(wishservice.newWishlistForCurrentUser(newwishlistname));
		init();
	}

	public void deleteList() {
		if (selectedWishlist == null)
			return;
		wishservice.deleteSelectedWishlist(selectedWishlist.getId());
		init();
	}

	public void newListElement() {
		if (newwishelementname == null || newwishelementname.isEmpty()) {
			returnMessage(INPUT_FAIL);
			return;
		}
		boolean ret = wishservice.newWishlistElement(newwishelementname, newwishelementprice, selectedWishlist.getId());
		init();
		returnMessage(ret);
	}

	public void editListElement() {
		if (newwishelementname == null || newwishelementname.isEmpty() || selectedElement == null) {
			returnMessage(INPUT_FAIL);
			return;
		}
		boolean ret = wishservice.editWishlistElement(newwishelementname, newwishelementprice, selectedElement.getId());
		init();
		returnMessage(ret);
	}

	public void deleteListElement() {
		if (selectedElement == null) return;
		wishservice.deleteWishlistElement(selectedElement.getId());
		init();
	}

	public void setElementInputs() {
		newwishelementname = selectedElement.getName();
		newwishelementprice = selectedElement.getPrice();
	}

	private static void returnMessage(Object message) {
		String textmsg = "fail";
		if (message instanceof String) {
			textmsg = (String) message;
		} else if (message instanceof Boolean && (Boolean) message) {
			textmsg = "Success!";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(textmsg));
	}

	public List<Wishlist> getWishlists() {
		return wishlists;
	}

	public void setWishlists(List<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}

	public Wishlist getSelectedWishlist() {
		return selectedWishlist;
	}

	public void setSelectedWishlist(Wishlist selectedWishlist) {
		this.selectedWishlist = selectedWishlist;
	}

	public WishlistElement getSelectedElement() {
		return selectedElement;
	}

	public void setSelectedElement(WishlistElement selectedElement) {
		this.selectedElement = selectedElement;
	}

	public String getNewwishlistname() {
		return newwishlistname;
	}

	public void setNewwishlistname(String newwishlistname) {
		this.newwishlistname = newwishlistname;
	}

	public String getNewwishelementname() {
		return newwishelementname;
	}

	public void setNewwishelementname(String newwishelementname) {
		this.newwishelementname = newwishelementname;
	}

	public Integer getNewwishelementprice() {
		return newwishelementprice;
	}

	public void setNewwishelementprice(Integer newwishelementprice) {
		this.newwishelementprice = newwishelementprice;
	}

}
