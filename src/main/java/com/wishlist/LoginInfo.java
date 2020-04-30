package com.wishlist;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoginInfo {
    public Long getLoggedInUserId() {
    	Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if (principal instanceof MaiUserDetailz) {
    		return ((MaiUserDetailz) principal).getUserId();
        }
    	return null;
    }
}

    
