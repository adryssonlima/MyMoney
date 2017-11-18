package com.example.adrysson.mymoney.view;

import android.content.Context;

import com.example.adrysson.mymoney.controller.ReceitaController;
import com.example.adrysson.mymoney.model.Receita;

import java.lang.reflect.Array;
import java.util.Date;

/**
 * Created by adrysson on 12/11/17.
 */

public class ReceitaView {

    private Receita receita;
    private ReceitaController receitaController;

    public ReceitaView(Context context) {
        receitaController = new ReceitaController(context);
    }

    public boolean list() {
        return true;
    }

    public boolean insert(float valor, int categoria, Date data,
                         String descricao, int recebido, int receitaFixa) {
        receita = new Receita(valor, categoria, data, descricao, recebido, receitaFixa);
        return receitaController.insert(receita);
    }

    public boolean update() {
        return receitaController.update(receita);
    }

    public boolean delete() {
        return receitaController.delete(receita.getId());
    }
}
