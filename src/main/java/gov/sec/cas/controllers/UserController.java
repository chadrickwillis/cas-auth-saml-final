package gov.sec.cas.controllers; 

import gov.sec.cas.stereotypes.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Chadr
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    @GetMapping("/role")
    public ResponseEntity<User> getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        GrantedAuthority adminAuthority = new SimpleGrantedAuthority(ROLE_ADMIN);
        GrantedAuthority userAuthority = new SimpleGrantedAuthority(ROLE_USER);
        if (auth.getAuthorities().contains(adminAuthority)) {
            userAuthority = adminAuthority;
        }
        User user = new User.UserBuilder()
                .withRole(userAuthority.getAuthority())
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

