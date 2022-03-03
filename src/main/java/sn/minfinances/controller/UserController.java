package sn.minfinances.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sn.minfinances.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @RequestMapping(value = "/accueil", method = RequestMethod.GET)
    public String list(ModelMap map) {
        map.addAttribute("user", new User());

        return "accueil";
    }
    // security
    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String login() {

        return "admin";
    }



}