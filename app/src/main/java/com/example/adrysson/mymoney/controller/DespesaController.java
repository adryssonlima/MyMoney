package com.example.adrysson.mymoney.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import com.example.adrysson.mymoney.helpers.DataBaseCreate;
import com.example.adrysson.mymoney.model.Despesa;

import java.lang.reflect.Array;

/**
 * Created by adrysson on 12/11/17.
 */

public class DespesaController {

    private SQLiteDatabase db;
    private DataBaseCreate banco;

    public DespesaController(Context context) {
        banco = new DataBaseCreate(context);
    }

    public Cursor list() {
        db = banco.getReadableDatabase();
        String[] campos = {
                DataBaseCreate.TBL_DESPESAS_id,
                DataBaseCreate.TBL_DESPESAS_descricao,
                DataBaseCreate.TBL_DESPESAS_categoria,
                DataBaseCreate.TBL_DESPESAS_data,
                DataBaseCreate.TBL_DESPESAS_valor,
                DataBaseCreate.TBL_DESPESAS_recorrente
        };
        Cursor c = db.query(DataBaseCreate.TBL_DESPESAS, campos, null, null, null, null, null, null);

        if(c != null)
            c.moveToFirst();

        db.close();

        return c;
    }

    public boolean insert(Despesa despesa) {
        ContentValues values = new ContentValues();
        db = banco.getWritableDatabase();
        values.put(DataBaseCreate.TBL_DESPESAS_valor, despesa.getValor());
        values.put(DataBaseCreate.TBL_DESPESAS_categoria, despesa.getCategoria());
        values.put(DataBaseCreate.TBL_DESPESAS_data, despesa.getData());
        values.put(DataBaseCreate.TBL_DESPESAS_descricao, despesa.getDescricao());
        values.put(DataBaseCreate.TBL_DESPESAS_recorrente, despesa.getRecorrente());
        long result = db.insert(DataBaseCreate.TBL_DESPESAS, null, values);
        db.close();
        return result == -1 ? false : true;

    }

    public boolean update(Despesa despesa) {
        ContentValues values = new ContentValues();
        db = banco.getWritableDatabase();
        values.put(DataBaseCreate.TBL_DESPESAS_descricao, despesa.getDescricao());
        values.put(DataBaseCreate.TBL_DESPESAS_data, despesa.getData());
        values.put(DataBaseCreate.TBL_DESPESAS_categoria, despesa.getCategoria());
        values.put(DataBaseCreate.TBL_DESPESAS_valor, despesa.getValor());
        values.put(DataBaseCreate.TBL_DESPESAS_recorrente, despesa.getRecorrente());
        String selection = "ID = ?";
        String[] selectionArg = {Integer.toString(despesa.getId())};
        long result = db.update(DataBaseCreate.TBL_DESPESAS, values, selection, selectionArg);
        db.close();
        return result == -1 ? false : true;
    }

    public boolean delete(int id) {
        ContentValues values = new ContentValues();
        db = banco.getWritableDatabase();
        String selection = "ID = ?";
        String[] selectionArg = {Integer.toString(id)};
        long result = db.delete(DataBaseCreate.TBL_DESPESAS, selection, selectionArg);
        db.close();
        return result == -1 ? false : true;
    }
}
