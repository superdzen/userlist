package com.superdzen.userlist.controller;

import com.superdzen.userlist.dao.UserDaoImpl;
import com.superdzen.userlist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class AddUserController {

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

    @RequestMapping("/newUser")
    public String showAddUserForm(Model model) {

        // add new User object as a model attribute
        model.addAttribute("user", new User());
        // return add new user form
        return "newuserform";
    }

    @RequestMapping("/processForm")
    public String processAddUserForm(@Valid @ModelAttribute("user") User user,
                                     BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // show form and warning
            return "newuserform";
        } else {
            // if validation succeeded -> add new User to DB
            userDaoImpl.insert(user);
            // redirect to showusers page
            return "redirect:/showUsers";
        }
    }

}
