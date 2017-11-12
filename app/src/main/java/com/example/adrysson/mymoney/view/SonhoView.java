package com.example.adrysson.mymoney.view;

import android.content.Context;

import com.example.adrysson.mymoney.controller.SonhoController;
import com.example.adrysson.mymoney.model.Sonho;

import java.lang.reflect.Array;

/**
 * Created by adrysson on 12/11/17.
 */

public class SonhoView {

    private Sonho sonho;
    private SonhoController sonhoController;

    public SonhoView(Context context, String descricao, String foto, int categoria, String motivacao, float valorTotal,
                     float saldoInicial, float depositoMensal) {
        sonho = new Sonho(descricao, foto, categoria, motivacao, valorTotal, saldoInicial, depositoMensal);
        sonhoController = new SonhoController(context);
    }

    public Array list() {
        return sonhoController.list();
    }

    public String insert() {
        if (sonhoController.insert(sonho) )
            return "Receita cadastrada com sucesso!";
        else
            return "Erro ao cadastrar receita!";
    }

    public boolean update() {
        return sonhoController.update(sonho);
    }

    public boolean delete() {
        return sonhoController.delete(sonho.getId());
    }
}
