package br.com.rufuziu.ms_register_and_auth.controller;

import br.com.rufuziu.ms_register_and_auth.dto.user.UserToActivateDTO;
import br.com.rufuziu.ms_register_and_auth.services.AdminService;
import br.com.rufuziu.ms_register_and_auth.services.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/")
@Validated
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;
    private final Logger log = LoggerFactory.getLogger(AdminController.class);

    public AdminController(AdminService adminService,
                           UserService userService) {
        this.adminService = adminService;
        this.userService = userService;
    }


    @PatchMapping("v1/admin/active/user")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> userActivate(HttpServletRequest request,
                                               @RequestBody UserToActivateDTO userToActivateDTO) {
        log.info(request.getRemoteAddr().concat(" is trying to activate the e-mail"));
        if (userService.activateUserByEmail(userToActivateDTO).getActive()) {
            log.info(request.getRemoteAddr().concat(" activated the e-mail"));
            return ResponseEntity.ok("User activated!");
        } else {
            log.error(request.getRemoteAddr().concat(" not activated the e-mail"));
            return ResponseEntity.badRequest().build();
        }
    }

}
