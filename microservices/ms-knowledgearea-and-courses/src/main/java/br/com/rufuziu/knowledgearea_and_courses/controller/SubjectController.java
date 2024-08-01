package br.com.rufuziu.knowledgearea_and_courses.controller;

import br.com.rufuziu.knowledgearea_and_courses.dto.SubjectDTO;
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
public class SubjectController {

    private final Logger log = LoggerFactory.getLogger(SubjectController.class);

    public SubjectController() {
    }

    @PostMapping("v1/subject/create")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> createSubject(HttpServletRequest request,
                                                      @RequestBody SubjectDTO subjectDto) {

        return ResponseEntity.ok("Ok");
    }

    @GetMapping("v1/subject/read")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> readSubject(HttpServletRequest request) {

            return ResponseEntity.ok("Ok");
    }

    @PutMapping("v1/subject/update")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> updateSubject(HttpServletRequest request,
                                                     @RequestBody SubjectDTO subjectDto) {

        return ResponseEntity.ok("Ok");
    }

    @DeleteMapping("v1/subject/delete")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteSubject(HttpServletRequest request,
                                                       @RequestBody SubjectDTO subjectDto) {

        return ResponseEntity.ok("Ok");
    }

}
