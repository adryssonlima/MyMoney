package com.example.adrysson.mymoney;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.adrysson.mymoney.helpers.DataBaseCreate;
import com.example.adrysson.mymoney.view.CategoriaView;

public class CategoriaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String itensList[] = {
        "Alimentação",
        "Educação",
        "Moradia",
        "Pagamentos",
        "Roupa",
        "Saúde",
        "Transporte"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Adapatador da lista
        ListView list = (ListView) findViewById(R.id.list_categoria);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itensList);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            AlertDialog.Builder builder = new AlertDialog.Builder(CategoriaActivity.this);
            builder.setTitle("Nova Categoria");

            // Set up the input
            final EditText input = new EditText(CategoriaActivity.this);
            // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            // INSERT
            builder.setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String nome = input.getText().toString();
                    CategoriaView categoria = new CategoriaView(getBaseContext());
                    if ( categoria.insert(nome) ) {
                        finish(); // restarta a activity
                        startActivity(getIntent());
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Erro ao cadastrar categoria", Toast.LENGTH_LONG).show();
                    }

                }
            });
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();

//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
        Object obj = adapterView.getAdapter().getItem(posicao);
        if (obj != null) {
            String item = obj.toString();
            Intent intentCategoriaDetalhes = new Intent(this, CategoriaDetalhesActivity.class);
            intentCategoriaDetalhes.putExtra("CATEGORIA", item);
            startActivity(intentCategoriaDetalhes);
        } else {
            Toast.makeText(this,
                "Nenhum item selecionado",
                Toast.LENGTH_LONG).show();
        }
    }
}
