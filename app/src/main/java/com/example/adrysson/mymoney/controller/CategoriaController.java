package com.example.adrysson.mymoney.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.adrysson.mymoney.model.Categoria;

import com.example.adrysson.mymoney.helpers.DataBaseCreate;

import java.lang.reflect.Array;

/**
 * Created by adrysson on 12/11/17.
 */

public class CategoriaController {

    private SQLiteDatabase db;
    private DataBaseCreate banco;

    public CategoriaController(Context context) {
        banco = new DataBaseCreate(context);
    }

    public Array list() {

    }

    public boolean insert(Categoria categoria) {
        ContentValues values = new ContentValues();
        db = banco.getWritableDatabase();
        values.put(DataBaseCreate.TBL_CATEGORIAS_nome, categoria.getNome());
        long result = db.insert(DataBaseCreate.TBL_CATEGORIAS, null, values);
        db.close();
        return result == -1 ? false : true;
    }

    public boolean update(Categoria categoria) {

    }

    public boolean delete(int id) {

    }

}
