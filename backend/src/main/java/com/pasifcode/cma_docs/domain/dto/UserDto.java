package com.pasifcode.cma_docs.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pasifcode.cma_docs.domain.entity.User;
import com.pasifcode.cma_docs.domain.enums.UserRoles;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String email;
    private String password;
    private UserRoles userRoles;
    private String userImage;
    private String userCoverImage;
    private String userBio;
    private String userLocation;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime createdDate;

    @JsonCreator
    public UserDto() {
    }

    public UserDto(User entity) {
        id = entity.getId();
        username = entity.getUsername();
        email = entity.getEmail();
        password = entity.getPassword();
        userRoles = entity.getUserRoles();
        userImage = entity.getImage();
        userCoverImage = entity.getCoverImage();
        userBio = entity.getUserBio();
        userLocation = entity.getUserLocation();
        createdDate = entity.getCreatedDate();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserRoles getUserRoles() {
        return userRoles;
    }

    public String getUserImage() {
        return userImage;
    }

    public String getUserCoverImage() {
        return userCoverImage;
    }

    public String getUserBio() {
        return userBio;
    }

    public String getUserLocation() {
        return userLocation;
    }

    @JsonProperty
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
