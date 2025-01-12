package com.datingengine.service;

import org.springframework.stereotype.Service;

import com.datingengine.dto.MatchResultDto;
import com.datingengine.model.User;
import com.datingengine.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userReopsitory;

    public UserService(UserRepository userRepository) {
        this.userReopsitory = userRepository;
    }

    public List<MatchResultDto> findMatches(Long userId, int limit) {
        User currentUser = userReopsitory.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return userReopsitory.findAll().stream()
                .filter(user -> !user.getId().equals(currentUser.getId())) // Exclude the current user
                .sorted(Comparator
                        .comparing((User u) -> u.getGender().equalsIgnoreCase(currentUser.getGender()) ? 1 : 0) // Gender Rule
                        .thenComparingInt(u -> Math.abs(u.getAge() - currentUser.getAge())) // Age Rule
                        .thenComparingInt(u -> -calculateMatchingInterests(u, currentUser))) // Interest Rule
                .limit(limit)
                .map(user -> new MatchResultDto(
                        user.getName(),
                        user.getAge(),
                        calculateMatchingInterests(user, currentUser)))
                .collect(Collectors.toList());
    }

    private int calculateMatchingInterests(User user1, User user2) {
        if (user1.getInterests() == null || user2.getInterests() == null) {
            return 0;
        }
        Set<String> user1Interests = new HashSet<>(Arrays.asList(user1.getInterests().split(",")));
        Set<String> user2Interests = new HashSet<>(Arrays.asList(user2.getInterests().split(",")));
        return (int) user1Interests.stream()
                .filter(user2Interests::contains)
                .count();
    }
}
