package com.example.adrysson.mymoney.model;

import java.util.Date;

/**
 * Created by adrysson on 12/11/17.
 */

public class Receita {

    private int id;
    private float valor;
    private int categoria;
    private Date data;
    private String descricao;
    private int recebido;
    private int receitaFixa;

    public Receita(float valor, int categoria, Date data, String descricao, int recebido, int receitaFixa) {
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
        this.descricao = descricao;
        this.recebido = recebido;
        this.receitaFixa = receitaFixa;
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

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getData() {
        return data.toString();
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getRecebido() {
        return recebido;
    }

    public void setRecebido(int recebido) {
        this.recebido = recebido;
    }

    public int getReceitaFixa() {
        return receitaFixa;
    }

    public void setReceitaFixa(int receitaFixa) {
        this.receitaFixa = receitaFixa;
    }
}
