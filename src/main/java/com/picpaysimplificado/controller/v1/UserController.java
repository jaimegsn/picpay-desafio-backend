package com.picpaysimplificado.controller.v1;


import com.picpaysimplificado.domain.model.User;
import com.picpaysimplificado.dto.v1.UserDTO;
import com.picpaysimplificado.service.v1.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@Tag(name = "User", description = "Endpoints for managing users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @Operation(
        summary = "Create a user",
        description = "Create a user",
        tags = {"User"},
        responses = {
            @ApiResponse(description = "Created", responseCode = "201",
                content = {
                    @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = UserDTO.class)
                    )
                }
            ),
            @ApiResponse (description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse (description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse (description = "Internal Error", responseCode = "500", content = @Content)
        }
    )
    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        User user = userService.saveUser(userDTO);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @Operation(
        summary = "Find all users",
        description = "Find all users",
        tags = {"User"},
        responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                content = {
                    @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))
                    )
                }
            ),
            @ApiResponse (description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse (description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse (description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse (description = "Internal Error", responseCode = "500", content = @Content)
        }
    )
    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
}
