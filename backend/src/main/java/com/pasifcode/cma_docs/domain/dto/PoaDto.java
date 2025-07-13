package com.pasifcode.cma_docs.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pasifcode.cma_docs.domain.entity.Poa;

import java.io.Serializable;
import java.time.LocalDateTime;


public class PoaDto implements Serializable {
    private Long id;
    private String title;
    private String grantee;
    private String grantor;
    private String description;
    private String date;
    private String location;
    private String content;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime createdDate;

    private Long userId;
    private String username;
    private String clientName;

    @JsonCreator
    public PoaDto() {
    }

    public PoaDto(Poa poa) {
        id = poa.getId();
        title = poa.getTitle();
        grantee = poa.getGrantee();
        grantor = poa.getGrantor();
        description = poa.getDescription();
        date = poa.getDate();
        location = poa.getLocation();
        content = poa.getContent();
        createdDate = poa.getCreatedDate();
        userId = poa.getUser().getId();
        username = poa.getUser().getUsername();
        clientName = poa.getClient().getClientName();
    }

    public Long getId() {
        return id;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getGrantee() {
        return grantee;
    }

    @JsonProperty
    public String getGrantor() {
        return grantor;
    }

    @JsonProperty
    public String getLocation() {
        return location;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public String getDate() {
        return date;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    @JsonProperty
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @JsonProperty
    public Long getUserId() {
        return userId;
    }

    @JsonProperty
    public String getUsername() {
        return username;
    }

    @JsonProperty
    public String getClientName() {
        return clientName;
    }
}
