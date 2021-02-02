package com.diainstalwater.diaInstalWater.controller;

import com.diainstalwater.diaInstalWater.model.User;
import com.diainstalwater.diaInstalWater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String getUsers() {
        return "User";
    }

    //Modified method to Add a new user User
    @PostMapping(value="users/addNew")
    public RedirectView addNew(User user, RedirectAttributes redir) {
        userService.save(user);
        RedirectView  redirectView= new RedirectView("/login",true);
        redir.addFlashAttribute("message",	"You successfully registered! You can now login");
        return redirectView;
    }
}
