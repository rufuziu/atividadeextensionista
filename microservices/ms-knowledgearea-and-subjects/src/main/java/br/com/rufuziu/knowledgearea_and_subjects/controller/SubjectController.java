package br.com.rufuziu.knowledgearea_and_subjects.controller;

import br.com.rufuziu.knowledgearea_and_subjects.dto.SubjectDTO;
import br.com.rufuziu.knowledgearea_and_subjects.services.SubjectService;
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
public class SubjectController {

    private final Logger log = LoggerFactory.getLogger(SubjectController.class);
    private final SubjectService subjectService;
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
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

    @GetMapping("v1/subject/readAll")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<SubjectDTO>> readAllSubjects(HttpServletRequest request) {
        return ResponseEntity.ok(subjectService.getAllSubjects());
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