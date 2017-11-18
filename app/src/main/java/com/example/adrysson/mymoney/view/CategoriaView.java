package com.example.adrysson.mymoney.view;

import android.content.Context;
import android.database.Cursor;

import com.example.adrysson.mymoney.controller.CategoriaController;
import com.example.adrysson.mymoney.model.Categoria;

import java.lang.reflect.Array;

import static com.example.adrysson.mymoney.R.id.categoria;

/**
 * Created by adrysson on 12/11/17.
 */

public class CategoriaView {

    private Categoria categoria;
    private CategoriaController categoriaController;

    public CategoriaView(Context context) {
        categoriaController = new CategoriaController(context);
    }

    public Cursor list() {
        Cursor cursor = categoriaController.list();
        return cursor;
    }

    public boolean insert(String nome) {
        categoria = new Categoria(nome);
        return categoriaController.insert(categoria);
    }

    public boolean update(Categoria categoria) {
        return categoriaController.update(categoria);
    }

    public boolean delete(int id) {
        return categoriaController.delete(id);
    }

}
