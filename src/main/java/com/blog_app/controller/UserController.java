package com.blog_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog_app.constant.AppConstants;
import com.blog_app.entity.User;
import com.blog_app.response.ResponseMessageVo;
import com.blog_app.service.UserService;

@RestController
@RequestMapping(AppConstants.API)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Get all users — restricted to ADMIN only.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers() {
        ResponseMessageVo response = new ResponseMessageVo();
        try {
            List<User> users = userService.findAllUsers();
            response.setMessage("Users retrieved successfully");
            response.setStatus(200);
            response.setData(users);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error retrieving users");
            response.setStatus(500);
            response.setData(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete a user — restricted to ADMIN only.
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Object> deleteUserById(@PathVariable Long userId) {
        ResponseMessageVo response = new ResponseMessageVo();
        try {
            userService.deleteUser(userId);
            response.setMessage("User deleted successfully");
            response.setStatus(200);
            response.setData("");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error deleting user");
            response.setStatus(500);
            response.setData(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update a user's profile. Password is re-encoded if provided.
     */
    @PutMapping("/users/{userId}")
    public ResponseEntity<Object> update(@RequestBody User user, @PathVariable Long userId) {
        ResponseMessageVo response = new ResponseMessageVo();
        User updateUser = userService.findUserById(userId);

        if (updateUser == null) {
            response.setMessage("User not found");
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        try {
            if (user.getEmail() != null) {
                updateUser.setEmail(user.getEmail());
            }
            if (user.getUsername() != null) {
                updateUser.setUsername(user.getUsername());
            }
            // Password must be re-encoded before storing
            if (user.getPassword() != null && !user.getPassword().isBlank()) {
                updateUser.setPassword(passwordEncoder.encode(user.getPassword()));
            }

            userService.saveUser(updateUser);

            response.setMessage("User updated successfully");
            response.setStatus(HttpStatus.OK.value());
            response.setData(updateUser);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.setMessage("Error updating user");
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setData(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable Long userId) {
        ResponseMessageVo response = new ResponseMessageVo();
        try {
            User user = userService.findUserById(userId);
            response.setMessage("User found successfully");
            response.setStatus(200);
            response.setData(user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("User not found");
            response.setStatus(404);
            response.setData(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users/getByMail")
    public ResponseEntity<Object> getUserByEmail(@RequestParam String email) {
        ResponseMessageVo response = new ResponseMessageVo();
        try {
            User user = userService.findUserByEmail(email);
            response.setMessage("User found successfully");
            response.setStatus(200);
            response.setData(user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage("Error finding user");
            response.setStatus(500);
            response.setData(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
