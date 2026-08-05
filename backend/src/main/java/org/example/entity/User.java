package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;

@Table(name = "usuarios")
@Entity
public class User {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="nome")
    private String nome;
    @Column(name="senha")
    private String senha;
    @Column(name="email")
    private String email;
    @Column(name="user_name")
    private String userName;

    public User(int id, String nome, String senha, String email, String userName) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.userName = userName;
    }

    public User() { // construtor do Spring

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
