package com.pasifcode.syncdoc.application.mapper;

import com.pasifcode.syncdoc.domain.dto.UserRequestDto;
import com.pasifcode.syncdoc.domain.dto.UserResponseDto;
import com.pasifcode.syncdoc.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponseDto toResponseDto(User entity) {

        if (entity == null) {
            return null;
        }

        return UserResponseDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .userRoles(entity.getUserRoles())
                .userBio(entity.getUserBio())
                .profileImage(entity.getProfileImage())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public User toEntity(UserRequestDto dto) {

        if (dto == null) {
            return null;
        }

        return User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .userRoles(dto.getUserRoles())
                .userBio(dto.getUserBio())
                .profileImage(dto.getProfileImage())
                .coverImage(dto.getCoverImage())
                .build();
    }
}
