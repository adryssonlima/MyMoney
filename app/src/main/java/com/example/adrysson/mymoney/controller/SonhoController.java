package com.example.adrysson.mymoney.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.adrysson.mymoney.helpers.DataBaseCreate;
import com.example.adrysson.mymoney.model.Receita;
import com.example.adrysson.mymoney.model.Sonho;

import java.lang.reflect.Array;

/**
 * Created by adrysson on 12/11/17.
 */

public class SonhoController {

    private SQLiteDatabase db;
    private DataBaseCreate banco;

    public SonhoController(Context context) {
        banco = new DataBaseCreate(context);
    }

    public Cursor list() {
        db = banco.getReadableDatabase();
        String[] campos = {
                DataBaseCreate.TBL_SONHOS_id,
                DataBaseCreate.TBL_SONHOS_descricao,
                DataBaseCreate.TBL_SONHOS_foto,
                DataBaseCreate.TBL_SONHOS_categoria,
                DataBaseCreate.TBL_SONHOS_motivacao,
                DataBaseCreate.TBL_SONHOS_valor_total,
                DataBaseCreate.TBL_SONHOS_saldo_inicial,
                DataBaseCreate.TBL_SONHOS_deposito_mensal
        };
        Cursor c = db.query(DataBaseCreate.TBL_SONHOS, campos, null, null, null, null, null, null);

        if(c != null)
            c.moveToFirst();

        db.close();

        return c;
    }

    public boolean insert(Sonho sonho) {
        ContentValues values = new ContentValues();
        db = banco.getWritableDatabase();
        values.put(DataBaseCreate.TBL_SONHOS_descricao, sonho.getDescricao());
        values.put(DataBaseCreate.TBL_SONHOS_foto, sonho.getFoto());
        values.put(DataBaseCreate.TBL_SONHOS_categoria, sonho.getCategoria());
        values.put(DataBaseCreate.TBL_SONHOS_motivacao, sonho.getMotivacao());
        values.put(DataBaseCreate.TBL_SONHOS_valor_total, sonho.getValorTotal());
        values.put(DataBaseCreate.TBL_SONHOS_saldo_inicial, sonho.getSaldoInicial());
        values.put(DataBaseCreate.TBL_SONHOS_deposito_mensal, sonho.getDepositoMensal());
        long result = db.insert(DataBaseCreate.TBL_SONHOS, null, values);
        db.close();
        return result == -1 ? false : true;
    }

    public boolean update(Sonho sonho) {
        ContentValues values = new ContentValues();
        db = banco.getWritableDatabase();
        values.put(DataBaseCreate.TBL_SONHOS_descricao, sonho.getDescricao());
        values.put(DataBaseCreate.TBL_SONHOS_foto, sonho.getFoto());
        values.put(DataBaseCreate.TBL_SONHOS_categoria, sonho.getCategoria());
        values.put(DataBaseCreate.TBL_SONHOS_motivacao, sonho.getMotivacao());
        values.put(DataBaseCreate.TBL_SONHOS_saldo_inicial, sonho.getSaldoInicial());
        values.put(DataBaseCreate.TBL_SONHOS_valor_total, sonho.getValorTotal());
        values.put(DataBaseCreate.TBL_SONHOS_deposito_mensal, sonho.getDepositoMensal());
        String selection = "ID = ?";
        String[] selectionArg = {Integer.toString(sonho.getId())};
        long result = db.update(DataBaseCreate.TBL_SONHOS, values, selection, selectionArg);
        db.close();
        return result == -1 ? false : true;
    }

    public boolean delete(int id) {
        ContentValues values = new ContentValues();
        db = banco.getWritableDatabase();
        String selection = "ID = ?";
        String[] selectionArg = {Integer.toString(id)};
        long result = db.delete(DataBaseCreate.TBL_SONHOS, selection, selectionArg);
        db.close();
        return result == -1 ? false : true;
    }
}
