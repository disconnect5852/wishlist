package com.wishlist.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wishlist.LoginInfo;
import com.wishlist.entity.User;
import com.wishlist.entity.Wishlist;
import com.wishlist.entity.WishlistElement;
import com.wishlist.repository.UserRepository;
import com.wishlist.repository.WishlistElementRepository;
import com.wishlist.repository.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService {
	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private WishlistRepository wishrepo;
	
	@Autowired
	private WishlistElementRepository wishelemrepo;
	
	@Autowired
	private UserRepository userrepo;

	@Autowired
	private LoginInfo logininfo;

	@Override
	public List<Wishlist> findWishlistsForCurrentUser() {
		Long userid = logininfo.getLoggedInUserId();
		log.debug("UserId: "+userid);
		if (userid != null) {
			return wishrepo.findAllByOwnerId(userid);
		}
		return null;
	}
	
	@Override
	public Wishlist findWishlistById(Long id) {
		return wishrepo.findById(id).orElse(null);
	}
	
	@Transactional
	@Override
	public boolean newWishlistForCurrentUser(String name) {
    	if (name!=null && !name.isEmpty()) {
    		User owner= userrepo.findById(logininfo.getLoggedInUserId()).orElse(null);
    		Wishlist list= new Wishlist(owner, name, new Date());
    		return wishrepo.save(list)!= null;
    	}
		return false;
	}
	
	@Transactional
	@Override
	public void deleteSelectedWishlist(Long id) {
		wishrepo.deleteById(id);
	}
	
	@Transactional
	@Override
	public boolean editWishlistElement(String wishelementname, Integer wishelementprice, Long id) {
		if (wishelementname!=null && !wishelementname.isEmpty()) {
			Optional<WishlistElement> element=wishelemrepo.findById(id);
			if (element.isPresent()) {
				WishlistElement elem= element.get();
				elem.setName(wishelementname);
				elem.setPrice(wishelementprice);
				elem.setCreateDate(new Date());
				return wishelemrepo.save(elem)!=null;
			}
		}
		return false;
	}	
	
	@Transactional
	@Override
	public boolean newWishlistElement(String newwishelementname, Integer newwishelementprice, Long ownerid) {
		if (newwishelementname!=null && !newwishelementname.isEmpty()) {
			Optional<Wishlist> owner=wishrepo.findById(ownerid);
			if (owner.isPresent()) {
				WishlistElement elem= new WishlistElement(owner.get(), newwishelementname, newwishelementprice, new Date());
				return wishelemrepo.save(elem)!=null;
			}
		}
		return false;
	}
	
	@Transactional
	@Override
	public void deleteWishlistElement(Long id) {
			log.debug("delete: "+id);
			wishelemrepo.forceDeleteById(id);
			 //wishelemrepo.deleteById(id);
	}	
}
