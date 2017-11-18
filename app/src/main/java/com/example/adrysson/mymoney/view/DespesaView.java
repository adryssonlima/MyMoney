package com.example.adrysson.mymoney.view;

import android.content.Context;
import android.database.Cursor;

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

    public DespesaView(Context context) {
        despesaController = new DespesaController(context);
    }

    public boolean list() {
        return true;
    }

    public boolean insert(float valor, String categoria, String data, String descricao, int recorrente) {
        despesa = new Despesa(valor, categoria, data, descricao, recorrente);
        return despesaController.insert(despesa);
    }

    public boolean update() {
        return despesaController.update(despesa);
    }

    public boolean delete() {
        return despesaController.delete(despesa.getId());
    }
}
