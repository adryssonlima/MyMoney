package com.example.adrysson.mymoney.controller;

import android.content.ContentValues;
import android.content.Context;
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

    public Array list() {

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

    }

    public boolean delete(int id) {

    }
}
