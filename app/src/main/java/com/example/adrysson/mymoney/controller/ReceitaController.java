package com.example.adrysson.mymoney.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.adrysson.mymoney.helpers.DataBaseCreate;
import com.example.adrysson.mymoney.model.Receita;

import java.lang.reflect.Array;

/**
 * Created by adrysson on 12/11/17.
 */

public class ReceitaController {

    private SQLiteDatabase db;
    private DataBaseCreate banco;

    public ReceitaController(Context context) {
        banco = new DataBaseCreate(context);
    }

    public Cursor list() {
        db = banco.getReadableDatabase();
        String[] campos = {
                DataBaseCreate.TBL_RECEITAS_id,
                DataBaseCreate.TBL_RECEITAS_categoria,
                DataBaseCreate.TBL_RECEITAS_data,
                DataBaseCreate.TBL_RECEITAS_descricao,
                DataBaseCreate.TBL_RECEITAS_recebido,
                DataBaseCreate.TBL_RECEITAS_receita_fixa,
                DataBaseCreate.TBL_RECEITAS_valor
        };
        Cursor c = db.query(DataBaseCreate.TBL_RECEITAS, campos, null, null, null, null, null, null);

        if(c != null)
            c.moveToFirst();

        db.close();

        return c;
    }

    public boolean insert(Receita receita) {
        ContentValues values = new ContentValues();
        db = banco.getWritableDatabase();
        values.put(DataBaseCreate.TBL_RECEITAS_valor, receita.getValor());
        values.put(DataBaseCreate.TBL_RECEITAS_categoria, receita.getCategoria());
        values.put(DataBaseCreate.TBL_RECEITAS_data, receita.getData());
        values.put(DataBaseCreate.TBL_RECEITAS_descricao, receita.getDescricao());
        values.put(DataBaseCreate.TBL_RECEITAS_recebido, receita.getRecebido());
        values.put(DataBaseCreate.TBL_RECEITAS_receita_fixa, receita.getReceitaFixa());
        long result = db.insert(DataBaseCreate.TBL_RECEITAS, null, values);
        db.close();
        return result == -1 ? false : true;
    }

    public boolean update(Receita receita) {
        ContentValues values = new ContentValues();
        db = banco.getWritableDatabase();
        values.put(DataBaseCreate.TBL_RECEITAS_valor, receita.getValor());
        values.put(DataBaseCreate.TBL_RECEITAS_descricao, receita.getDescricao());
        values.put(DataBaseCreate.TBL_RECEITAS_data, receita.getData());
        values.put(DataBaseCreate.TBL_RECEITAS_categoria, receita.getCategoria());
        values.put(DataBaseCreate.TBL_RECEITAS_recebido, receita.getRecebido());
        values.put(DataBaseCreate.TBL_RECEITAS_receita_fixa, receita.getReceitaFixa());
        String selection = "ID = ?";
        String[] selectionArg = {Integer.toString(receita.getId())};
        long result = db.update(DataBaseCreate.TBL_RECEITAS, values, selection, selectionArg);
        db.close();
        return result == -1 ? false : true;
    }

    public boolean delete(int id) {
        ContentValues values = new ContentValues();
        db = banco.getWritableDatabase();
        String selection = "ID = ?";
        String[] selectionArg = {Integer.toString(id)};
        long result = db.delete(DataBaseCreate.TBL_RECEITAS, selection, selectionArg);
        db.close();
        return result == -1 ? false : true;
    }


}
