package br.com.rufuziu.knowledgearea_and_courses.controller;

import br.com.rufuziu.knowledgearea_and_courses.dto.EducationLevelDTO;
import br.com.rufuziu.knowledgearea_and_courses.dto.KnowledgeAreaDTO;
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
public class KnowledgeAreaController {

    private final Logger log = LoggerFactory.getLogger(KnowledgeAreaController.class);

    public KnowledgeAreaController() {
    }

    @PostMapping("v1/knowledge-area/create")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> createKnowledgeArea(HttpServletRequest request,
                                                      @RequestBody KnowledgeAreaDTO knowledgeAreaDto) {

        return ResponseEntity.ok("Ok");
    }

    @GetMapping("v1/knowledge-area/read")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> readKnowledgeArea(HttpServletRequest request) {

            return ResponseEntity.ok("Ok");
    }

    @PutMapping("v1/knowledge-area/update")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> updateKnowledgeArea(HttpServletRequest request,
                                                     @RequestBody KnowledgeAreaDTO knowledgeAreaDto) {

        return ResponseEntity.ok("Ok");
    }

    @DeleteMapping("v1/knowledge-area/delete")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteKnowledgeArea(HttpServletRequest request,
                                                       @RequestBody KnowledgeAreaDTO knowledgeAreaDto) {

        return ResponseEntity.ok("Ok");
    }

}
