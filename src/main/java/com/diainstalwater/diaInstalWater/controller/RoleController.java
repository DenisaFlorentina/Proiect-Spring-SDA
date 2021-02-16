package com.diainstalwater.diaInstalWater.controller;

import com.diainstalwater.diaInstalWater.model.Role;
import com.diainstalwater.diaInstalWater.model.User;
import com.diainstalwater.diaInstalWater.service.RoleService;
import com.diainstalwater.diaInstalWater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @GetMapping("/roles")
    public String getroles(Model model){
        List<Role> roleList= roleService.findAllRoles();
        model.addAttribute("roles",  roleList);
        return "Role";
    }
    @PostMapping("/roles/addNew")
    public String addNew(Role role) {
        roleService.createRole(role);
        return "redirect:/roles";
    }
    @RequestMapping(value = "/roles/findById", method = RequestMethod.GET)
    @ResponseBody
    public Role findById(Long id){
        return roleService.getRoleById(id);
    }
    @RequestMapping(value = "/roles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Role role) {
        roleService.createRole(role);
        return "redirect:/roles";
    }
    @RequestMapping(value = "/roles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        roleService.deleteRoleById(id);
        return "redirect:/roles";
    }
  /*  @RequestMapping(value = "/roles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(@PathVariable Long id, @RequestBody Role role) {
        roleService.updateRole(id, role);
        return "redirect:/roles";
    }*/

}
