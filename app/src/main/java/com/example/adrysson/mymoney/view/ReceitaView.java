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

    public ReceitaView(Context context, float valor, int categoria, Date data,
                       String descricao, int recebido, int receitaFixa) {
        receita = new Receita(valor, categoria, data, descricao, recebido, receitaFixa);
        receitaController = new ReceitaController(context);
    }

    public Array list() {
        return receitaController.list();
    }

    public String insert() {
        if (receitaController.insert(receita) )
            return "Receita cadastrada com sucesso!";
        else
            return "Erro ao cadastrar receita!";
    }

    public boolean update() {
        return receitaController.update(receita);
    }

    public boolean delete() {
        return receitaController.delete(receita.getId());
    }
}
