package ch.fhnw.pizza.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;


 
 

@RestController
public class WelcomeController {

    @GetMapping(value = "/")
    public String getWelcomeString() {
        return "Wela Wela!";
    }
    @GetMapping(value="/user")
    public String getUserRole(Authentication auth) {
        if (auth == null || !(auth.getPrincipal() instanceof UserDetails)) {
            return "NO_AUTH";
        }
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Object[] authorities = userDetails.getAuthorities().toArray();
        if (authorities.length > 0) {
            return authorities[0].toString();
        } else {
            return "NO_ROLE";
        }
    }
}
