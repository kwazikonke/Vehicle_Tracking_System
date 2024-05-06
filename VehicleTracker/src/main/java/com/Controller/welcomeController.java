package com.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

@RestController
public class welcomeController {

	 @GetMapping("/greeting")
	    public String greeting(Authentication authentication) {

	        String userName = authentication.getName();

	        return "Spring Security In-memory Authentication Example - Welcome " + userName;
	    }
}
