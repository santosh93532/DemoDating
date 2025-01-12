package com.datingengine.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.datingengine.dto.MatchResultDto;
import com.datingengine.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint to get matching users
    @GetMapping("/{userId}/matches")
    public ResponseEntity<List<MatchResultDto>> getMatches(
            @PathVariable Long userId, 
            @RequestParam(defaultValue = "5") int limit) {
        
        List<MatchResultDto> matches = userService.findMatches(userId, limit);
        
        return ResponseEntity.ok(matches);  // Return 200 OK with matches list
    }
}
