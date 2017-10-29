package com.example.adrysson.mymoney;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SonhosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String itensList[] = {
        "Trocar Smartphone",
        "Comprar um Carro",
        "Fazer uma Viagem",
        "Quitar Dívida"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonhos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Adapatador da lista
        ListView list = (ListView) findViewById(R.id.list_sonhos);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itensList);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCadastrarSonho = new Intent(SonhosActivity.this, CadastrarSonhoActivity.class);
                startActivity(intentCadastrarSonho);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
        Object obj = adapterView.getAdapter().getItem(posicao);
        if (obj != null) {
//            String item = obj.toString();
//            Intent intentSonhoDetalhes = new Intent(this, SonhoDetalhesActivity.class);
//            intentSonhoDetalhes.putExtra("SONHO", item);
//            startActivity(intentSonhoDetalhes);
        } else {
            Toast.makeText(this,
                    "Nenhum item selecionado",
                    Toast.LENGTH_LONG).show();
        }
    }

}
