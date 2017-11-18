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

    public SonhoView(Context context) {
        sonhoController = new SonhoController(context);
    }

    public boolean list() {
        return true;
    }

    public boolean insert(String descricao, String foto, int categoria, String motivacao, float valorTotal,
                         float saldoInicial, float depositoMensal) {
        sonho = new Sonho(descricao, foto, categoria, motivacao, valorTotal, saldoInicial, depositoMensal);
        return sonhoController.insert(sonho);
    }

    public boolean update() {
        return sonhoController.update(sonho);
    }

    public boolean delete() {
        return sonhoController.delete(sonho.getId());
    }
}
