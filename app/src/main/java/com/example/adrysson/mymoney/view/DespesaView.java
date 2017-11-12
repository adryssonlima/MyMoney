package com.example.adrysson.mymoney.view;

import android.content.Context;

import com.example.adrysson.mymoney.controller.CategoriaController;
import com.example.adrysson.mymoney.controller.DespesaController;
import com.example.adrysson.mymoney.model.Categoria;
import com.example.adrysson.mymoney.model.Despesa;

import java.lang.reflect.Array;
import java.util.Date;

/**
 * Created by adrysson on 12/11/17.
 */

public class DespesaView {

    private Despesa despesa;
    private DespesaController despesaController;

    public DespesaView(Context context, float valor, int categoria, Date data, String descricao, int recorrente) {
        despesa = new Despesa(valor, categoria, data, descricao, recorrente);
        despesaController = new DespesaController(context);
    }

    public Array list() {
        return despesaController.list();
    }

    public String insert() {
        if (despesaController.insert(despesa) )
            return "Despesa cadastrada com sucesso!";
        else
            return "Erro ao cadastrar despesa!";
    }

    public boolean update() {
        return despesaController.update(despesa);
    }

    public boolean delete() {
        return despesaController.delete(despesa.getId());
    }
}
