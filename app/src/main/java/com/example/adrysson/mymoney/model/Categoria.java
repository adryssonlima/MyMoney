package com.example.adrysson.mymoney.model;

/**
 * Created by adrysson on 12/11/17.
 */

public class Categoria {

    private int id;
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
