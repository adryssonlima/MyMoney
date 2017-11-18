package com.example.adrysson.mymoney.model;

import java.util.Date;

/**
 * Created by adrysson on 12/11/17.
 */

public class Despesa {

    private int id;
    private float valor;
    private String categoria;
    private String data;
    private String descricao;
    private int recorrente;

    public Despesa(float valor, String categoria, String data, String descricao, int recorrente) {
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
        this.descricao = descricao;
        this.recorrente = recorrente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getData() {
        return data.toString();
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getRecorrente() {
        return recorrente;
    }

    public void setRecorrente(int recorrente) {
        this.recorrente = recorrente;
    }
}
