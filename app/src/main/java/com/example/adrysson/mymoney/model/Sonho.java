package com.example.adrysson.mymoney.model;

/**
 * Created by adrysson on 12/11/17.
 */

public class Sonho {

    private int id;
    private String descricao;
    private String foto;
    private String categoria;
    private String motivacao;
    private float valorTotal;
    private float saldoInicial;
    private float depositoMensal;

    public Sonho(String descricao, String foto, String categoria, String motivacao, float valorTotal,
                  float saldoInicial, float depositoMensal) {
        this.descricao = descricao;
        this.foto = foto;
        this.categoria = categoria;
        this.motivacao = motivacao;
        this.valorTotal = valorTotal;
        this.saldoInicial = saldoInicial;
        this.depositoMensal = depositoMensal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMotivacao() {
        return motivacao;
    }

    public void setMotivacao(String motivacao) {
        this.motivacao = motivacao;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public float getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(float saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public float getDepositoMensal() {
        return depositoMensal;
    }

    public void setDepositoMensal(float depositoMensal) {
        this.depositoMensal = depositoMensal;
    }
}
