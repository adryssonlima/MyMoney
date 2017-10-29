package com.example.adrysson.mymoney;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class CadastrarSonhoActivity extends AppCompatActivity {

    private String itensSpinner[] = {
            "Smartphone", "Roupas", "Carro", "Brinquedos", "Games",
            "Viagem", "Imóvel", "TV", "Notebook", "Computador",
            "Informática", "Casamento", "Videogame", "Lazer",
            "Poupança", "Investimentos", "Outros", "Móveis", "Reforma",
            "Educação", "Livros", "Dpividas"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_sonho);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Adapatador do spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner_categoria);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itensSpinner);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
