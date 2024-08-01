package br.com.rufuziu.knowledgearea_and_courses.controller;

import br.com.rufuziu.knowledgearea_and_courses.dto.EducationLevelDTO;
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
public class EducationLevelController {

    private final Logger log = LoggerFactory.getLogger(EducationLevelController.class);

    public EducationLevelController() {
    }

    @PostMapping("v1/education-level/create")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> createEducationLevel(HttpServletRequest request,
                                                     @RequestBody EducationLevelDTO educationLevelDto) {

        return ResponseEntity.ok("Ok");
    }

    @GetMapping("v1/education-level/read")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> readEducationLevel(HttpServletRequest request) {

            return ResponseEntity.ok("Ok");
    }

    @PutMapping("v1/education-level/update")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> updateEducationLevel(HttpServletRequest request,
                                                     @RequestBody EducationLevelDTO educationLevelDto) {

        return ResponseEntity.ok("Ok");
    }

    @DeleteMapping("v1/education-level/delete")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteEducationLevel(HttpServletRequest request,
                                                       @RequestBody EducationLevelDTO educationLevelDto) {

        return ResponseEntity.ok("Ok");
    }

}
