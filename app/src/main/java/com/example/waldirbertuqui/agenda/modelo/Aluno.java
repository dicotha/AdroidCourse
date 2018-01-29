package com.example.waldirbertuqui.agenda.modelo;

/**
 * Created by waldir.bertuqui on 29/01/2018.
 */

public class Aluno {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String site;
    private Double ratingBar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Double getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(Double ratingBar) {
        this.ratingBar = ratingBar;
    }
}
