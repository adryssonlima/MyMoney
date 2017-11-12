package com.example.adrysson.mymoney.view;

import android.content.Context;

import com.example.adrysson.mymoney.controller.CategoriaController;
import com.example.adrysson.mymoney.model.Categoria;

import java.lang.reflect.Array;

/**
 * Created by adrysson on 12/11/17.
 */

public class CategoriaView {

    private Categoria categoria;
    private CategoriaController categoriaController;

    public CategoriaView(Context context, String nome) {
        categoria = new Categoria(nome);
        categoriaController = new CategoriaController(context);
    }

    public Array list() {
        return categoriaController.list();
    }

    public String insert(Categoria categoria) {
        if (categoriaController.insert(categoria) )
            return "Categoria cadastrada com sucesso!";
        else
            return "Erro ao cadastrar categoria!";
    }

    public boolean update(Categoria categoria) {
        return categoriaController.update(categoria);
    }

    public boolean delete() {
        return categoriaController.delete(categoria.getId());
    }

}
