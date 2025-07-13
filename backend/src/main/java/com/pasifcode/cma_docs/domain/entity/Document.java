package com.pasifcode.cma_docs.domain.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/*
  grantee: outorgado
  grantor: outorgante
*/

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Document {

    private String title;
    @Column(columnDefinition="TEXT")
    private String grantee;
    @Column(columnDefinition="TEXT")
    private String grantor;
    @Column(columnDefinition="TEXT")
    private String description;
    private String date;
    private String location;
    @Column(columnDefinition="TEXT")
    private String content;

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

    public Document() {
    }

    public Document(String title, String grantee, String grantor, String description, String date, String location, String content) {
        this.title = title;
        this.grantee = grantee;
        this.grantor = grantor;
        this.description = description;
        this.date = date;
        this.location = location;
        this.content = content;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGrantee() {
        return grantee;
    }

    public void setGrantee(String grantee) {
        this.grantee = grantee;
    }

    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}