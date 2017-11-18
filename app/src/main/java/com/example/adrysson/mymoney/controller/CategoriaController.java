package com.example.adrysson.mymoney.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public Cursor list() {
        db = banco.getReadableDatabase();
        String[] campos = {
                DataBaseCreate.TBL_CATEGORIAS_id,
                DataBaseCreate.TBL_CATEGORIAS_nome
        };
        Cursor c = db.query(DataBaseCreate.TBL_CATEGORIAS, campos, null, null, null, null, null, null);

        if(c != null)
            c.moveToFirst();

        db.close();

        return c;
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
        return true;
    }

    public boolean delete(int id) {
        return true;
    }

}
