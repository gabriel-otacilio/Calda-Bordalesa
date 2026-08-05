package org.example.entity;

import jakarta.persistence.*;

@Table(name = "plantas")
@Entity
public class Planta {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "concentracao_max")
    private float concentracaoMax;
    @Column(name = "concentracao_min")
    private float concentracaoMin;
    @Column(name="descricao")
    private String descricao;

    public Planta( String nome, float concentracaoMax, float concentracaoMin, String descricao ) {
//        this.id = id;
        this.nome = nome;
        this.concentracaoMax = concentracaoMax;
        this.concentracaoMin = concentracaoMin;
        this.descricao = descricao;
    }

    public Planta() {

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getConcentracaoMax() {
        return concentracaoMax;
    }

    public void setConcentracaoMax(float concentracaoMax) {
        this.concentracaoMax = concentracaoMax;
    }

    public float getConcentracaoMin() {
        return concentracaoMin;
    }

    public void setConcentracaoMin(float concentracaoMin) {
        this.concentracaoMin = concentracaoMin;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
