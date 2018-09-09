package com.superdzen.userlist.controller;

import com.superdzen.userlist.dao.UserDaoImpl;
import com.superdzen.userlist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ShowUsersController {

    // add InitBinder to trim input strings
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    private UserDaoImpl userDaoImpl;

    @Autowired
    public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    // show all users
    @RequestMapping("/showUsers")
    public String showUsers(Model model) {
        List<User> users = userDaoImpl.listUsers();
        model.addAttribute("users", users);
        return "showusers";
    }

    // show users with filter or show all users if filter is empty
    @RequestMapping("/showUsersFilter")
    public String showUsersFilter(@ModelAttribute("filter") String filter, Model model) {
        List<User> users;
        if (filter == null) {
            users = userDaoImpl.listUsers();
        } else {
            users = userDaoImpl.listUsers(filter);
        }
        model.addAttribute("users", users);
        return "showusers";
    }

}
