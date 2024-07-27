package br.com.rufuziu.crud_users_and_auth.controller;

import br.com.rufuziu.crud_users_and_auth.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/")
@Validated
public class AdminController {

    private final UserService userService;
    private final Logger log = LoggerFactory.getLogger(AdminController.class);

    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @PatchMapping("v1/admin/active/user/{email}")
    public ResponseEntity<String> userActivate(HttpServletRequest request,
                                               @PathVariable String email) {
        log.info(request.getRemoteAddr().concat(" is trying to activate the e-mail"));
        if (userService.activateUserByEmail(email) > 0){
            log.info(request.getRemoteAddr().concat(" activated the e-mail"));
            return ResponseEntity.ok("User activated!");
        }
        else{
            log.error(request.getRemoteAddr().concat(" not activated the e-mail"));
            return ResponseEntity.badRequest().build();
        }
    }

}
