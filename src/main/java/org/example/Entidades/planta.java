package org.example.Entidades;

public class planta {
    private String nome;
    private float concentracao_max;
    private float concentracao_min;
    private String descricao;

    public planta(String nome, float concentracao_max, float concentracao_min, String descricao) {
        this.nome = nome;
        this.concentracao_max = concentracao_max;
        this.concentracao_min = concentracao_min;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getConcentracao_max() {
        return concentracao_max;
    }

    public void setConcentracao_max(float concentracao_max) {
        this.concentracao_max = concentracao_max;
    }

    public float getConcentracao_min() {
        return concentracao_min;
    }

    public void setConcentracao_min(float concentracao_min) {
        this.concentracao_min = concentracao_min;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
