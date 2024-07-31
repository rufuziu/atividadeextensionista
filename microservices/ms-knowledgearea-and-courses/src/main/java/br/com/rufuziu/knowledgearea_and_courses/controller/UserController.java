package br.com.rufuziu.knowledgearea_and_courses.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@Validated
public class UserController {
//    private final UserService userService;
//    private final JwtUtils jwtUtils;
//    private final Logger log = LoggerFactory.getLogger(UserController.class);
//
//    public UserController(UserService userService, JwtUtils jwtUtils) {
//        this.userService = userService;
//        this.jwtUtils = jwtUtils;
//    }
//
//    private String checkTokenIntegrity(String token)
//            throws JsonProcessingException {
//        jwtUtils.validateJwtToken(token);
//        String[] chunks = token.split("\\.");
//        Base64.Decoder decoder = Base64.getUrlDecoder();
//        String payload = new String(decoder.decode(chunks[1]));
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(payload);
//        return jsonNode.get("sub").asText();
//    }
//
//    @SecurityRequirement(name = "Bearer Authentication")
//    @GetMapping("v1/users/read/user")
//    public ResponseEntity<UserDTO> userRead(HttpServletRequest request) {
//        log.info(request.getRemoteAddr().concat(" is trying to read a user"));
//        try {
//            String token;
//
//            if (WebUtils.getCookie(request, "token") == null) {
//                token = request.getHeader("Authorization");
//                token = token.replaceAll("Bearer ", "");
//            } else {
//                token = WebUtils.getCookie(request, "token").getValue();
//            }
//
//            if (token != "") {
//                String email = checkTokenIntegrity(token);
//                UserDTO user = userService.readUser(email);
//                log.info(request.getRemoteAddr().concat(" will read a user"));
//                return ResponseEntity.ok(user);
//            } else {
//                log.info(request.getRemoteAddr().concat(" with invalid token"));
//                return ResponseEntity.badRequest().build();
//            }
//        } catch (Exception e) {
//            log.error(request.getRemoteAddr().concat(e.getMessage()));
//            return ResponseEntity.internalServerError().build();
//        }
//    }
//
//    @SecurityRequirement(name = "Bearer Authentication")
//    @PutMapping("v1/users/update/user")
//    public ResponseEntity<UserDTO> userUpdate(HttpServletRequest request,
//                                              @RequestBody @Valid UserDTO userDto) {
//        log.info(request.getRemoteAddr().concat(" is trying to update a user"));
//        try {
//            String token;
//
//            if (WebUtils.getCookie(request, "token") == null) {
//                token = request.getHeader("Authorization");
//                token = token.replaceAll("Bearer ", "");
//            } else {
//                token = WebUtils.getCookie(request, "token").getValue();
//            }
//
//            if (token != "") {
//                String email = checkTokenIntegrity(token);
//                userDto = userService.updateUser(userDto, email);
//                log.info(request.getRemoteAddr().concat(" updated the user"));
//                return ResponseEntity.ok()
//                        .body(userDto);
//            } else {
//                log.info(request.getRemoteAddr().concat(" with invalid token"));
//                return ResponseEntity.badRequest().build();
//            }
//        } catch (Exception e) {
//            log.error(request.getRemoteAddr().concat(e.getMessage()));
//            return ResponseEntity.internalServerError().build();
//        }
//    }

}
