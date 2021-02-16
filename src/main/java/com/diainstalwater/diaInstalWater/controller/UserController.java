package com.diainstalwater.diaInstalWater.controller;

import com.diainstalwater.diaInstalWater.model.*;
import com.diainstalwater.diaInstalWater.repository.UserRepository;
import com.diainstalwater.diaInstalWater.service.RoleService;
import com.diainstalwater.diaInstalWater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserRepository userRepository;

   /* @GetMapping("/users")
    public String getUsers() {
        return "User";
    }*/


    @PostMapping(value="users/addNew")
    public RedirectView addNew(User user, RedirectAttributes redir)  {

      /*  Class c=Class.forName("Role");
        List<Role> roles = new ArrayList<>();
        for (Role role: user.getRoles()) {
            String roleName = role.getName();
            Role roleNameObj = roleName;
            roles.add(roleNameObj);
        }*/





        userService.save(user);
        RedirectView  redirectView= new RedirectView("/login",true);
        redir.addFlashAttribute("message",	"You successfully registered! You can now login");
        return redirectView;
    }


    @GetMapping("/users")
    public String getUsers(Model model, Long id){
        List<User> userList= userService.findAllUsers();
        model.addAttribute("users",  userList);

        //Role role= roleService.getRoleById(id);
        List<Role> roleList = roleService.findAllRoles();
        model.addAttribute("roles", roleList);
       return "User";
    }


   @RequestMapping(value = "/users/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(User user) {
        userService.save(user);
        return "redirect:/users";
    }
   @RequestMapping(value = "/users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    @ResponseBody
    public User findById(Long id){
        return userService.getUserById(id);
    }

//  @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
//  public User getUserById(@PathVariable Long id) {
//      return userService.getUserById(id);
//  }

  /*  @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return userService.getUserById(id);
    }*/

    /*@GetMapping("/user/findById/{id}")
    public User getUser(@PathVariable Long id) {
        if(userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        else return  null;
    }*/

   /* @PutMapping("/user/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(user, id);
       // return "redirect:/users";

    }*/
}
