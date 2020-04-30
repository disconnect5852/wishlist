package com.wishlist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wishlist.entity.User;
import com.wishlist.service.SecurityService;
import com.wishlist.service.UserService;
import com.wishlist.service.WishlistService;
import com.wishlist.validator.UserValidator;

@Controller
public class WishlistController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private WishlistService wishservice;

    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private JsfDTO dto;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/admin/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "admin/registration.jsp";
    }

    @PostMapping("/admin/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/admin/registration.jsp";
        }
        userService.save(userForm);
        return "redirect:/admin/admin";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login.jsp";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome.jsp";
    }
    
    @GetMapping({"/admin/admin"})
    public String admin() {
        return "admin/admin.xhtml";
    }
    
    @GetMapping({"/wishlist"})
	public String wishlist(/* @AuthenticationPrincipal MaiUserDetailz user */) {
        return "wishlist.xhtml";
    }
    
    @GetMapping(path = "/public/publicwish/{magic}")
	public String publicwish(@PathVariable long magic, Model model) {
    	System.out.println("Controller:"+magic);
    	dto.setHaxxor(""+magic);
        return "public/publicwish.xhtml";
    }
}
