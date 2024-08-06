package br.com.rufuziu.exercises.controller;

import br.com.rufuziu.exercises.dto.ExerciseDTO;
import br.com.rufuziu.exercises.services.ExerciseService;
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
public class ExerciseController {

    private final Logger log = LoggerFactory.getLogger(ExerciseController.class);
    private final ExerciseService exerciseService;
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("v1/exercise/create")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> createSubject(HttpServletRequest request,
                                                      @RequestBody ExerciseDTO exerciseDto) {

        return ResponseEntity.ok("Ok");
    }

    @GetMapping("v1/exercise/read")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> readSubject(HttpServletRequest request) {

            return ResponseEntity.ok("Ok");
    }

    @GetMapping("v1/exercise/readAll")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<ExerciseDTO>> readAllSubjects(HttpServletRequest request) {
        return ResponseEntity.ok(exerciseService.getAllSubjects());
    }

    @PutMapping("v1/exercise/update")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> updateSubject(HttpServletRequest request,
                                                     @RequestBody ExerciseDTO exerciseDto) {

        return ResponseEntity.ok("Ok");
    }

    @DeleteMapping("v1/exercise/delete")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteSubject(HttpServletRequest request,
                                                       @RequestBody ExerciseDTO exerciseDto) {

        return ResponseEntity.ok("Ok");
    }

}
