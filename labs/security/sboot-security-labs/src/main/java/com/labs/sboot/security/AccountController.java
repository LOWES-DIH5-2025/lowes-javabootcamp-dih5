package com.labs.sboot.security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@Slf4j
//@RequestMapping("/api/accounts")
public class AccountController {

    @GetMapping("/")
    public String home(Principal principal) {
        log.info("User Principal: {}", principal);
        return "Welcome to Banking App - Account Service API!!!";
    }



    @GetMapping("/accounts")
    public String getAccounts(Principal principal) {
        // This method would typically return a list of accounts
        log.info("User Principal: {}", principal);
        return "List of Accounts";
    }

    @PostMapping("/accounts")
    public String createAccount(@RequestBody String accountName)  {
        log.info("Creating account with name: {}", accountName);
        return "Account created successfully";
    }

@GetMapping("/csrf-token")
public String csrfToken(HttpServletRequest request) {
    org.springframework.security.web.csrf.CsrfToken csrfToken =
        (org.springframework.security.web.csrf.CsrfToken) request.getAttribute("_csrf");
    return csrfToken != null ? csrfToken.getToken() : "";
}
}
