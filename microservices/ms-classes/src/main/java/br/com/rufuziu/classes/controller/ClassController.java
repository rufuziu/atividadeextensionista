package br.com.rufuziu.classes.controller;

import br.com.rufuziu.classes.dto.ClassDTO;
import br.com.rufuziu.classes.services.ClassService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/")
@Validated
public class ClassController {

    private final Logger log = LoggerFactory.getLogger(ClassController.class);
    private final ClassService classService;
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping("v1/classes/create")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> createSubject(HttpServletRequest request,
                                                      @RequestBody ClassDTO classDto) {

        return ResponseEntity.ok("Ok");
    }

    @GetMapping("v1/classes/read")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> readSubject(HttpServletRequest request) {

            return ResponseEntity.ok("Ok");
    }

    @PutMapping("v1/classes/update")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> updateSubject(HttpServletRequest request,
                                                     @RequestBody ClassDTO classDto) {

        return ResponseEntity.ok("Ok");
    }

    @DeleteMapping("v1/classes/delete")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteSubject(HttpServletRequest request,
                                                       @RequestBody ClassDTO classDto) {

        return ResponseEntity.ok("Ok");
    }

}
