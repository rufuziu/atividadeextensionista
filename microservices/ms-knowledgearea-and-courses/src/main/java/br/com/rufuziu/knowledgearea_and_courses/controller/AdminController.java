package br.com.rufuziu.knowledgearea_and_courses.controller;

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

    private final Logger log = LoggerFactory.getLogger(AdminController.class);

    public AdminController() {
    }


    @PatchMapping("v1/admin/active/user")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> userActivate(HttpServletRequest request) {

            return ResponseEntity.ok("Ok");
    }

}
