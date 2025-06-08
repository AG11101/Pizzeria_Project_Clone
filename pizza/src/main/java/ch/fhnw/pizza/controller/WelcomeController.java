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
    @GetMapping(value="/user", produces = "application/json")
    public java.util.Map<String, String> getUserRole(Authentication auth) {
        String role;
        if (auth == null || !(auth.getPrincipal() instanceof UserDetails)) {
            role = "NO_AUTH";
        } else {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            Object[] authorities = userDetails.getAuthorities().toArray();
            if (authorities.length > 0) {
                role = authorities[0].toString();
            } else {
                role = "NO_ROLE";
            }
        }
        // Return as JSON object → Budibase will parse it!
        return java.util.Map.of("value", role);
    }
}
