package br.com.rufuziu.crud_users_and_auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/test/v1/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/test/v1/student")
    @PreAuthorize("hasRole('ROLE_STUDENT') or hasRole('ROLE_TEACHER') or hasRole('ROLE_ADMIN')")
    public String studentAccess() {
        return "Student Content.";
    }

    @GetMapping("/test/v1/teacher")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String teacherAccess() {
        return "Teacher Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
