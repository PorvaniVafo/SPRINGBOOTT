package springboot.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.request.UserRequestDTO;
import springboot.response.UserResponseDTO;
import springboot.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Tag(
        name = "Controller of users"
)
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Updating user"
    )
    @SecurityRequirement(name = "JWT")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userService.update(id, userRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Getting user by id"
    )
    @SecurityRequirement(name = "JWT")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.get(id), HttpStatus.OK);
    }

    @GetMapping
    @Operation(
            summary = "Getting all users"
    )
    @SecurityRequirement(name = "JWT")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

}