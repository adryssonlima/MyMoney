package com.example.adrysson.mymoney.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by adrysson on 12/11/17.
 */

public class DataBaseCreate extends SQLiteOpenHelper {

    private static final String DBNAME = "mymoney";
    private static final int DBVERSION = 1;

    /* table receitas */
    public static final String TBL_RECEITAS = "receitas";
    public static final String TBL_RECEITAS_id = "id";
    public static final String TBL_RECEITAS_valor = "valor";
    public static final String TBL_RECEITAS_categoria = "categoria";
    public static final String TBL_RECEITAS_data = "data";
    public static final String TBL_RECEITAS_descricao = "descricao";
    public static final String TBL_RECEITAS_recebido = "recebido";
    public static final String TBL_RECEITAS_receita_fixa = "receita_fixa";

    /* table despesas */
    public static final String TBL_DESPESAS = "despesas";
    public static final String TBL_DESPESAS_id = "id";
    public static final String TBL_DESPESAS_valor = "valor";
    public static final String TBL_DESPESAS_categoria = "caegoria";
    public static final String TBL_DESPESAS_data = "data";
    public static final String TBL_DESPESAS_descricao = "descricao";
    public static final String TBL_DESPESAS_recorrente = "recorrente";

    /* table sonhos */
    public static final String TBL_SONHOS = "sonhos";
    public static final String TBL_SONHOS_id = "id";
    public static final String TBL_SONHOS_descricao = "descricao";
    public static final String TBL_SONHOS_foto = "foto";
    public static final String TBL_SONHOS_categoria = "categoria";
    public static final String TBL_SONHOS_motivacao = "motivacao";
    public static final String TBL_SONHOS_valor_total = "valor_total";
    public static final String TBL_SONHOS_saldo_inicial = "saldo_inicial";
    public static final String TBL_SONHOS_deposito_mensal = "deposito_mensal";

    /* table categorias */
    public static final String TBL_CATEGORIAS = "categorias";
    public static final String TBL_CATEGORIAS_id = "id";
    public static final String TBL_CATEGORIAS_nome = "nome";

    /* querys */
    private static final String CREATE_TBL_RECEITAS = "" +
            "CREATE TABLE " + TBL_RECEITAS + " ( " +
                TBL_RECEITAS_id + " integer primary key autoincrement, " +
                TBL_RECEITAS_valor + " real not null," +
                TBL_RECEITAS_categoria + " text not null, " +
                TBL_RECEITAS_data + " text not null, " +
                TBL_RECEITAS_descricao + " text, " +
                TBL_RECEITAS_recebido + " integer, " +
                TBL_RECEITAS_receita_fixa + " integer " +
            " ) ";
    private static final String CREATE_TBL_DESPESAS = "" +
            "CREATE TABLE " + TBL_DESPESAS + " ( " +
                TBL_DESPESAS_id + " integer primary key autoincrement, " +
                TBL_DESPESAS_valor + " real not null," +
                TBL_DESPESAS_categoria + " text not null, " +
                TBL_DESPESAS_data + " text not null, " +
                TBL_DESPESAS_descricao + " text, " +
                TBL_DESPESAS_recorrente + " integer " +
            " ) ";
    private static final String CREATE_TBL_SONHOS = "" +
            "CREATE TABLE " + TBL_SONHOS + " ( " +
                TBL_SONHOS_id + " integer primary key autoincrement, " +
                TBL_SONHOS_descricao + " text not null, " +
                TBL_SONHOS_foto + " string, " +
                TBL_SONHOS_categoria + " text not null, " +
                TBL_SONHOS_motivacao + " text, " +
                TBL_SONHOS_valor_total + " real not null, " +
                TBL_SONHOS_saldo_inicial + " real not null, " +
                TBL_SONHOS_deposito_mensal + " real not null " +
            " ) ";
    private static final String CREATE_TBL_CATEGORIAS = "" +
            "CREATE TABLE " + TBL_CATEGORIAS + " ( " +
                TBL_CATEGORIAS_id + " integer primary key autoincrement, " +
                TBL_CATEGORIAS_nome + " text not null" +
            " ) ";

    public DataBaseCreate(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TBL_RECEITAS);
        db.execSQL(CREATE_TBL_DESPESAS);
        db.execSQL(CREATE_TBL_SONHOS);
        db.execSQL(CREATE_TBL_CATEGORIAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS" + TBL_RECEITAS);
        db.execSQL("DROP TABLE IF EXISTS" + TBL_DESPESAS);
        db.execSQL("DROP TABLE IF EXISTS" + TBL_SONHOS);
        db.execSQL("DROP TABLE IF EXISTS" + TBL_CATEGORIAS);
        onCreate(db);
    }
}
