package com.pasifcode.cma_docs.domain.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_poa")
public class Poa extends Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poa_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    public Poa() {
    }

    @JsonCreator
    public Poa(String title, String grantee, String grantor, String description, String date, String location, String content, Long id, Client client, User user) {
        super(title, grantee, grantor, description, date, location, content);
        this.id = id;
        this.client = client;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
